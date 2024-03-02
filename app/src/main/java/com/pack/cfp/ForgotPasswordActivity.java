package com.pack.cfp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {
private EditText emailedttxt;
private Button resetpswd;
private ProgressBar prgrsbar;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getWindow().setStatusBarColor(ContextCompat.getColor(ForgotPasswordActivity.this,R.color.colorAccent));
          emailedttxt = findViewById(R.id.email);
          resetpswd= findViewById(R.id.btnmdp);
          prgrsbar= findViewById(R.id.pbar);
          auth=FirebaseAuth.getInstance();
          resetpswd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  resetPassword();
              }
          });



    }

    private void resetPassword() {
        //fiew validations
        String email = emailedttxt.getText().toString().trim();
        if (email.isEmpty()){
            emailedttxt.setError("e-mail est requis!");
            emailedttxt.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailedttxt.setError("merci de fournir un email valide");
            emailedttxt.requestFocus();
            return;
        }
        prgrsbar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this, "consultez votre e-mail pour réinitialiser votre mot de passe", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ForgotPasswordActivity.this, "\n" +
                            "réessayer! Quelque chose c'est mal passé", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}