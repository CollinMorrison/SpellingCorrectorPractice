package spell;

public class Trie implements ITrie {

    private Node root;

    public Trie() {
        this.root = new Node();
    }
    @Override
    public void add(String word) {
        word = word.toLowerCase();
        System.out.println(word);

        int currentIndex = 0;
        Node currentNode = this.root;

        StringBuilder newWord = new StringBuilder(word);
        for (int i = 0; i < newWord.length(); ++i) {
            char currentCharacter = newWord.charAt(i);
            currentIndex = currentCharacter - 'a';
            //System.out.println("Index: " + currentIndex + " Character: " + currentCharacter);
            //if the current letter doesn't exist, add it
            if (currentNode.getChildren()[currentIndex] == null) {
                currentNode.getChildren()[currentIndex] = new Node();
                //System.out.println("node added at " + currentCharacter);
            }
            else {
                //System.out.println("node exists");
            }
            //set the next node
            currentNode = currentNode.getChildren()[currentIndex];

            //if this is the last character, increment the node's value
            if (i == newWord.length() - 1) {
                currentNode.incrementValue();
                //System.out.println("Node's value incremented to " + currentNode.getValue());
            }
        }
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
