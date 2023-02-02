package spell;

public class Trie implements ITrie {

    private Node root;

    public Trie() {
        this.root = new Node();
    }
    @Override
    public void add(String word) {
        System.out.println(word);
    }

    @Override
    public INode find(String word) {
        return null;
    }

    @Override
    public int getWordCount() {
        return 0;
    }

    @Override
    public int getNodeCount() {
        return 0;
    }
}
