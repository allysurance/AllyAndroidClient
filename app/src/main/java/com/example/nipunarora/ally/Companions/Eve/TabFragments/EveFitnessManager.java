package com.example.nipunarora.ally.Companions.Eve.TabFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.nipunarora.ally.Companions.Eve.NutritionActivity;
import com.example.nipunarora.ally.R;
import com.example.nipunarora.ally.VolleySingleton;
import com.github.mikephil.charting.charts.PieChart;

import org.json.JSONObject;

/**
 * Created by nipunarora on 24/03/18.
 */

public class EveFitnessManager extends Fragment {
    View rootview;
    private RequestQueue mrequestqueue;
    public EveFitnessManager() {
    }
    AppCompatButton nutrition;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mrequestqueue= VolleySingleton.getInstance(getContext()).getRequestQueue();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.eve_fitness_manager, container, false);
        nutrition=(AppCompatButton)rootview.findViewById(R.id.viewallnutrition);
        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NutritionActivity.class));
            }
        });
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromApi("http://35.196.72.252:8000/goals?age=15&sex=M&heightfeet=5&heightinch=12&kg=90&activity=1.2");
    }

    private void getDataFromApi(String url){
        StringRequest toggle_lights = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        /***************** JSON PARSING OF THE RESPONSE*********************/
                        try{
                            JSONObject res=new JSONObject(response);

                        }
                        catch (Exception e)
                        {
                            Log.d("JSON Parse Error",e.toString());
                        }


                    }
                },
                //******************** Enable the starting of app even in the case when internet is no available with default banner images **********/
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.toString());
                    }
                }
        );

        mrequestqueue.add(toggle_lights);
    }
}
