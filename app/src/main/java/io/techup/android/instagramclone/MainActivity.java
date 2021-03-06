package io.techup.android.instagramclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    String userName;
    String password;
    EditText etUserName;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvRegister = (TextView) findViewById(R.id.tv_signUp);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutMain);
        ImageView ivLogo = (ImageView) findViewById(R.id.ivLogo);
        btnLogin = (Button) findViewById(R.id.btn_login);
        etUserName = (EditText) findViewById(R.id.et_userName);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        etPassword.setOnKeyListener(this);
        layout.setOnClickListener(this);
        ivLogo.setOnClickListener(this);

//        ParseUser.logOut();

        if (ParseUser.getCurrentUser() != null){
            showUserList();
        }





        

/*        if(ParseUser.getCurrentUser() != null){
            Log.i("currentUser", ParseUser.getCurrentUser().getUsername());
        }else{
            Log.i("currentUser", "User not logged in");
        }*/







        

        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
        query.whereGreaterThan("score", 200);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e == null){
                    Log.i("objects retrieved:", "" + objects.size());
                    if(objects.size()>0){
                        for( ParseObject object :objects){
                            int score = 0;
                            score = object.getInt("score");
                            score += 50;
                            object.put("score", score);
                            Log.i("score", "" + score);
                            object.saveInBackground();


                        }
                    }
                }

            }
        });

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
        query.whereEqualTo("username", "ian");
        query.setLimit(1);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e == null){
                    Log.i("objects retrieved:", "" + objects.size());
                    if(objects.size()>0){
                        for( ParseObject object :objects){
                            Log.i("FindInBackgroundResult", "" + object.getInt("score"));
                        }
                    }
                }

            }
        });


        ParseObject score = new ParseObject("Tweet");
        score.put("username", "ian");
        score.put("tweet", "Hello there. I'm a tweet");
        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    Log.i("SaveInBackground", "Success");
                }else{
                    Log.i("SaveInBackground", "Failed Error:" + String.valueOf(e));

                }
            }
        });

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

        query.getInBackground("AXMqgDePZV", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object !=null) {
                    object.put("tweet", "updating my tweet");
                    object.saveInBackground();

                    Log.i("Object Value", object.getString("username"));
                    Log.i("Object Value", object.getString("tweet"));

                }
            }
        });*/

        ParseAnalytics.trackAppOpenedInBackground(getIntent());


    }
    public void showUserList(){
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn_login:
                userName = etUserName.getText().toString();
                password = etPassword.getText().toString();

                ParseUser.logInInBackground(userName, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Log.i("Login", "Successful");
                            showUserList();
                        } else
                            Log.i("Login", "Failed");
                    }
                });

                break;

            case R.id.tv_signUp:
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.layoutMain:case R.id.ivLogo:
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        }


        Log.i("Login Details", userName + "" + password);

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
            btnLogin.performClick();
        }
        return false;
    }
}
