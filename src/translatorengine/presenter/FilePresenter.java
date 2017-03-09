/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatorengine.presenter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo
 */
public class FilePresenter {

    private PrintWriter writer;
    
    public FilePresenter() {
        try {
            this.writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:/abc/words_to_remove.txt"), true)));
        } catch (IOException ex) {
            Logger.getLogger(FilePresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedReader read(String path) {
        BufferedReader reader = null;
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(stream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FilePresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }
    
    public void write(String word) {
        try {
            this.writer.println(word);
            this.writer.flush();
        } catch (Exception ex) {
            Logger.getLogger(FilePresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        this.writer.close();
    }
}
