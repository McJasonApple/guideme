package com.guideme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText fullName, eMail, password, username;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView loginText;
    double ftp = 210;
    FirebaseUser user;
    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName    = findViewById(R.id.fullname);
        eMail       = findViewById(R.id.regEmailAdress);
        password    = findViewById(R.id.regPassword);
        username    = findViewById(R.id.benutzername);
        loginText   = findViewById(R.id.loginText);
        fAuth       = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        mDatabase = FirebaseDatabase.getInstance();

        loginText.setOnClickListener(v ->  {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });
    }

    public void onClickRegister(View v){
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

        //register user in firebase
        fAuth.createUserWithEmailAndPassword(_email, _password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    writeUserDataInDB();
                    fAuth.signOut();
                    Toast.makeText(RegisterActivity.this, "User created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }else{
                    Toast.makeText(RegisterActivity.this, "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    //write user data in database
    public void writeUserDataInDB(){
        user = fAuth.getCurrentUser();
        User userInfo = new User(fullName.getText().toString(), username.getText().toString(),
                eMail.getText().toString(), ftp);

        mDatabase.getReference("Users").child(user.getUid()).setValue(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registration in DB Success", Toast.LENGTH_SHORT);
                }else{
                    Toast.makeText(RegisterActivity.this, "Registration in DB FAILED", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //fAuth.signOut();
    }
}