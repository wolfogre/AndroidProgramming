package com.example.me.activitybasesample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt= (Button) findViewById(R.id.btmain);
        TextView textView= (TextView) findViewById(R.id.tvmain);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                //note:Intent 是一个消息对象，由系统维护，用于在构件之间传递数据
                startActivity(intent);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:134") );
                //note:按下后自动拨打134
                try {
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });



    }
}
