package spell;

import passoff.SpellTest;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpellCorrector implements ISpellCorrector {
    Trie trie;

    public SpellCorrector() {
        this.trie = new Trie();
    }

    @Override
    public void useDictionary(String dictionaryFileName) throws IOException {
        File file = new File(dictionaryFileName);
        Scanner scanner = new Scanner(file);
        //System.out.println("Adding...");
        while (scanner.hasNext()) {
            this.trie.add(scanner.next());
        }
        System.out.println("Trie in word form: " + this.trie.toString());
    }

    @Override
    public String suggestSimilarWord(String inputWord) {
        return null;
    }
}
