package com.example.ex016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Series extends AppCompatActivity implements AdapterView.OnItemClickListener {
    /*true- סדרה הנדסית
    false-סדרה חשבונית
     */
    ListView series;
    TextView x1,d,n,sn;
    boolean op;
    double n0,nd;
    String [] arrs= new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        series=(ListView) findViewById(R.id.series);
        x1=(TextView) findViewById(R.id.x1);
        d=(TextView) findViewById(R.id.d);
        n=(TextView) findViewById(R.id.n);
        sn=(TextView) findViewById(R.id.sn);
        series.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        shows();
        series.setOnItemClickListener(this);
        ArrayAdapter<String> connect= new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,arrs);

        series.setAdapter(connect);
    }
//shows();-בניית מערך הנתונים
    public void shows(){
        Intent here= getIntent();
        op=here.getBooleanExtra("type",false);
        n0=here.getDoubleExtra("start",-0.003);
        nd=here.getDoubleExtra("jump",0);
        x1.setText("x1="+n0);
        d.setText("d="+nd);
        arrs[0]=Double.toString(n0);
        if(op){
            if(nd==1)
                for (int i = 1; i < 20; i++) {
                    arrs[i] =Double.toString(n0);
                }
            else{
                for (int i = 1; i < 20; i++) {
                        arrs[i] =Double.toString((n0 * Math.pow(nd, i)));
                }
            }
            }
        else{
            if (nd == 0)
                for (int i = 1; i < 20; i++) {
                    arrs[i] = Double.toString(n0);
                }
            else {
                for (int i = 1; i < 20; i++) {
                    arrs[i] =Double.toString( (n0 + (nd * i)));
                }
            }
        }
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        n.setText("n="+(pos+1));
        if (op)
            if (nd==1)
                sn.setText("Sn="+n0*(pos+1));
            else
                sn.setText("Sn="+(n0*(Math.pow(nd,pos+1)-1))/(nd-1));
        else
            sn.setText("Sn="+(((2*n0+(pos)*nd)/2)*(pos+1)));
    }
}
