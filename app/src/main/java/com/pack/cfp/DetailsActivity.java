package com.pack.cfp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {
    EditText nm,prn,nrc,ifl,na,nt,ce;
    Button mod,sup;
    int position;
    //HashMap<String,String> m;
    parapms p = new parapms();
    DatabaseReference reference;
    Userhelperclass user = null;
    //String _nom,_prenom,_numre,_idf,_numart,_numt,_cert;
    CheckBox chbx1,chbx2,chbx3,chbx4,chbx5,chbx6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

       reference= FirebaseDatabase.getInstance().getReference("users");
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

        chbx1 = findViewById(R.id.chbx1);
        chbx2 = findViewById(R.id.chbx2);
        chbx3 = findViewById(R.id.chbx3);
        chbx4 = findViewById(R.id.chbx4);
        chbx5 = findViewById(R.id.chbx5);
        chbx6 = findViewById(R.id.chbx6);

        Bundle bndl=getIntent().getExtras();
        if (bndl!=null){
            user = (Userhelperclass) bndl.getSerializable("User");
            nm.setText(user.getNom());
            prn.setText(user.getPrenom());
            nrc.setText(user.getNumrc());
            ifl.setText(user.getIdf());
            na.setText(user.getNuart());
            nt.setText(user.getNumtel());
            ce.setText(user.getCert());
            chbx1.setChecked(user.isReel_physique());
            chbx2.setChecked(user.isReel_moral());
            chbx3.setChecked(user.isForfitaire());
            chbx4.setChecked(user.isEmployes_plus_10());
            chbx5.setChecked(user.isEmployes_mains_10());
            chbx6.setChecked(user.isEntrepreneur());

        }

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = user.getId_user();

                DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("users");
                Userhelperclass UpdateUser = new Userhelperclass();
                UpdateUser.setId_user(id);
                UpdateUser.setNom(nm.getText().toString());
                UpdateUser.setPrenom(prn.getText().toString());
                UpdateUser.setNumrc(nrc.getText().toString());
                UpdateUser.setIdf(ifl.getText().toString());
                UpdateUser.setNuart(na.getText().toString());
                UpdateUser.setNumtel(nt.getText().toString());
                UpdateUser.setCert(ce.getText().toString());
                UpdateUser.setReel_physique(chbx1.isChecked());
                UpdateUser.setReel_moral(chbx2.isChecked());
                UpdateUser.setForfitaire(chbx3.isChecked());
                UpdateUser.setEmployes_plus_10(chbx4.isChecked());
                UpdateUser.setEmployes_mains_10(chbx5.isChecked());
                UpdateUser.setEntrepreneur(chbx6.isChecked());
                mRef.child(id).setValue(UpdateUser);

                Intent i = new Intent(getApplicationContext(),clientlistActivity.class);
                startActivity(i);
                finish();
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(DetailsActivity.this);
                alert.setTitle("Attention !");
                alert.setCancelable(false);
                alert.setMessage("voulez vous vraiment supprimer ce client ?");
                alert.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    }
                });

                alert.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String id = user.getId_user();
                        reference.child(id).removeValue();

                        Intent intent = new Intent(getApplicationContext(),clientlistActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });alert.create().show();

               // p.values.remove(position);
               // Intent i = new Intent(getApplicationContext(),clientlistActivity.class);
                //startActivity(i);
                //finish();
            }
        });

    }


    }

