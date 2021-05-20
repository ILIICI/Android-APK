package com.example.dissertation;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.dissertation.Adapters.DBAdapter;
import com.example.dissertation.GettersSetters.ModelClass;
import com.example.dissertation.SQLitePackage.MyDBClass;
import java.util.ArrayList;

public class LawsActivityChapter extends OnCreateMenu {
    MyDBClass objMyDBClass;
    ArrayList<ModelClass> objModelClassArrayList;
    RecyclerView recyclerView;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws_chapter);
        Intent intent = getIntent();
        index = intent.getIntExtra("message_to_query",0);
        DisplayLaw(index);
    }
    private void DisplayLaw(int index){
        objMyDBClass = new MyDBClass(this);
        objModelClassArrayList = objMyDBClass.getData_LawActivity(index);
        dbAdapter = new DBAdapter(objModelClassArrayList);

        objMyDBClass = new MyDBClass(this);
        recyclerView = findViewById(R.id.law_data_recycleview);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dbAdapter);
    }
    public void ZoomImg(View view){
        String id = String.valueOf(view.getId());
        Toast.makeText(LawsActivityChapter.this,id,Toast.LENGTH_LONG).show();
    }

}
