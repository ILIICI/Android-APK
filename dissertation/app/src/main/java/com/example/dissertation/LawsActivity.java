package com.example.dissertation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.dissertation.Adapters.ListViewAdapter;

public class LawsActivity extends AppCompatActivity {
   private ListView listView;
    private ListViewAdapter listViewAdapter;
    private String array_topics[] = new String[]{"Dispoziții generale.",
                                        "Drepturile, obligaţiile și restricțiile pentru conducătorii de vehicule.",
                                        "Organizarea și dirijarea circulației rutiere.",
                                        "Reguli pentru circulația vehiculelor.",
                                        "Obligaţii pentru proprietarii de vehicule şi pentru persoanele responsabile de exploatarea vehiculelor, drumurilor publice, trecerilor la nivel cu calea ferată şi altor construcţii rutiere privind garantarea siguranţei traficului rutier."
                                        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);
        listViewAdapter = new ListViewAdapter(this,array_topics);
        listView = (ListView) findViewById(R.id.ListView_LawChap);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(LawsActivity.this, LawsActivityChapter.class);
                intent.putExtra("message_to_query", position);
                startActivity(intent);
            }
        });
    }
}
