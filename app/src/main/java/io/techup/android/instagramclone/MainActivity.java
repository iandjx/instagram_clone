package io.techup.android.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    /*    ParseObject score = new ParseObject("Score");
        score.put("username", "rob");
        score.put("score", 86);
        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    Log.i("SaveInBackground", "Success");
                }else{
                    Log.i("SaveInBackground", "Failed Error:" + String.valueOf(e));

                }
            }
        });*/

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

        query.getInBackground("kwQGL1vc7b", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object !=null) {
                    Log.i("Object Value", object.getString("username"));
                    Log.i("Object Value", Integer.toString(object.getInt("score")));

                }
            }
        });

        ParseAnalytics.trackAppOpenedInBackground(getIntent());


    }
}
