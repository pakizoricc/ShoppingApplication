package com.example.myshoppingapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myshoppingapplication.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends Activity {

    ActivityRegistrationBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.UserEmail.getText().toString();
                String password = binding.UserPassword.getText().toString();
                String confirmpassword = binding.UserPassword2.getText().toString();

                if(email.equals("") || password.equals("") || confirmpassword.equals("")){
                    Toast.makeText(RegistrationActivity.this, "Sva polja moraju biti uneta!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (password.equals(confirmpassword)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == false){
                            Boolean insert = databaseHelper.insertData(email, password);

                            if (insert == true){
                                Toast.makeText(RegistrationActivity.this, "Registracija uspesna!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegistrationActivity.this, "Neuspesna registracija!", Toast.LENGTH_SHORT).show();
                            }
                        } else{
                            Toast.makeText(RegistrationActivity.this, "Korisnicki e-mail vec postoji!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Šifre se ne poklapaju!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });




    }
}
