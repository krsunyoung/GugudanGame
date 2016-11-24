package com.bit2016.gugudangame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class quizActivity extends AppCompatActivity {
    private static final int TIME_LIMIT=30;
    private Timer timer = new Timer();
    private TextView LastTime;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        LastTime = (TextView)findViewById(R.id.textView_timer);
        timer.schedule(new GameTimerTask(), 1000, 1000);

        TextView quiz1 = (TextView)findViewById(R.id.textView_quiz1);
        TextView quiz2 = (TextView)findViewById(R.id.textView_quiz2);


        //문제입력
        int quiz_1 = random.nextInt(7)+2;
        int quiz_2 = random.nextInt(8)+1;
        quiz1.setText(""+quiz_1);
        quiz2.setText(""+quiz_2);
        int answer = quiz_1 * quiz_2;

        Set<Integer> set = new HashSet<Integer>();
        set.add(answer);
        int[] button_ids={R.id.button_1,R.id.button_2,R.id.button_3,R.id.button_4,
                R.id.button_5,R.id.button_6,R.id.button_7,R.id.button_8, R.id.button_9};
        //버튼 정답클릭
        for(int i = 0; i < 8 ; i++){
            answer = (random.nextInt(7)+2)*(random.nextInt(8)+1);
            if (set.contains(answer)) {
                i--;
            } else {
                set.add(answer);
            }
        }

//        Iterator<Integer> iter = set.iterator();

//        while(iter.hasNext()){
            for(int i =0; i< button_ids.length; i++){
                set.iterator().next();
                TextView test= (TextView)findViewById(button_ids[i]);
                test.setText(String.valueOf(set.iterator().next()));
                set.remove(set.iterator().next());
            }

//        }




    }
    private void updateLastTime(int seconds){
        LastTime.setText(""+(TIME_LIMIT-seconds));
    }

    private class GameTimerTask extends TimerTask{
        private int seconds =0;
        @Override
        public void run() {
            seconds++;
            if(seconds>=TIME_LIMIT){
                //타이머중지
                timer.cancel();
                Intent intent = new Intent(quizActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //객체를 메인스레드에서 실행시켜줌.
                    updateLastTime(seconds);
                }
            });
        }

    }
}
