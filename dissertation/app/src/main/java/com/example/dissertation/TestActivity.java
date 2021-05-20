package com.example.dissertation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.dissertation.Adapters.DBAdapterTestCard;
import com.example.dissertation.GettersSetters.ModelClass;
import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ArrayList<ModelClass> testName = new ArrayList<ModelClass>();
        DBAdapterTestCard dbAdapterTestCard = new DBAdapterTestCard(R.layout.recycleview_singlerow_cardstest,testName);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_viewTestCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dbAdapterTestCard);

        testName.add(new ModelClass ("Incepe Testarea"));

        // Temporary - need data build data base.
        /*for (int i=1; i <= 35; i++){
            testName.add(new ModelClass ("Test" + i));
        }*/
    }



}
