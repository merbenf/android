package com.pack.cfp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText tx1,tx2,tx3,tx4,tx5,tx6,tx7;
    Button add,opn,logot;
    CheckBox cx1,cx2,cx3,cx4,cx5,cx6;
    FirebaseAuth mauth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
        cx1=findViewById(R.id.chbx1);
        cx2=findViewById(R.id.chbx2);
        cx3=findViewById(R.id.chbx3);
        cx4=findViewById(R.id.chbx4);
        cx5=findViewById(R.id.chbx5);
        cx6=findViewById(R.id.chbx6);
        mauth = FirebaseAuth.getInstance();
        boolean isch1 = cx1.isChecked();
        boolean isch2 = cx2.isChecked();
        boolean isch3 = cx3.isChecked();
        boolean isch4 = cx4.isChecked();
        boolean isch5 = cx5.isChecked();
        boolean isch6 = cx6.isChecked();

        tx1=findViewById(R.id.nomcl);
        tx2=findViewById(R.id.prncl);
        tx3=findViewById(R.id.edt3);
        tx4=findViewById(R.id.edt4);
        tx5=findViewById(R.id.edt5);
        tx6=findViewById(R.id.edt6);
        tx7=findViewById(R.id.edt7);
        logot=findViewById(R.id.logout);
        opn=findViewById(R.id.supr);
        add=findViewById(R.id.mdfie);
        add.setEnabled(false);
        tx1.addTextChangedListener(twtwtch);
        tx2.addTextChangedListener(twtwtch);
        tx3.addTextChangedListener(twtwtch);
        tx4.addTextChangedListener(twtwtch);
        tx5.addTextChangedListener(twtwtch);
        tx6.addTextChangedListener(twtwtch);
        tx7.addTextChangedListener(twtwtch);






        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==add.getId()){
                    Intent icp = new Intent(getApplicationContext(),clientlistActivity.class);
                    Bundle bndl = new Bundle();
                    bndl.putString("a",tx1.getText().toString());
                    bndl.putString("b",tx2.getText().toString());
                    bndl.putString("c",tx3.getText().toString());
                    bndl.putString("d",tx4.getText().toString());
                    bndl.putString("e",tx5.getText().toString());
                    bndl.putString("f",tx6.getText().toString());
                    bndl.putString("g",tx7.getText().toString());
                    icp.putExtras(bndl);
                    startActivity(icp);
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("users");
                    //get all values
                    String nom = tx1.getText().toString();
                    String prnom = tx2.getText().toString();
                    String numrc = tx3.getText().toString();
                    String idf = tx4.getText().toString();
                    String numart = tx5.getText().toString();
                    String numtel = tx6.getText().toString();
                    String cert = tx7.getText().toString();

                    Userhelperclass helpclass = new Userhelperclass(nom,prnom,numrc,idf,numart,numtel,cert);
                    reference.child(idf).setValue(helpclass);


                }

            }
        });

        opn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==opn.getId()){
                    Intent icp = new Intent(getApplicationContext(),clientlistActivity.class);
                    startActivity(icp);
                }
            }
        });
        logot.setOnClickListener(view -> {
            mauth.signOut();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));

        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mauth.getCurrentUser();
        if (user== null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }

    private TextWatcher twtwtch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String a = tx1.getText().toString();
            String b = tx2.getText().toString();
            String c = tx3.getText().toString();
            String d = tx4.getText().toString();
            String e = tx5.getText().toString();
            String f = tx6.getText().toString();
            String g = tx7.getText().toString();
            if (!a.isEmpty() && !b.isEmpty() && !c.isEmpty() && !d.isEmpty() && !e.isEmpty() && !f.isEmpty() && !g.isEmpty() )
            {
                //all are not empty
                add.setEnabled(true);
            }else{
                add.setEnabled(false);
                Toast.makeText(MainActivity.this, "veuillez saisir tout les champs svp !", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    }
