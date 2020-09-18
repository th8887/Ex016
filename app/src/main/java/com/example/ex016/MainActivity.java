package com.example.ex016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText jumps, first;

    String f,j;
    boolean ty=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumps=(EditText) findViewById(R.id.jumps);
        first=(EditText) findViewById(R.id.first);
    }
//false-סדרה חשבונית
//true- סדרה הנדסית
    public void nextPage(View view) {
        f=first.getText().toString();
        j=jumps.getText().toString();
        if((f.equals(""))||(j.equals("")))
            Toast.makeText(this, "you have to enter a number", Toast.LENGTH_SHORT).show();
        else{
        Intent next= new Intent(this, Series.class);
        next.putExtra("type",ty);
        next.putExtra("start",Double.parseDouble(f));
        next.putExtra("jump",Double.parseDouble(j));
        startActivity(next);
        }
    }

    public void type(View view) {
        if(ty==false)
            ty=true;
        else
            ty=false;
    }
}