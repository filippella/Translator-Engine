/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatorengine.presenter;

import translatorengine.Main;
import translatorengine.helper.Helper;
import translatorengine.service.WordTranslatorService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Request;

/**
 *
 * @author Filippo
 */
public class WordTranslatorPresenter {

    private final WordTranslatorService service;
    private final Helper helper;
    private PrintWriter writer;

    public WordTranslatorPresenter(WordTranslatorService service, Helper helper) {
        this.service = service;
        this.helper = helper;
        try {
            this.writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:/abc/amharic.txt"), true)));
        } catch (IOException ex) {
            Logger.getLogger(WordTranslatorPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void translate(String from, String to, String query) {
        Request request = this.helper.createRequest(from, to, query);
        String translation = this.helper.getTranslation(this.service.translate(request));
        
        System.out.println(translation);
        write(translation);
    }

    private void write(String word) {
        try {
            this.writer.println(word);
            this.writer.flush();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        this.writer.close();
    }
}
