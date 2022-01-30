package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pklhbutton=(Button)findViewById(R.id.pklh);
        Button metikbutton=(Button)findViewById(R.id.metik);
        Button ipabutton=(Button)findViewById(R.id.ipa);
        Button bindobutton=(Button)findViewById(R.id.bindo);

        final EditText nametext=(EditText)findViewById(R.id.editName);

                pklhbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name=nametext.getText().toString();
                        Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);
                        intent.putExtra("myname",name);
                        startActivity(intent);
                    }
                });

                metikbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name=nametext.getText().toString();
                        Intent intent=new Intent(getApplicationContext(),metikActivity.class);
                        intent.putExtra("myname",name);
                        startActivity(intent);
                    }
                });

                ipabutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name=nametext.getText().toString();
                        Intent intent=new Intent(getApplicationContext(),ipaActivity.class);
                        intent.putExtra("myname",name);
                        startActivity(intent);
                    }
                });

                bindobutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name=nametext.getText().toString();
                        Intent intent=new Intent(getApplicationContext(),bindoActivity.class);
                        intent.putExtra("myname",name);
                        startActivity(intent);
                    }
                });


    }
}
