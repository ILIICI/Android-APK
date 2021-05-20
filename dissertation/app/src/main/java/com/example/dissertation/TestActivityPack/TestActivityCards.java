package com.example.dissertation.TestActivityPack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dissertation.GettersSetters.ModelClass;
import com.example.dissertation.R;
import com.example.dissertation.SQLitePackage.MyDBClass;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class TestActivityCards extends AppCompatActivity {

    private static final long Count_Down_Mills = 2101000;
    private TextView tv_correct_answers;
    private TextView tv_question_counter;
    private TextView tv_timer;
    private TextView tv_question;
    private TextView tv_hint;
    private ImageView iv_image_question;
    private RadioGroup radioGroup;
    private RadioButton rb_a1, rb_a2, rb_a3, rb_a4;
    private Button btn_confirm_next;
    private ArrayList<ModelClass> objModelClass;
    int index;

    private ColorStateList colorStateListDefault;
    private ColorStateList colorStateListCountDown;

    private CountDownTimer countDownTimer;
    private long timeleft;

    private int questionCounter,questionCountTotal;
    private ModelClass currentQuestion;
    private int score;
    private boolean answered;
    private String hint;
    private ConstraintLayout constraintLayout; // asta

    private long backPressedTime;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_cards);
        openNewTestActivity();
        constraintLayout = findViewById(R.id.constraintLayout); /// asta
        tv_correct_answers = findViewById(R.id.textview_correct_answer);
        tv_question_counter = findViewById(R.id.textview_question_count);
        tv_timer = findViewById(R.id.textview_timer);
        tv_question = findViewById(R.id.textview_test_question);
        iv_image_question = findViewById(R.id.imageview_test_question);
        radioGroup = findViewById(R.id.radio_group_button);
        rb_a1 = findViewById(R.id.radio_button_option1);
        rb_a2 = findViewById(R.id.radio_button_option2);
        rb_a3 = findViewById(R.id.radio_button_option3);
        rb_a4 = findViewById(R.id.radio_button_option4);
        btn_confirm_next =findViewById(R.id.button_confirm_next);
        tv_hint = findViewById(R.id.textViewHint);

        colorStateListDefault = rb_a1.getTextColors(); // Save default color
        colorStateListCountDown = tv_timer.getTextColors();

        MyDBClass myDBClass = new MyDBClass(this);
        objModelClass = myDBClass.getData_Test(index);

        questionCountTotal = objModelClass.size();
        Collections.shuffle(objModelClass);
        //Star countDown

            timeleft = Count_Down_Mills;
            startCountDown();

        //End countDown
        showNextQuestion();

        btn_confirm_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answered){
                    if (rb_a1.isChecked() || rb_a2.isChecked() || rb_a3.isChecked() || rb_a4.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(TestActivityCards.this,"SELECTATI UN RASPUNS",Toast.LENGTH_LONG).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long l) {
                timeleft = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeleft = 0;
                updateCountDownText();
                checkAnswer();
                finishTest();
            }
        }.start();
    }
    private void updateCountDownText(){
        int minutes = (int) (timeleft / 1000 ) / 60;
        int seconds = (int) (timeleft / 1000 ) % 60; //stop here
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d",minutes,seconds);
        tv_timer.setText(timeFormatted);

        if (timeleft < 300000) {
            tv_timer.setTextColor(Color.RED);
        }else {
            tv_timer.setTextColor(colorStateListCountDown);
        }

    }
    private void showNextQuestion(){
        rb_a1.setTextColor(colorStateListDefault);
        rb_a2.setTextColor(colorStateListDefault);
        rb_a3.setTextColor(colorStateListDefault);
        rb_a4.setTextColor(colorStateListDefault);
        radioGroup.clearCheck();

        if (questionCounter < questionCountTotal){ // schimbat
            currentQuestion = objModelClass.get(questionCounter);

            tv_question.setText(currentQuestion.getQuestion());
            //iv_image_question.setImageBitmap(currentQuestion.getQuestion_image());//maybe mistake

            String uri = "@drawable/" + currentQuestion.getQuestion_image();
            int imageresource = getResources().getIdentifier(uri,null,getPackageName());
            iv_image_question.setImageResource(imageresource);

            rb_a1.setText(currentQuestion.getAnswer_option_1());
            rb_a2.setText(currentQuestion.getAnswer_option_2());
            if(currentQuestion.getAnswer_option_3() != null ){
                rb_a3.setText(currentQuestion.getAnswer_option_3());
            }else{
                rb_a3.setVisibility(View.INVISIBLE);
            }
            if(currentQuestion.getAnswer_option_4() != null ){
                rb_a4.setText(currentQuestion.getAnswer_option_4());
            }else{
                rb_a4.setVisibility(View.INVISIBLE);
            }
            hint = "";
            hint = currentQuestion.getHint();


            questionCounter++;
            tv_question_counter.setText("Intrebarea "+questionCounter+" / "+questionCountTotal);
            answered = false;
            btn_confirm_next.setText("Confirm");///aicea in jos

        }else{
            finishTest();
        }
    }
    private void checkAnswer(){
        answered = true;
        RadioButton radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNR = radioGroup.indexOfChild(radioButtonSelected)+1;

        if (answerNR == currentQuestion.getAnswerNr()){
            score++;
            tv_correct_answers.setText("Raspuns corect: "+score);
        }
        showSolution();
    }
    private void showSolution(){
        rb_a1.setTextColor(Color.RED);
        rb_a2.setTextColor(Color.RED);
        rb_a3.setTextColor(Color.RED);
        rb_a4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()){
            case 1:
                rb_a1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb_a2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb_a3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb_a4.setTextColor(Color.GREEN);
                break;
        }
        final Snackbar snackbar = Snackbar.make(constraintLayout,"",Snackbar.LENGTH_INDEFINITE);
        View custom = getLayoutInflater().inflate(R.layout.custom_snackbar,null);
        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
        TextView textViewHint = (TextView) custom.findViewById(R.id.textViewHint);
        textViewHint.setText(hint);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarLayout.setPadding(0,0,0,0);
        custom.findViewById(R.id.closeHint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
        snackbarLayout.addView(custom,0);
        snackbar.show();
        if (questionCounter <= questionCountTotal){
            btn_confirm_next.setText("Continue");
        }else{
            btn_confirm_next.setText("Am terminat");
        }
    }
    private void finishTest(){
        Intent intent = new Intent(TestActivityCards.this,TestResult.class);
        intent.putExtra("score",score);
        startActivity(intent);
        finish();
    }
    private void openNewTestActivity(){
        Intent intent = getIntent();
        index = intent.getIntExtra("query_position",0);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(),"Dublu click pentru a iesi",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
