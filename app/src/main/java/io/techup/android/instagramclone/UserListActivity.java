package io.techup.android.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.ParseUser;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    ArrayList<ParseUser> parseUsers;
    ListView userListView;
    ArrayList<String> usernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userListView = (ListView) findViewById(R.id.lv_userList);
        usernames = new ArrayList<>();
        usernames.add("ian");
        usernames.add("ian2");
        usernames.add("ian3");
        usernames.add("ian4");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usernames);
        userListView.setAdapter(arrayAdapter);
    }
}
