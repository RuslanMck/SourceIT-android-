package ua.sourceit.loadermanager;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ua.sourceit.loadermanager.model.Cat;

public class CatAsyncTask extends AsyncTask<Void, Void, List<Cat>> {

    private CatListener listener;

    public CatAsyncTask(CatListener listener){

    }

    @Override
    protected List<Cat> doInBackground(Void... voids) {
        List<Cat> catList = new ArrayList<>();



        try {
            URL url = new URL("https://sampleandorid.firebaseio.com/.json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()){
                stringBuilder.append(bufferedReader.readLine());
            }
            bufferedReader.close();
            urlConnection.disconnect();

            String strSource = stringBuilder.toString();
            JSONArray jsonObject = new JSONArray(strSource);
            if (jsonObject)

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Cat> cats) {
        if (listener != null){
            listener.onReceive(cats);
        }
    }
}
