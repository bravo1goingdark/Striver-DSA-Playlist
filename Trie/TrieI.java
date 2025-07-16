package Trie;

class TrieI {
    private final Node root;

    public TrieI() {
        this.root = new Node();
    }

    public void insert(String word) {
        if (word.isEmpty()) return;
        Node node = this.root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    public boolean search(String word) {
        if (word.isEmpty()) return false;
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return false;

        Node node = root;

        for (char ch : prefix.toCharArray()){
            if (!node.containsKey(ch)){
                return false;
            }

            node = node.get(ch);
        }

        return true;
    }
}

