package com.boyhotkey96.jsoupdemkhuyatv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private String link = "";
    private String url = "https://demkhuya.tv";
    private BongDaCustomAdapter bongDaCustomAdapter;
    private ArrayList<Bongda> bongdaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);

        bongdaArrayList = new ArrayList<>();
        bongDaCustomAdapter = new BongDaCustomAdapter(this, bongdaArrayList);
        lv.setAdapter(bongDaCustomAdapter);

        ReadJsoup();
    }

    private void ReadJsoup() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document document = Jsoup.parse(response);
                if (document != null) {
                    Elements elements = document.select("a.live-item");
                    for (final Element element : elements) {
                        final Element elementlink = element.getElementsByTag("a").last();
                        link = elementlink.attr("href");
                        Log.d("AAA1", link);

                        Element elementdoi1 = element.getElementsByTag("img").first();
                        Element elementdoi2 = element.getElementsByTag("img").last();
                        Element elementGio = element.getElementsByTag("span").first();
                        Element elementNgay = element.getElementsByTag("span").last();
                        Element elementPhi = element.getElementsByTag("label").last();
                        Element elementTentran = element.select("div.team").first();
                        Element elementGiaidau = element.select("div.leage").first();
                        String doi1 = elementdoi1.attr("src");
                        String doi2 = elementdoi2.attr("src");
                        String gio = elementGio.text();
                        String ngay = elementNgay.text();
                        String phi = elementPhi.text();
                        String tentran = elementTentran.text();
                        String giaidau = elementGiaidau.text();

                        Bongda bongda = new Bongda(link, doi1, doi2, gio, ngay, phi, tentran, giaidau);
                        bongdaArrayList.add(bongda);
                    }
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Log.d("AAA", bongdaArrayList.get(position).getLink());
                            Intent intent = new Intent(MainActivity.this, XemBongDa.class);
                            intent.putExtra("LINK-VIDEO", bongdaArrayList.get(position).getLink());
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, bongdaArrayList.get(position).getLink(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    bongDaCustomAdapter.notifyDataSetChanged();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }
}
