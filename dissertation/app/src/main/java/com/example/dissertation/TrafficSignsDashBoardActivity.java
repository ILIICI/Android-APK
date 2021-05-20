package com.example.dissertation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.dissertation.Adapters.ListViewAdapter;

public class TrafficSignsDashBoardActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private String [] array_topics = new String []{"Semne de circulatie de avertizare",
                                                    "Semne de circulatie de prioritate",
                                                    "Semne de circulatie de interzicere si restrictie",
                                                    "Semne de circulatie de obligare",
                                                    "Semne de circulatie de orientare",
                                                    "Semne de circulatie de informare",
                                                    "Semne de circulatie de informare turistica",
                                                    "Panouri aditionale"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_signs);

        listViewAdapter = new ListViewAdapter(this, array_topics);
        listView = (ListView) findViewById(R.id.ListView_TopicSigns);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(TrafficSignsDashBoardActivity.this, TrafficSignsActivity.class);
                intent.putExtra("message_to_query", position);
                startActivity(intent);
            }
        });

    }
}
