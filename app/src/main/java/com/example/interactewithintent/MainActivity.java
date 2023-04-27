package com.example.interactewithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_see , btn_call;
    EditText et ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_see = findViewById(R.id.main_btn_see);
        btn_call = findViewById(R.id.main_btn_call);
        et = findViewById(R.id.main_et_name);

        btn_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity2.class);
                String s = et.getText().toString();
                intent.putExtra("user_name",s);
                startActivity(intent);
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et.getText().toString();
                Intent intent = new Intent();//implicit so we don't need to mention where we will go
                intent.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+s);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}