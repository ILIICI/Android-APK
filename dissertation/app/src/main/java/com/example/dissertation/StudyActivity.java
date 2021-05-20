package com.example.dissertation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dissertation.GettersSetters.ChartModel;
import com.example.dissertation.GettersSetters.ModelClass;
import com.example.dissertation.SQLitePackage.MyDBClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class StudyActivity extends AppCompatActivity {
private TextView textViewQuestion;
private TextView textViewAnswer;
private ImageView imageViewQuestion;
private Button buttonPrevious;
private Button buttonNext;
private int questionCounter;
private ArrayList<ModelClass> objModelClass;
private MyDBClass myDBClass;
private ModelClass currentQuestion;

private int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        textViewQuestion = findViewById(R.id.TextViewStudyQuestion);
        textViewAnswer = findViewById(R.id.TextViewStudyAnswer);
        imageViewQuestion = findViewById(R.id.ImageViewStudyQuestion);
        buttonPrevious = findViewById(R.id.ButtonPrevious);
        buttonNext = findViewById(R.id.ButtonNext);

        myDBClass = new MyDBClass(this);
        objModelClass = myDBClass.getData_Study();
        Collections.shuffle(objModelClass);
        questionCounter = objModelClass.size();
        showNextQuestion(index);
        buttonActions();
    }
    private void buttonActions(){

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (questionCounter > index){

                    showNextQuestion(index);
                } else {
                    Toast.makeText(StudyActivity.this,"Nu mai sunt intrebari",Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if (index != -1){

                    showNextQuestion(index);
                }
                else {
                    Toast.makeText(StudyActivity.this,"Nu mai sunt intrebari",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void showNextQuestion(int index) {

        currentQuestion = objModelClass.get(index);
        textViewQuestion.setText(currentQuestion.getQuestion());

        int correctAnswer = currentQuestion.getAnswerNr();
        switch (correctAnswer){
            case 1:
                textViewAnswer.setText(currentQuestion.getAnswer_option_1());
                break;
            case 2:
                textViewAnswer.setText(currentQuestion.getAnswer_option_2());
                break;
            case 3:
                textViewAnswer.setText(currentQuestion.getAnswer_option_3());
                break;
            case 4:
                textViewAnswer.setText(currentQuestion.getAnswer_option_4());
                break;
        }

        String uri = "@drawable/" + currentQuestion.getQuestion_image();
        int imageresource = getResources().getIdentifier(uri,null,getPackageName());
        imageViewQuestion.setImageResource(imageresource);

    }
}
