package tnsmssearch.mahiti.org.mysqliteapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button addBtn,viewBtn;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);
        editText1=(EditText)findViewById(R.id.editText);
        addBtn=(Button)findViewById(R.id.button1);
        viewBtn=(Button)findViewById(R.id.button2);


        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText1.getText().toString();
                if (editText1.length() != 0) {
                    AddData(newEntry);
                    editText1.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You must put something in " +
                            "the text field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void AddData(String newEntry){

       if(myDB.addData(newEntry)){
           Toast.makeText(this, "Data is successfully entered!", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
           }
    }
}
