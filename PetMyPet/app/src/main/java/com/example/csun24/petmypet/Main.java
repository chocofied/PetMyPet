package com.example.csun24.petmypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText etUsername, etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etName = (EditText) findViewById(R.id.etName) ;
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bLogout:


                break;
        }
    }

}
