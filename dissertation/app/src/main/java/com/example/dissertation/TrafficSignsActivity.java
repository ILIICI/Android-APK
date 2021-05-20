package com.example.dissertation;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.dissertation.Adapters.DBAdapter;
import com.example.dissertation.GettersSetters.ModelClass;
import com.example.dissertation.SQLitePackage.MyDBClass;
import java.util.ArrayList;

public class TrafficSignsActivity extends OnCreateMenu {
    MyDBClass objMyDBClass;
    ArrayList<ModelClass> objModelClassArrayList;
    RecyclerView recyclerView;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_signs2);
        Intent intent = getIntent();
        index = intent.getIntExtra("message_to_query",0);
        DisplaySigns(index);
    }


    private void DisplaySigns(int index){
        objMyDBClass = new MyDBClass(this);
        objModelClassArrayList = objMyDBClass.getData_SignActivity(index);
        dbAdapter = new DBAdapter(objModelClassArrayList);

        objMyDBClass = new MyDBClass(this);
        recyclerView = findViewById(R.id.sign_data_recycleView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dbAdapter);
    }
}