package com.example.myshoppingapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshoppingapplication.databinding.ActivityLoginBinding;
import com.example.myshoppingapplication.databinding.CartProductBinding;

public class CartProductActivity extends Activity {

    CartProductBinding binding;
    DatabaseCart databaseCart;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = CartProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseCart = new DatabaseCart(this);

        Intent intent = getIntent();
        if (intent != null) {
            String primljenTekst = intent.getStringExtra("tekst");
            TextView textView = findViewById(R.id.name_product);
            textView.setText(primljenTekst);
        }

        binding.buyprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.UserEmail.getText().toString();
                String firstname = binding.fname.getText().toString();
                String lastname = binding.lname.getText().toString();
                String sizeofcloth = binding.sizecloth.getText().toString();
                Boolean insert = databaseCart.insertProduct(email, firstname, lastname, sizeofcloth);
                if(insert == true){
                    Toast.makeText(CartProductActivity.this, "Uspesno ste kupili proizvod!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CartProductActivity.this, "Neuspesna kupovina! Pokusajte ponovo!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
