package tw.com.januarytc.viewani;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private static final String TAG = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        if (getIntent() != null) {
            int iconResID = getIntent().getIntExtra("icon", 0);
            String textName= getIntent().getStringExtra("name");
            if (iconResID >0) {
            ImageView imageView = (ImageView) findViewById(R.id.img_share_icon);
            imageView.setImageResource(iconResID);
            }
            if(!TextUtils.isEmpty(textName)){
                TextView textView=(TextView)findViewById(R.id.text_share);
                textView.setText(textName);
            }

        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: ");
        finishAfterTransition();
        return super.onSupportNavigateUp();
    }
}
