/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatorengine.service;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 *
 * @author Filippo
 */
public class WordTranslatorService {

    private final OkHttpClient client;

    public WordTranslatorService(OkHttpClient client) {
        this.client = client;
    }

    public String translate(Request request) {
        try {
            return this.client.newCall(request).execute().body().string();
        } catch (IOException ex) {
            return null;
        }
    }
}
