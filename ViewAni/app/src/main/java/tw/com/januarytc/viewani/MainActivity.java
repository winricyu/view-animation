package tw.com.januarytc.viewani;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "";
    private ImageView imgIcon1;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ItemBean itemBean=new ItemBean();
        Log.d("XXX",itemBean.getClass().getDeclaredFields().length+"");
        for (Field name :
                itemBean.getClass().getDeclaredFields()) {
            Log.d("OOO", name.getName());
        }


        setContentView(R.layout.activity_main);
        imgIcon1 = (ImageView) findViewById(R.id.img_icon_1);
        listview = (ListView) findViewById(R.id.listview);
        String[] names = new String[]{"YJJ", "ERIC", "JOY", "ALICE", "COOL", "MAMA"};
        int[] imgid = new int[]{R.drawable.icon_32, R.drawable.icon_77, R.drawable.icon_11, R.drawable.icon_61, R.drawable.icon_90, R.drawable.icon_44};
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("icon", imgid[i]);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_item,
                new String[]{"name", "icon"}, new int[]{R.id.text, R.id.img_icon_1});

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String, Object> map = (HashMap<String, Object>) adapterView.getItemAtPosition(i);
                ImageView listShareIcon = (ImageView) view.findViewById(R.id.img_icon_1);
                TextView listShareText = (TextView) view.findViewById(R.id.text);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(listShareIcon, getString(R.string.share_icon_1));
                pairs[1] = new Pair<View, String>(listShareText, getString(R.string.share_text_1));


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("icon", (Integer) map.get("icon"));
                intent.putExtra("name", (String) map.get("name"));
                startActivity(intent, options.toBundle());
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void btnClick(View view) {
        Log.d(TAG, "btnClick: ");


    }


}
