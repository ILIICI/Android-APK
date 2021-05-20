package com.example.dissertation;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Define variable
    private static TextView dashboard_tv_study,
            dashboard_tv_test,
            dashboard_tv_trafficsigns,
            dashboard_tv_laws,
            dashboard_tv_search,
            dashboard_tv_aboutus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                dashboard_tv_study = (TextView) findViewById(R.id.textview_pos1);
                dashboard_tv_test = (TextView) findViewById(R.id.textview_pos2);
                dashboard_tv_trafficsigns = (TextView) findViewById(R.id.textview_pos3);
                dashboard_tv_laws = (TextView) findViewById(R.id.textview_pos4);
                dashboard_tv_search = (TextView) findViewById(R.id.textview_pos5);
                dashboard_tv_aboutus = (TextView) findViewById(R.id.textview_pos8);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
    // Start "New Activities"
   public void StudyActivity(View view) {
        Intent intent = new Intent(MainActivity.this, StudyActivity.class);
        startActivity(intent);
    }
   public void TestActivity(View view) {
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent);
    }
   public void TrafficSignsDashBoardActivity(View view) {
        Intent intent = new Intent(MainActivity.this, TrafficSignsDashBoardActivity.class);
        startActivity(intent);
    }
   public void LawsActivity(View view) {
        Intent intent = new Intent(MainActivity.this, LawsActivity.class);
        startActivity(intent);
    }
   public void AchievementActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AchievementActivity.class);
        startActivity(intent);
    }
   public void AboutUsActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
        startActivity(intent);
    }
  // END "New Activities"
}
