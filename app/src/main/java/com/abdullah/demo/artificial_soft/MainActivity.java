package com.abdullah.demo.artificial_soft;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.abdullah.demo.artificial_soft.model.ModelData;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressDialog pDialog;
    final String REQ_URL = "https://api.myjson.com/bins/15baeq";

    List<ModelData> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ParseDataFromUrl parseData = new ParseDataFromUrl();
        parseData.execute();

    }



    private class ParseDataFromUrl extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

                HttpHandler sh = new HttpHandler();
                String jsonStr = sh.makeServiceCall(REQ_URL);


            if (jsonStr != null) {

                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray contacts = jsonObj.getJSONArray("search_result");

                    for (int i = 0; i < contacts.length(); i++) {

                        JSONObject obj = contacts.getJSONObject(i);
                        ModelData modelData = new ModelData();

                        modelData.setId(obj.getString("id"));
                        modelData.setName(obj.getString("name"));
                        modelData.setUser(obj.getString("User"));
                        modelData.setWho(obj.getString("who"));
                        modelData.setImage(obj.getString("image"));

                        dataList.add(modelData);
                    }

                } catch (final Exception e) {
                    e.printStackTrace();
                }

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            MyAdapter myAdapter = new MyAdapter(MainActivity.this, dataList);
            recyclerView.setAdapter(myAdapter);

        }

    }
}











