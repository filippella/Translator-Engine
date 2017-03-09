/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatorengine.helper;

import java.net.URLEncoder;
import java.util.StringTokenizer;
import okhttp3.Request;

/**
 *
 * @author Filippo
 */
public class Helper {

    public Request createRequest(String from, String to, String query) {
        return new Request.Builder()
                .url(String.format("https://translate.googleapis.com/translate_a/single?client=gtx&sl=%s&tl=%s&dt=t&q=%s", from, to, URLEncoder.encode(query)))
                .build();
    }

    public String getTranslation(String rawTranslation) {
        StringTokenizer tokenizer = new StringTokenizer(rawTranslation, ",");
        String nextToken = tokenizer.nextToken();
        return nextToken.replace("[", "").replace("\"", "").replace("]", "");
    }

    public String getWordToTranslate(String rawTranslation) {
        StringTokenizer tokenizer = new StringTokenizer(rawTranslation, ",");
        String nextToken = tokenizer.nextToken();
        return nextToken.replace("[", "").replace("\"", "").replace("]", "");
    }
}
