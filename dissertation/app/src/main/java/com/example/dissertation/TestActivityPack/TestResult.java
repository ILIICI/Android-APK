package com.example.dissertation.TestActivityPack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dissertation.R;
import com.example.dissertation.SQLitePackage.MyDBClass;
import com.example.dissertation.TestActivity;

public class TestResult extends AppCompatActivity {
private int index;
private TextView tv_scoreView,tv_scoreMessage;
private Button btn_tryagain;
private MyDBClass myDBClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        Intent intent = getIntent();
        index = intent.getIntExtra("score",0);

        btn_tryagain = (Button) findViewById(R.id.button_tryagain);
        btn_tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movenext = new Intent(TestResult.this, TestActivity.class);
                startActivity(movenext);
            }
        });

        ShowScore(index);
        processScore(index);

    }
    private void ShowScore(int index){
        String score = String.valueOf(index);
        tv_scoreView = (TextView)findViewById(R.id.textview_result);
        tv_scoreMessage = (TextView)findViewById(R.id.textview_message);
        if (index <= 20){
            tv_scoreMessage.setTextColor(Color.RED);
            tv_scoreMessage.setText("NU ATI TRECUT");
            tv_scoreView.setTextColor(Color.RED);
            tv_scoreView.setText(score);
        }else{
            tv_scoreMessage.setTextColor(Color.GREEN);
            tv_scoreMessage.setText("FELICITARE");
            tv_scoreView.setTextColor(Color.GREEN);
            tv_scoreView.setText(score);
        }

    }
    private void processScore(int index){
        myDBClass = new MyDBClass(this);
        myDBClass.saveRecords(index);
    }

}
