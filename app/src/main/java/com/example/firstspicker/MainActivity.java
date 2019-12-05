package com.example.firstspicker;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spin ;
    EditText edit;
    TextView text;
    String value,tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.editText);
        spin = (Spinner) findViewById(R.id.spin);
        text = (TextView) findViewById(R.id.textView) ;
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.namePhone, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        value=parent.getItemAtPosition(position).toString();
        Log.i(tag, value);
        text.setText("Phone Number: " + edit.getText() + " " + value);
        if(position==4){
            edit.setInputType(InputType.TYPE_CLASS_TEXT);
        }else{
            edit.setInputType(InputType.TYPE_CLASS_PHONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
