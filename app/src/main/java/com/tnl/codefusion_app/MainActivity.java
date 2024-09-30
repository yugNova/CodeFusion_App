package com.tnl.codefusion_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tnl.codefusion_app.config.Constants;
import com.tnl.codefusion_app.data.Question;
import com.tnl.codefusion_app.databinding.ActivityMainBinding;
import com.tnl.codefusion_app.helper.QuestionGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

ActivityMainBinding binding;
private RadioButton[] checkButton=new RadioButton[4];
int currentIndex=0;
List<Question> questions;
private CountDownTimer timer;
private int timeleft= Constants.TOTAl_EXAM_TIME;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initComponents();
        startTimer();





    }
    private void submitTest(){
        Toast.makeText(this,"Test submitted",Toast.LENGTH_SHORT).show();
    }
    //start timer method

    private void startTimer() {
        timer=new CountDownTimer(Constants.TOTAl_EXAM_TIME*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //at every tick run it
                int min=timeleft/60;
                int sec=timeleft%60;
                binding.timer.setText(min +" min " + sec + " sec");
                timeleft--;

                //update circular progress bar
                binding.circularProgressBar.setProgress((float) timeleft/Constants.TOTAl_EXAM_TIME*100);

            }

            @Override
            public void onFinish() {
//when timer finish then it run
              //  Toast.makeText(MainActivity.this,"Timer finished",Toast.LENGTH_SHORT).show();
            submitTest();
            }
        };
        timer.start();
        binding.timer.setText("Finished");


    }

    private void initComponents() {
        checkButton[0]=binding.option1;
        checkButton[1]=binding.option2;
        checkButton[2]=binding.option3;
        checkButton[3]=binding.option4;
        for (RadioButton button:checkButton){
            button.setOnClickListener(this);
        }
        questions= QuestionGenerator.getQuestion();
        Question question=questions.get(currentIndex);
        setQuestionToView(question,currentIndex);


        binding.nextButton.setOnClickListener(e->{
            nextQuestion();
        });
        binding.perviousButton.setOnClickListener(e->{
            perviousQuestion();
        });

    }

    private void perviousQuestion() {

        if ((currentIndex-1)<0){
            Toast.makeText(this,"Already 0 position",Toast.LENGTH_SHORT).show();
        }else {
            currentIndex--;
            setQuestionToView(questions.get(currentIndex),currentIndex);
        }
    }

    private void nextQuestion() {

        if ((currentIndex+1)>questions.size()-1){
            Toast.makeText(this,"Already last question",Toast.LENGTH_SHORT).show();
        }else {
            currentIndex++;
            Log.d("CodeFusion","Curreant Index:" +currentIndex);
            setQuestionToView(questions.get(currentIndex),currentIndex);
        }
    }






    @Override
    public void onClick(View v) {

       // Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show();

        RadioButton buttonClicked=(RadioButton) v;
        for (RadioButton button:checkButton){
            button.setChecked(button.getId() == buttonClicked.getId());
        }
        questions.get(currentIndex).setCheckValue(buttonClicked.getId());
    }

@SuppressLint("SetTextI18n")
    private void setQuestionToView(Question question,int index) {

        binding.question.setText((currentIndex + 1) + "." + question.getQuestion());
        binding.option1.setText(question.getOption1());
        binding.option2.setText(question.getOption2());
        binding.option3.setText(question.getOption3());

        binding.option4.setText(question.getOption4());
        for (RadioButton button : checkButton) {
            if (questions.get(currentIndex).getCheckValue() == button.getId()) {
            } else {
                button.setChecked(false);
            }

            }
        }
    }