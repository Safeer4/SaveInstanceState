package com.example.saveinstancestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    firstName, lastName and titleEmp are defined so that we can store the data taken from EditText
    EditText firstName, lastName, titleEmp;
//    first, last and title are defined for getting the TextViews and then setting the text in these TextViews
    TextView first, last, title;


//    -------------------------------------------------------------
//    *** To store instance data to not let it be lost when we rotate the device, we use
//    onSaveInstanceState() method which is implemented below. Here the data can be saved only for the
//    current session.
//
//    There are two ways to restore the data which is saved by onSaveInstanceState() method.
//    #1. We can restore it in onCreate method, we can see a Bundle object is passed to onCreate method
//    which is used for restoring the data if available.
//
//    #2. We can also restore the saved data through onRestoreInstanceState() method. A Bundle object is passed
//    here as well, we will use its object to restore the saved data.
//    -------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        We get each EditText field by its ID and assign it to its respective object
        firstName = (EditText)findViewById(R.id.editText4);
        lastName = (EditText)findViewById(R.id.editText5);
        titleEmp = (EditText)findViewById(R.id.editText6);

//        Here we get the TextViews and assign them to their respective objects
        first = (TextView)findViewById(R.id.textView4);
        last = (TextView)findViewById(R.id.textView5);
        title = (TextView)findViewById(R.id.textView6);


//        ****** Method #1 ******
//        If savedInstanceState is not null, means if data is available
//        we will get the data from savedInstanceState object through getString method and save id to
//        its respective variable.
//        Here the savedInstanceState object is used which has been passed from onCreate() method.
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



//    This function is triggered when the button is clicked
//    It takes the data from the EditText fields and show it in TextView
    public void doSomething(View view) {
        first.setText(firstName.getText().toString());
        last.setText(lastName.getText().toString());
        title.setText(titleEmp.getText().toString());
    }

//    This function is used to save the data whenever the device is rotated or gone to a state where
//    this function is being called.
//    The logic is simple it gets the data from the EditText fields and save it in savedInstanceState
//    through putString() method.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("firstN",firstName.getText().toString());
        savedInstanceState.putString("lastN",lastName.getText().toString());
        savedInstanceState.putString("titleE",titleEmp.getText().toString());
    }

//    ****** Method #2 ******
//    This is second way to restore the saved data.
    when the state is restored this functioned is triggered.
    A Bundle object is passed from this method and we will get our data from this object.
    We check if the savedInstanceState is not null then we will get the data from it and show it in
    TextViews.
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