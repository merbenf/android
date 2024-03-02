package com.pack.cfp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class clientlistActivity extends AppCompatActivity {
    ListView ls;
    SearchView searchView;
    String nm,prn,n,id,art,tel,exist;
    //HashMap<String,String> map;
    ArrayList<Userhelperclass> arrayList =new ArrayList<>();
    parapms p = new parapms();
    FloatingActionButton fab;
    DatabaseReference mRef;

    private UserAdepter adpter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlist);
        searchView =findViewById(R.id.search);
        fab=findViewById(R.id.btn_fab);

       //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(clientlistActivity.this, R.layout.item,arrayList);
        getWindow().setStatusBarColor(ContextCompat.getColor(clientlistActivity.this,R.color.colorAccent));
        ls = (ListView) findViewById(R.id.lstclient);


        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(getApplicationContext(), DetailsActivity.class);
                Userhelperclass user = arrayList.get(i);
                it.putExtra("User",user);
                startActivity(it);

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
             return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Userhelperclass> list_search = null;
                if (!newText.isEmpty()) {
                    list_search = new ArrayList<>();
                    for (Userhelperclass user : arrayList) {

                        if (user.getNom().contains((CharSequence) newText) ||
                                user.getPrenom().contains((CharSequence)newText)) {
                            list_search.add(user);
                        }
                    }
                    ((UserAdepter) ls.getAdapter()).Update(list_search);
                }else{
                    list_search = new ArrayList<>(arrayList);
                    ((UserAdepter) ls.getAdapter()).Update(list_search);
                }
                return false;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent icp = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(icp);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        mRef =FirebaseDatabase.getInstance().getReference("users");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot n :snapshot.getChildren()){
                    Userhelperclass user =  n.getValue(Userhelperclass.class);
                    arrayList.add(user);
                }

                adpter = new UserAdepter(getApplicationContext(), R.layout.item, arrayList);
                ls.setAdapter(adpter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(clientlistActivity.this, "PROBLlEME", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
