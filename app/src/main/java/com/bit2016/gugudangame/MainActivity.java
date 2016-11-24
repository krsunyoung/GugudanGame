package com.bit2016.gugudangame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_help).setOnClickListener(this);
        findViewById(R.id.button_record).setOnClickListener(this);
        findViewById(R.id.button_start).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int viewid=view.getId();
        switch (viewid){
            case R.id.button_help: {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_record:{
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_start:{
                Intent intent = new Intent(MainActivity.this, quizActivity.class);
                startActivity(intent);
                break;
            }
            default: {
                Log.d("--->","오류당");
                Toast.makeText(this, "unknown view", Toast.LENGTH_LONG).show();
            }
        }
    }
}
