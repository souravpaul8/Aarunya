package com.arunya.aarunya;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TransporterViewAssignmentActivity extends AppCompatActivity {

    Button routeBtn ,confirmBtn,contactBtn;


    private static final String URL_DATA ="https://maps.googleapis.com/maps/api/directions/json?origin=Dhanbaed&destination=Mumbai";

    private RecyclerView recyclerView;
    private TransporterAssignmentAdapter adapter;

    List<TransporterAssignmentDetail> assignmentDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter_view_assignment);



        /*confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent view_intent=new Intent(TransporterViewAssignmentActivity.this,TransporterHomeActivity.class);
                startActivity(view_intent);
            }
        });
*/
        /*contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


        recyclerView = (RecyclerView) findViewById(R.id.transporter_recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        assignmentDetailList = new ArrayList<>();

        loadRecyclerViewData();

        /*routeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/dir/?api=1&origin=81.23444,67.0000&destination=80.252059,13.060604"));

            }
        });
*/
    }

    private void loadRecyclerViewData() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>(){
                @Override
                    public void onResponse(String s) {

                    try {
                        JSONObject jsonObject = new JSONObject(s);

                        JSONArray routesArray = jsonObject.getJSONArray("routes");

                        JSONObject routesArrayElement1 = routesArray.getJSONObject(0);

                        JSONArray legsArray = routesArrayElement1.getJSONArray("legs");
                        JSONObject legsArrayElement1 = legsArray.getJSONObject(0);


                        JSONObject distance = legsArrayElement1.getJSONObject("distance");
                        String distanceText = distance.getString("text");

                        JSONObject duration = legsArrayElement1.getJSONObject("duration");
                        String durationText = duration.getString("text");

                        TransporterAssignmentDetail assignment = new TransporterAssignmentDetail("Dhanbad",
                                "Mumbai", distanceText, durationText,
                                "Rs. 24590");
                        assignmentDetailList.add(assignment);

                        adapter = new TransporterAssignmentAdapter(TransporterViewAssignmentActivity.this, assignmentDetailList);
                        recyclerView.setAdapter(adapter);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                },
                    new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse (VolleyError volleyError) {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                        }

                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
