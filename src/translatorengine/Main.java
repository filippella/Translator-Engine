/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatorengine;

import translatorengine.helper.Helper;
import translatorengine.presenter.WordTranslatorPresenter;
import translatorengine.service.WordTranslatorService;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;

/**
 *
 * @author Filippo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        FilePresenter presenter = new FilePresenter();
//        BufferedReader reader = presenter.read("ethiopianwordtranslator/assets/english.txt");
//        List<Word> words = new ArrayList<>();
//        String word;
//        int count = 0;
//        try {
//            while((word = reader.readLine()) != null) {
//                words.add(new Word(word, ++count));
//                System.out.println(word);
//                //System.out.printf("{wordId:%d, wordName: %s}\n", ++count, word);
//            }
//            reader.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        String wordJson = new Gson().toJson(words, List.class);

           // presenter.write(new File("C:/abc/english.json"), wordJson);
            
        Helper helper = new Helper();
        OkHttpClient okHttpClient = new OkHttpClient();
        WordTranslatorService service = new WordTranslatorService(okHttpClient);
        WordTranslatorPresenter presenter = new WordTranslatorPresenter(service, helper);
                
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("translatorengine/assets/english.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(stream, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            
            
            List<String> allWords = new ArrayList<>();
            List<String> nonTranslateableWords = new ArrayList<>();
            
            
            String word;
            int count = 0;
            while((word = reader.readLine()) != null) {
                allWords.add(word);
//                if(word.matches(".*[a-zA-Z].*")) {
//                    nonTranslateableWords.add(word);
//                System.out.printf("%d) %s\n", ++count, word);
//                }
                presenter.translate("en", "it", word);
            }
            reader.close();
            
            Collections.sort(allWords);
            
            for(int i = 0; i < allWords.size(); i++) {
                String singleWord = allWords.get(i);
                //System.out.println(singleWord);
            }
            
//            allWords.removeAll(nonTranslateableWords);
//            
//            FilePresenter filePresenter = new FilePresenter();
//            
//            for(int i = 0; i < nonTranslateableWords.size(); i++) {
//                String singleWord = nonTranslateableWords.get(i);
//                filePresenter.write(singleWord);
//            }
//            
//            filePresenter.close();
            
            //presenter.close();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
