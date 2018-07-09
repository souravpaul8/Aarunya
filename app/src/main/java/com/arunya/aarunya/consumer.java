package com.arunya.aarunya;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class consumer extends AppCompatActivity {
    Button btn_buy;
    Button back1;
    Button openNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer);
        openNews = (Button) findViewById(R.id.news);
        openNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(consumer.this, news.class);
                startActivity(i);
            }
        });
        /*back1=(Button)findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(consumer.this,RegisterAsActivity.class);
                startActivity(i);
            }
        });*/
        btn_buy = (Button) findViewById(R.id.sell);
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensellactivity();
            }
        });
    }

    public void opensellactivity() {
        Intent in = new Intent(this, ConsumerBuyActivity.class);
        startActivity(in);
    }

}
