/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatorengine.handler;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 *
 * @author Filippo
 */
public class CallbackHandler implements Callback {

    @Override
    public void onFailure(Call call, IOException ioe) {
    }

    @Override
    public void onResponse(Call call, Response rspns) throws IOException {
        String response = rspns.body().string();
    }
}
