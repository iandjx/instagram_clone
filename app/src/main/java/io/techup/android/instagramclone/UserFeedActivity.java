package io.techup.android.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class UserFeedActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feed);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        ImageView imageView = new ImageView(getApplicationContext());

        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.pencil));

        linearLayout.addView(imageView);
    }
}
