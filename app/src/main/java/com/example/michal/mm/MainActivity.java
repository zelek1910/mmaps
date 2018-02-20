package com.example.michal.mm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonGdzie = (Button) findViewById(R.id.buttonGdzie);
        buttonGdzie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4= new Intent(MainActivity.this , gdzie.class);
                startActivity(intent4);
            }
        });
        Button buttonWyz = (Button) findViewById(R.id.buttonWyz);
        buttonWyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3;
                intent3 = new Intent(MainActivity.this , wyznacz.class);
                startActivity(intent3);
            }
        });
        Button buttonActivity2 = (Button)findViewById(R.id.button);
        buttonActivity2.setOnClickListener(new StartNewActivity2());
        Button buttonUcz =(Button) findViewById(R.id.buttonUcz);
        buttonUcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent( MainActivity.this , uczelnie.class);
                startActivity(intent2);
            }

        });
    }
    private class StartNewActivity2 implements  View.OnClickListener
    {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, maps.class);
            startActivity(intent);
        }
    }
}
