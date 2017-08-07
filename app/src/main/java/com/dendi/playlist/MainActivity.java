package com.dendi.playlist;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Song> songList;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songList = new ArrayList<>();
        lv = (ListView)findViewById(R.id.lv_songs);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://api.myjson.com/bins/a0gz5");
            }
        });
    }

    class ReadJSON extends AsyncTask<String, Integer, String>{
        @Override
        protected String doInBackground(String... params) {
            return readUrl(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try{
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray("musics");

                for(int i=0; i < jsonArray.length(); i++) {
                    JSONObject songObject = jsonArray.getJSONObject(i);
                    songList.add(new Song(
                            songObject.getString("artist"),
                            songObject.getString("title"),
                            songObject.getString("image"),
                            songObject.getString("url")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            CustomAdapter adapter = new CustomAdapter(
                    getApplicationContext(), R.layout.custom_list, songList
            );
            lv.setAdapter(adapter);
        }
    }

    private static String readUrl(String theUrl){
        StringBuilder content = new StringBuilder();
        try {

            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null){
              content.append(line + "\n");
            };
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }
}
