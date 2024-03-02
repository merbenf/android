package com.pack.cfp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {
    EditText nm,prn,nrc,ifl,na,nt,ce;
    Button mod,sup;
    int position;
    HashMap<String,String> m;
    parapms p = new parapms();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(DetailsActivity.this,R.color.colorAccent));
        nm=findViewById(R.id.nomcl);
        prn=findViewById(R.id.prncl);
        nrc=findViewById(R.id.edt3);
        ifl=findViewById(R.id.edt4);
        na=findViewById(R.id.edt5);
        nt=findViewById(R.id.edt6);
        ce=findViewById(R.id.edt7);
        mod=findViewById(R.id.mdfie);
        sup=findViewById(R.id.supr);

        Bundle bndl=getIntent().getExtras();
        if (bndl!=null){
            position=bndl.getInt("position");

        }
        m = p.values.get(position);
        nm.setText(m.get("a"));
        prn.setText(m.get("b"));
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.put("a",nm.getText().toString());
                m.put("b",prn.getText().toString());
                Intent i = new Intent(getApplicationContext(),clientlistActivity.class);
                startActivity(i);
                finish();
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.values.remove(position);
                Intent i = new Intent(getApplicationContext(),clientlistActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
    }
