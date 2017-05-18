package com.rextechnicalsolutions.timednotesgit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView editText1;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (TextView) findViewById(R.id.editText1);
        menuButton = (Button) findViewById(R.id.menuButton);
    }

    public void onMenuClick(View v) {
        editText1.setText("Hello Android User!");
    }
}
