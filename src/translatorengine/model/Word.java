/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatorengine.model;

/**
 *
 * @author Filippo
 */
public class Word {
    
    private final String word;
    private final int id;

    public Word(String word, int id) {
        this.word = word;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }
}
