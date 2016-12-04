package io.techup.android.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


/*        ParseObject score = new ParseObject("Tweet");
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
        });*/

 /*       ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

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
}
