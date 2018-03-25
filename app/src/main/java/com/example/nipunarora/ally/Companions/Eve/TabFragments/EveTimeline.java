package com.example.nipunarora.ally.Companions.Eve.TabFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nipunarora.ally.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by nipunarora on 24/03/18.
 */

public class EveTimeline extends Fragment {
    PieChart goal_progress;
    View rootview;
    public EveTimeline() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.eve_timeline, container, false);
        goal_progress=(PieChart)rootview.findViewById(R.id.goal_progress);
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //set use percent values
        int progress=40;
        goal_progress.setUsePercentValues(true);
        // enable hole and configure
        goal_progress.setDrawHoleEnabled(true);

        goal_progress.setHoleRadius(80);
        goal_progress.setTransparentCircleRadius(50);
        goal_progress.setCenterText(String.format("%d",progress)+"%");
        goal_progress.setCenterTextSize(16f);

        // enable rotation of the chart by touch
        goal_progress.setRotationAngle(270);
        goal_progress.setRotationEnabled(true);
        setCurrentProgress(progress);
        goal_progress.getLegend().setEnabled(false);
        goal_progress.getDescription().setEnabled(false);


    }

    private void setCurrentProgress(int progress)
    {


        goal_progress.setDrawCenterText(true);

        goal_progress.setRotationAngle(0);
        // enable rotation of the chart by touch
        goal_progress.setRotationEnabled(true);
        //*************************** Makng a list of all entries in the piechart the first arguement denotes the percentage on a relative basis *********//
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(progress));
        entries.add(new PieEntry((100-progress)));
        //******************************** Animating the pie chart *******************//
        goal_progress.animateY(1500);

        //***************************** Making a dataset from the entries and attaching colors to it and finally attaching the dataset to the goal_progress pie chart by converting
        // it to a piedata object*******//
        PieDataSet dataset = new PieDataSet(entries,"");

        dataset.setSliceSpace(0);
        dataset.setSelectionShift(5);
        PieData data = new PieData(dataset);
        data.setValueFormatter(new PercentFormatter());
        data.setDrawValues(false);
        data.setValueTextColor(Color.BLACK);
        dataset.setColors(new int[]{Color.GREEN,Color.LTGRAY});
        goal_progress.setData(data);
        //***************** Refreshing the pie chart ******************??
        goal_progress.invalidate();

    }
}
