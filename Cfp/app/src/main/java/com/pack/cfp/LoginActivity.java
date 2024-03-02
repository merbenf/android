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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button reg,log;
    TextView tv1,tv2;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(ContextCompat.getColor(LoginActivity.this,R.color.colorAccent));
        tv1=findViewById(R.id.text1);
        tv2=findViewById(R.id.text2);
        FirebaseApp.initializeApp(this);
        mauth=FirebaseAuth.getInstance();
        reg=findViewById(R.id.btnRegLogin);
        log=findViewById(R.id.button);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( view.getId() == reg.getId()){
                    Intent i = new Intent(LoginActivity.this,regesterActivity.class);
                    startActivity(i);


                }
            }
        });

        log.setOnClickListener(view ->  {
            loginUser();

        });
    }

    private void loginUser() {
        String email = tv1.getText().toString();

        String pswd = tv2.getText().toString();
        if (TextUtils.isEmpty(email)){
            tv1.setError("veuillez saisir votre email svp!");
            tv1.requestFocus();
        }else if (TextUtils.isEmpty(pswd)){
            tv2.setError("veuillez entrer un mot de passe svp!");
            tv2.requestFocus();

        }else {
            mauth.signInWithEmailAndPassword(email,pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"utilisateur connecté avec succès",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this,"erreur de connexion" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



}

