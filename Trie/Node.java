package Trie;

public class Node {
    private Node[] alphabet;
    private boolean isEndOfTheWord;


    public Node() {
        this.alphabet = new Node[26];
        this.isEndOfTheWord = false;
    }


    public boolean containsKey(char ch) {
        return alphabet[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return alphabet[ch - 'a'];
    }

    public void put(char ch, Node node) {
        alphabet[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return this.isEndOfTheWord;
    }

    public void setEnd() {
        this.isEndOfTheWord = true;
    }


}
