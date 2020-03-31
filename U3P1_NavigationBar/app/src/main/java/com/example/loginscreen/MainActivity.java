package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView
{
    private LoginPresenter presenter;
    private TextView textViewUserName;
    private TextView textViewPassword;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUserName = findViewById(R.id.textViewUserName);
        textViewPassword = findViewById(R.id.textViewPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        presenter = new LoginPresenterImpl(this);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleLogin(textViewUserName.getText().toString(), textViewPassword.getText().toString());
            }
        });
    }

    @Override
    public void showValidationErrorMsg()
    {
        Toast.makeText(this, "Username or password is empty", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void loginSuccessFully()
    {
//        Toast.makeText(this, "Login SuccessFully", Toast.LENGTH_SHORT).show();
        openHomeScreen();
    }
    @Override
    public void loginFail()
    {
        Toast.makeText(this, "Username or password does not exist", Toast.LENGTH_SHORT).show();
    }

    private void openHomeScreen() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}


