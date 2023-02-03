package spell;

public class Trie implements ITrie {

    private Node root;
    private int wordCount;
    private int nodeCount;

    public Trie() {
        this.root = new Node();
        this.wordCount = 0;
        this.nodeCount = 0;
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
                ++this.nodeCount;
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
                ++this.wordCount;
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
        return this.wordCount;
    }

    @Override
    public int getNodeCount() {
        return this.nodeCount;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
       StringBuilder output = new StringBuilder();
       StringBuilder currentWord = new StringBuilder();
        toStringHelper(this.root, currentWord, output);
       return output.toString();
    }

    private void toStringHelper(Node currentNode, StringBuilder currentWord, StringBuilder output)  {
        //if the current node signifies the end of a word, add that word to the output
        if (currentNode.getValue() > 0) {
            output.append(currentWord);
            output.append("\n");
        }
        //for each of the children, if the node isn't null, recurse over that child
        for (int i = 0; i < currentNode.getChildren().length; ++i) {
            if (currentNode.getChildren()[i] != null) {
                currentWord.append((char)('a' + i));
                toStringHelper(currentNode.getChildren()[i], currentWord, output);
                //update the current word to accurately reflect where we are in the trie
                //ie. delete the last character
                currentWord.deleteCharAt(currentWord.length() - 1);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Trie)) {
            return false;
        }
        Trie t = (Trie)o;
        if (this.nodeCount != t.getNodeCount() || this.wordCount != t.getWordCount()) {
            return false;
        }
        //else traverse both tries simultaneously, checking for differences
        return equalsHelper(this.root, t.root);
    }

    private boolean equalsHelper(Node n1, Node n2) {
        if (n1.getValue() != n2.getValue()) {
            return false;
        }
        for (int i = 0; i < n1.getChildren().length; ++i) {
            Node firstNodeIterator = n1.getChildren()[i];
            Node secondNodeIterator = n2.getChildren()[i];
            if (firstNodeIterator == null && secondNodeIterator != null) {
                return false;
            }
            if (firstNodeIterator != null && secondNodeIterator == null) {
                return false;
            }
            if (firstNodeIterator != null && secondNodeIterator != null) {
                if (!equalsHelper(firstNodeIterator, secondNodeIterator)) {
                    return false;
                }
            }
        }
        return true;
    }

}
