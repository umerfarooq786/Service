package com.example.umerfarooq.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    TextView limitTxt;
    Button startServicebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        limitTxt= findViewById(R.id.limitTxt);
        startServicebtn=findViewById(R.id.startServicebtn);
        startServicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyIntentService.class);
                startService(intent);
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvent(Event event)
    {
        Integer s=event.getMessage();
        limitTxt.setText(s.toString());
    }
}
