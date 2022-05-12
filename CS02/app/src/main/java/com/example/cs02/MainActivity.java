package com.example.cs02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_HoTen=findViewById(R.id.EditText_HoTen);
        EditText et_NamSinh=findViewById(R.id.EditText_NamSinh);
        Button bt_Sumit=findViewById(R.id.Button_Submit);

        bt_Sumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("ht",et_HoTen.getText().toString());
                intent.putExtra("ns", et_NamSinh.getText().toString());
                startActivity(intent);
            }
        });
    }
}