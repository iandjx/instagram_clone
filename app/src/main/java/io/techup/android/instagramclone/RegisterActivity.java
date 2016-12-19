package io.techup.android.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    String username;
    String password;
    Button register;
    EditText etUsername;
    EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText) findViewById(R.id.et_userRegister);
        etPassword = (EditText) findViewById(R.id.et_passwordRegister);
        register = (Button) findViewById(R.id.btn_register);

        register.setOnClickListener(this);


        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }

    @Override
    public void onClick(View v) {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        ParseUser user = new ParseUser();

        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("Sign up", "Success");
                } else {
                    Log.i("Sign up", "Failed");
                }
            }
        });

    }
}
