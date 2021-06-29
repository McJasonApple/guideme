package com.guideme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1001; //Sign In Request Code
    EditText eMail, password;
    TextView registerText;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        eMail        = findViewById(R.id.emailAdress);
        password     = findViewById(R.id.password);
        progressBar  = findViewById(R.id.progressBar2);
        fAuth        = FirebaseAuth.getInstance();
        registerText = findViewById(R.id.registerText);

        if(fAuth.getCurrentUser() != null){
            //startActivity(new Intent(getApplicationContext(), MapActivity.class));
            //fAuth.signOut();
            finish();
        }

        registerText.setOnClickListener(v ->  {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            finish();
        });
    }

    public void onClickLogin(View v){
        String _email = eMail.getText().toString().trim();
        String _password = password.getText().toString().trim();

        //entry data verification
        if(TextUtils.isEmpty(_email)){
            eMail.setError("Email is required");
            return;
        }

        if(TextUtils.isEmpty(_password)){
            password.setError("Password is required");
            return;
        }

        if(_password.length()<6){
            password.setError("Password must be >= 6 characters");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //authenticate user
        fAuth.signInWithEmailAndPassword(_email, _password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MapActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Error! \r\n" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onClickGuestSignIn(View view){
        progressBar.setVisibility(View.VISIBLE);
        fAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = fAuth.getCurrentUser();

                            startActivity(new Intent(getApplicationContext(),MapActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Snackbar.make(getCurrentFocus(), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });
        progressBar.setVisibility(View.GONE);
    }
}