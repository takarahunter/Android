package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        EditText et_Id=findViewById(R.id.ID);
        EditText et_name=findViewById(R.id.Name);
        EditText et_Address=findViewById(R.id.Address);
        EditText et_Email=findViewById(R.id.Email);
        GridView gv_ListAuthor=findViewById(R.id.ListAuthor);
        DBHelper dbHelper=new DBHelper(this);

        Button bt_save=findViewById(R.id.Save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author= new Author();
                author.setIdAuthor(Integer.parseInt(et_Id.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_Address.getText().toString());
                author.setEmail(et_Email.getText().toString());
                if (dbHelper.insertAuthor(author)>0)
                    Toast.makeText(getApplicationContext(),"Bạn đã lưu thành công",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Bạn lưu không thành công",Toast.LENGTH_SHORT).show();
            }
        });

        Button bt_select=findViewById(R.id.Select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list_Author=new ArrayList<>();
                ArrayList<String> list_String= new ArrayList<>();
                list_Author= dbHelper.getAllAuthor();
                if(et_Id.getText().toString().equals("")){
                    list_Author= dbHelper.getAllAuthor();
                }else{
                    list_Author.add(dbHelper.getIdAuthor(Integer.parseInt(et_Id.getText().toString())));

                }
                for (Author au:list_Author){
                    list_String.add(au.getIdAuthor()+"");
                    list_String.add(au.getName());
                    list_String.add(au.getAddress());
                    list_String.add(au.getEmail());
                }
                ArrayAdapter<String> adapter= new ArrayAdapter<>(AuthorActivity.this,android.R.layout.simple_list_item_1);
                gv_ListAuthor.setAdapter(adapter);
            }
        });
        Button bt_Exit=findViewById(R.id.Exit);
        bt_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}