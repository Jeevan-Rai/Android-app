package com.example.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usermanagement.ModelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    TextView loginlink;
    EditText name;
    EditText etemail;
    EditText etpassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        hide action bar
        getSupportActionBar().hide();

//        hide status bar
        getWindow().setFlags(
               WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);


        name = findViewById(R.id.etname);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        register = findViewById(R.id.btnregister);
        loginlink = findViewById(R.id.loginlink);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        loginlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void registerUser() {
        String username = name.getText().toString();
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();

        if(username.isEmpty()){
            name.requestFocus();
            name.setError("Enter your name");
            return;
        }

        if (email.isEmpty()){
            etemail.requestFocus();
            etemail.setError("Enter your email");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etemail.requestFocus();
            etemail.setError("Enter correct email");
            return;
        }

        if (password.isEmpty()){
            etpassword.requestFocus();
            etpassword.setError("Enter password");
            return;
        }

        if (password.length() < 8){
            etpassword.requestFocus();
            etpassword.setError("Password should be greater than 8 characters");
            return;
        }
        Call<RegisterResponse> call = RetrofitClient.getInstance().getapi().register(username,email,password);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse = response.body();
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }

                else {
                    Toast.makeText(MainActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}