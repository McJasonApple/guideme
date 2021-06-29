package com.guideme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.garmin.fit.Profile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    TextView username, email, logout, name, ftpValue;
    SharedPreferences sharedPreferences;
    FirebaseAuth fAuth;
    FirebaseUser userId;
    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = findViewById(R.id.usernameTb);
        email = findViewById(R.id.emailTb);
        ftpValue = findViewById(R.id.ftpValue);
        fAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        name = findViewById(R.id.usernameLabel);
        mDatabase = FirebaseDatabase.getInstance();
        userId = FirebaseAuth.getInstance().getCurrentUser();

        sharedPreferences = this.getSharedPreferences("com.guideme", Context.MODE_PRIVATE);

        if (fAuth.getCurrentUser() != null && fAuth.getCurrentUser().isAnonymous() == false) {
            logout.setVisibility(View.VISIBLE);

            readDB();
            ftpValue.setText(Float.toString(sharedPreferences.getFloat("ftp", 210)));
        }
    }

    //edit Username entry in the user profile
    public void onEditUsername(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        EditText editText = new EditText(this);
        dialog.setTitle("Change your Username");
        dialog.setView(editText, 16, 16, 16, 16);

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                username.setText(editText.getText());
                mDatabase.getReference("Users").child(userId.getUid()).child("username").setValue(editText.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ProfileActivity.this, "Username changed", Toast.LENGTH_SHORT);
                        }else{
                            Toast.makeText(ProfileActivity.this, "Username cannot be changed", Toast.LENGTH_SHORT);
                        }
                    }
                });
            }
        });

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(username.getText());
                dialog.show();
            }
        });
        dialog.show();
    }

    //edit FTP entry in the user profile
    public void onEditFTP(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        dialog.setTitle("Change your FTP Value");
        dialog.setView(editText, 16, 16, 16, 16);

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ftpValue.setText(editText.getText());
                sharedPreferences.edit().putFloat("ftp", Float.parseFloat(editText.getText().toString())).apply();

            }
        });

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(username.getText());
                dialog.show();
            }
        });
        dialog.show();
    }

    //get user data from database
    public void readDB(){
        mDatabase.getReference("Users").child(userId.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                username.setText(snapshot.child("username").getValue().toString());
                name.setText(snapshot.child("fullname").getValue().toString());
                email.setText(snapshot.child("email").getValue().toString());
                //ftpValue.setText(snapshot.child("ftp").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void onClickLogout(View v) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    public void onClickBack(View view) {
        onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
