package com.pack.cfp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class regesterActivity extends AppCompatActivity {
    Button log,reg;
    TextView tv3,tv4,tv5;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);
        getWindow().setStatusBarColor(ContextCompat.getColor(regesterActivity.this,R.color.colorAccent));
        tv3= findViewById(R.id.text3);
        tv4= findViewById(R.id.text4);
        tv5= findViewById(R.id.text5);
        reg=findViewById(R.id.button);
        log= findViewById(R.id.btnLogRegister);
        mauth = FirebaseAuth.getInstance();
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==log.getId()){
                    Intent it = new Intent(regesterActivity.this, LoginActivity.class);
                    startActivity(it);
                }
            }
        });

        reg.setOnClickListener(view ->{
            createuser();
        });
    }

    private void createuser() {
        String email = tv4.getText().toString();
        String name = tv3.getText().toString();
        String pswd = tv5.getText().toString();
        if (TextUtils.isEmpty(email)){
            tv4.setError("veuillez saisir votre email svp!");
            tv4.requestFocus();
        }else if (TextUtils.isEmpty(pswd)){
            tv5.setError("veuillez entrer un mot de passe svp!");
            tv5.requestFocus();

        }
        else if (TextUtils.isEmpty(name)){
            tv3.setError("veuillez entrer votre nom svp!");
            tv3.requestFocus();

        }else{
            mauth.createUserWithEmailAndPassword(email,pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(regesterActivity.this,"utilisateur enregistré avec succès",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(regesterActivity.this,LoginActivity.class));
                    }else{
                        Toast.makeText(regesterActivity.this,"erreur d’enregistrement" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }
    }
