package com.example.dissertation;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dissertation.Adapters.ListViewAdapter;
import com.example.dissertation.Adapters.ListViewAdapterAchiviment;
import com.example.dissertation.GettersSetters.ChartModel;
import com.example.dissertation.GettersSetters.ListViewModel;
import com.example.dissertation.SQLitePackage.MyDBClass;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class AchievementActivity extends AppCompatActivity {
    ListView listView;
    MyDBClass myDBClass;
    ListViewAdapterAchiviment listViewAdapterAchiviment;
    ArrayList<ListViewModel> listViewModelsArray;
    ArrayList<Integer> chartModelsArray;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        listView = (ListView)findViewById(R.id.listview_achievement);
        myDBClass = new MyDBClass(this);
        listViewModelsArray = new ArrayList<>();
        DisplayAchievement();
        barChart = (BarChart) findViewById(R.id.barchart);
        displayChar();
    }
    private void DisplayAchievement(){
        listViewModelsArray = myDBClass.getAchiviement();
        listViewAdapterAchiviment = new ListViewAdapterAchiviment(this,listViewModelsArray);
        listView.setAdapter(listViewAdapterAchiviment);
        listViewAdapterAchiviment.notifyDataSetChanged();
    }
    private void displayChar(){
        chartModelsArray = new ArrayList<>();
        chartModelsArray = myDBClass.getResults();
        ArrayList AxaX = new ArrayList<>();
        ArrayList AxaY = new ArrayList<>();
        int j = 0;
        for (int i =chartModelsArray.size()-10; i< chartModelsArray.size();i++){
            int numar = chartModelsArray.get(i);
            AxaX.add(new BarEntry(numar,j));
            AxaY.add(String.valueOf(j));
            j++;
        }
        BarDataSet bardataset = new BarDataSet(AxaX,"Puncte Acumulate");
        //barChart.animateY(5000);
        BarData data = new BarData(AxaY, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);
        //chartModelsArray = myDBClass.getResults();
/*
        int counter = chartModelsArray.size();
       for (int i = 0; i<chartModelsArray.size(); i++){
            lalala.setText((CharSequence) chartModelsArray.get(i));
           //int number = chartModelsArray.indexOf(i);
           //System.out.println(chartModelsArray.indexOf(i));
          // results.add(new BarEntry(number,i));
          // postion.add(i);*/
//        ArrayList NoOfEmp = new ArrayList();
//                NoOfEmp.add(new BarEntry(945, 0));
//                NoOfEmp.add(new BarEntry(1040, 1));
//                NoOfEmp.add(new BarEntry(1133, 2));
//                NoOfEmp.add(new BarEntry(1240, 3));
//                NoOfEmp.add(new BarEntry(1369, 4));
//                NoOfEmp.add(new BarEntry(1487, 5));
//                NoOfEmp.add(new BarEntry(1501, 6));
//                NoOfEmp.add(new BarEntry(1645, 7));
//                NoOfEmp.add(new BarEntry(1578, 8));
//                NoOfEmp.add(new BarEntry(1695, 9));
//        ArrayList year = new ArrayList();
//                year.add("2008");
//                year.add("2009");
//                year.add("2010");
//                year.add("2011");
//                year.add("2012");
//                year.add("2013");
//                year.add("2014");
//                year.add("2015");
//                year.add("2016");
//                year.add("2017");

        }

    }

