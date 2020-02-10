package com.example.foodorderapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private EditText email;
    private EditText password;
    private TextView textview;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        button=(Button)findViewById(R.id.register);
        email =(EditText)findViewById(R.id.TextEmail);
        password =(EditText)findViewById(R.id.TextPassword);
        textview=(TextView)findViewById(R.id.Signin);
        button.setOnClickListener(this);
        textview.setOnClickListener(this);
        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileToggle.class));
        }
    }
    private void registerUser()
    {
        String emailuser= email.getText().toString().trim();
        String pwduser=password.getText().toString().trim();
        if(TextUtils.isEmpty(emailuser))
        {
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pwduser))
        {
            Toast.makeText(this,"Please enter passsword",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
         firebaseAuth.createUserWithEmailAndPassword(emailuser,pwduser).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                        finish();
                        startActivity(new Intent(getApplicationContext(), ProfileToggle.class));
                }
                else
                {
                    Toast.makeText(SignUpActivity.this,"Could Not Register, Please try again",Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });



    }
    @Override
    public void onClick(View v) {
        if(v==button)
        {
            registerUser();
        }
        if(v==textview)
        {
          startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
