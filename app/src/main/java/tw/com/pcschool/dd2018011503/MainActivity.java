package tw.com.pcschool.dd2018011503;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText);
        tv1 = (TextView) findViewById(R.id.textView);
    }
    public void clickWrite(View v)
    {
        SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("data1", et1.getText().toString());
        editor.commit();        //儲存到本機
    }
    public void clickRead(View v)
    {
        SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE);
        String str1 = sp.getString("data1", "");
        tv1.setText(str1);
    }
    public void clickSetting(View v)
    {
        Intent it1 = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(it1);
    }
    public void clickRead2(View v)
    {
        SharedPreferences sp1 = PreferenceManager.getDefaultSharedPreferences(this);
        String str1 = sp1.getString("example_text", "");
        tv1.setText(str1);
    }
}
