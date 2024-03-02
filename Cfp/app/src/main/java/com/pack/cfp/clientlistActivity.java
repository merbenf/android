package com.pack.cfp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class clientlistActivity extends AppCompatActivity {
    ListView ls;
    String nm,prn;
    HashMap<String,String> map;
    parapms p = new parapms();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlist);
        getWindow().setStatusBarColor(ContextCompat.getColor(clientlistActivity.this,R.color.colorAccent));
        ls = findViewById(R.id.lstclient);
        Bundle bndl=getIntent().getExtras();
        if (bndl!=null){
            nm= bndl.getString("a");
            prn= bndl.getString("b");

            map=new HashMap<String, String>();
            map.put("a",nm);
            map.put("b",prn);
            p.values.add(map);
           
        }
        SimpleAdapter adapter=new SimpleAdapter(clientlistActivity.this,p.values,R.layout.item,new String[]{"a","b"},
                new int[]{R.id.nom,R.id.prénom});
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(getApplicationContext(), DetailsActivity.class);
                it.putExtra("position",i);
                startActivity(it);
            }
        });
    }
    }
