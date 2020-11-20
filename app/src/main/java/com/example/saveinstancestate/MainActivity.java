package com.example.saveinstancestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstName, lastName, titleEmp;
    TextView first, last, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText)findViewById(R.id.editText4);
        lastName = (EditText)findViewById(R.id.editText5);
        titleEmp = (EditText)findViewById(R.id.editText6);

        first = (TextView)findViewById(R.id.textView4);
        last = (TextView)findViewById(R.id.textView5);
        title = (TextView)findViewById(R.id.textView6);

//        if(savedInstanceState != null) {
//            String sFirstName = savedInstanceState.getString("firstN");
//            first.setText(sFirstName);
//
//            String sLastName = savedInstanceState.getString("lastN");
//            last.setText(sLastName);
//
//            String sJobTitle = savedInstanceState.getString("titleE");
//            title.setText(sJobTitle);
//        }
    }

    public void doSomething(View view) {
        first.setText(firstName.getText().toString());
        last.setText(lastName.getText().toString());
        title.setText(titleEmp.getText().toString());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("firstN",firstName.getText().toString());
        savedInstanceState.putString("lastN",lastName.getText().toString());
        savedInstanceState.putString("titleE",titleEmp.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            String sFirstName = savedInstanceState.getString("firstN");
            first.setText(sFirstName);

            String sLastName = savedInstanceState.getString("lastN");
            last.setText(sLastName);

            String sJobTitle = savedInstanceState.getString("titleE");
            title.setText(sJobTitle);
        }
    }
}