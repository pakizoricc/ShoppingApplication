package com.example.myshoppingapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myshoppingapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends Activity {
    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.UserEmail.getText().toString();
                String password = binding.UserPassword.getText().toString();

                if(email.equals("") || password.equals("")){
                    Toast.makeText(LoginActivity.this, "Nisu uneta sva polja!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkEmailPass = databaseHelper.checkEmailPassword(email, password);

                    if(checkEmailPass == true){
                        Toast.makeText(LoginActivity.this, "Uspešno ste se ulogovali!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Korisničko ime ili šifra nisu tačni!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.linkUserSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
