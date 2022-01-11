package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//Note: Use search store interface to support different types of search data structures
public class Trie {
    private Trie[] nodes = new Trie[26];
    private boolean isEndOfWord;
    private String word;
    //Add relevance strategy interface variable

    public Trie() {
        isEndOfWord = false;
    }

    public Trie insert(String word) {
        word = word.toLowerCase(Locale.ROOT);
        Trie traversalNode = this;

        for(char c : word.toCharArray()) {
            if(c == ' ') continue;
            if(traversalNode.nodes[c - 'a'] == null) {
                traversalNode.nodes[c - 'a'] = new Trie();
            }
            traversalNode = traversalNode.nodes[c-'a'];
        }
        traversalNode.isEndOfWord = true;
        traversalNode.word = word;
        return this;
    }

    public List<String> search(String query) {
        query = query.toLowerCase(Locale.ROOT);
        Trie traversalNode = this;

        List<String> results = new ArrayList<>();

        for(char c : query.toCharArray()) {
            if(c == ' ') continue;
            if(traversalNode.nodes[c - 'a'] == null) {
                return null;
            }
            traversalNode = traversalNode.nodes[c-'a'];
            if(traversalNode.isEndOfWord) {
                results.add(traversalNode.word);
            }
        }

        results.addAll(getAllWordsWithPrefix(traversalNode));

        //Use supplied relevance strategy in constructor to sort and filter results before returning
        return results;
    }

    private List<String> getAllWordsWithPrefix(Trie nodeToSearch) {
        List<String> results = new ArrayList<>();

        if(nodeToSearch.isEndOfWord) {
            results.add(nodeToSearch.word);
        }

        for (Trie trieNode: nodeToSearch.nodes) {
            if(trieNode == null) {
                continue;
            }
            results.addAll(getAllWordsWithPrefix(trieNode));
        }

        return results;
    }
}
