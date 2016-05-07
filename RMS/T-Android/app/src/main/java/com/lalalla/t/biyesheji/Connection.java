package com.lalalla.t.biyesheji;

import android.media.Image;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by T on 2016/4/23.
 */
public class Connection {



public void httpPOST(Map<String, String> dic){
    new AsyncTask<Map<String,String>,Void,JSONObject>(){
        @Override
        protected JSONObject doInBackground(Map<String,String>... params) {
            JSONObject obj = new JSONObject();
            try {
                Map<String,String> dic = params[0];
                URL url = new URL(params[0].get("url"));
                dic.remove("url");
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setDoOutput(true);
                    connection.setRequestMethod("POST");

                    OutputStreamWriter osw =new OutputStreamWriter(connection.getOutputStream(),"utf-8") ;
                    BufferedWriter bw = new BufferedWriter(osw);
                    String _params = "";
                    for (Map.Entry<String, String> __: dic.entrySet()) {_params+= URLEncoder.encode(__.getKey(), "UTF-8")+"="+URLEncoder.encode(__.getValue(), "UTF-8")+"&";}
                    _params = _params.substring(0,_params.length()-1);
                    bw.write(_params);
                    bw.flush();
                    InputStream is = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is,"utf-8");
                    BufferedReader br = new BufferedReader(isr);
                    String line="",___;
                    while ((___ = br.readLine())!=null) {line+=___;}
                    br.close();
                    isr.close();
                    is.close();

                    try {
                        obj = new JSONObject(line);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return obj;
        }
        @Override
        protected void onPostExecute(JSONObject obj){
//// TODO: 2016/4/24 broadcast,handler
        }
    }.execute(dic);

}
    public void httpGet(final String url) {
        new AsyncTask<String, Void, byte[]>() {

            @Override
            protected byte[] doInBackground(String... params) {
                byte[] yzm = null;
                try {
                    URL url = new URL(params[0]);
                    URLConnection uc = url.openConnection();
                    InputStream is = uc.getInputStream();
                    yzm = new byte[uc.getContentLength()];
                    is.close();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                return yzm;
            }

            @Override
            protected void onPostExecute(byte[] byt) {
//                Image a = Toolkit.getDefaultToolkit().createImage(byt,0,byt.length);
                return;
            }
        }.execute(url);
    }


}
