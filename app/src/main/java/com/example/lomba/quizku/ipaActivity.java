package com.example.lomba.quizku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ipaActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Hewan pemakan tumbuhan disebut hewan..",
            "Untuk melakukan fotosintesis, tumbuhan membutuhkan..",
            "Bagian tumbuhan yang berfungsi untuk menyerap air dan menyimpan cadangan makanan adalah..",
            "Serangga yang menghasilkan madu adalah..",
            "Bagian tumbuhan yang menghasilkan aroma harum adalah..",
            "Saat malam, Pohon mengeluarkan?",
            "Lidah kita gunakan untuk?",
            "Mata kita berjumlah?",
            "Andi mengambil buku menggunakan?",
            "Suara yang keras bisa membuat telinga menjadi?"
    };
    String answers[] = {"Herbivora","Sinar matahari","Akar","Lebah","Bunga","Karbondioksida","Merasakan makanan","2","Tangan","Sakit"};
    String opt[] = {
            "Omnivora","Insectivora","Herbivora","Karnivora",
            "Udara","Pupuk","Air","Sinar matahari",
            "Bunga","Akar","Daun","Batang",
            "Lebah","Kupu-kupu","Lalat","Tawon",
            "Bunga","Batang","Akar","Daun",
            "Oksigen","Udara","Karbondioksida","Karbon",
            "Merasakan makanan","Mengunyah makanan","Mencium makanan","Meraba makanan",
            "3","4","2","1",
            "Kaki","Tangan","Sikut","Lutut",
            "Jernih","Bersih","Lembut","Sakit"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipa);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Halo User");
        else
            textView.setText("Halo " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Tolong di pilih ya jawabannya", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;

                }
                else {
                    wrong++;

                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),resultipaActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),resultipaActivity.class);
                startActivity(intent);
            }
        });
    }
}
