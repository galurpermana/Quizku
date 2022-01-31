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

public class metikActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "tujuh belas jika ditulis angka yaitu",
            "(1+5)-2=",
            "(2+1)+(5-3)=",
            "(1+21)-(5-5)=",
            "5, 7, 6, 8 urutkan bilangan tersebut dari yang terkecil",
            "1, 19, 22, 50 Bilangan yang paling besar adalah..",
            "Yunda memilikii 8 bunga,  Nadsya memiliki 12 bunga Berarti bunga Yunda lebih …. dari bunga Nadsya",
            "15 pencil + 6 pencil =",
            "Angka di antara 14 dan 16 adalah...",
            "Terdapat 12 kambing, 9 ayam, 10 ikan dan 11 kuda di ladang, Urutan hewan yang paling terendah adalah.."
    };
    String answers[] = {"17","4","5","22","5-6-7-8","50","Sedikit","21 pencil","15","Ayam-Ikan-Kuda-Kambing"};
    String opt[] = {
            "17","117","71","171",
            "9","5","4","3",
            "7","6","4","5",
            "5","21","22","5",
            "5-6-8-7","5-6-7-8","4-5-6-7-8","6-5-7-8",
            "22","1","50","19",
            "Banyak","Sedikit","Sama dengan","Besar",
            "22 pencil","19 pencil","21 pencil","20 pencil",
            "12","13","14","15",
            "Ikan-Ayam-Kuda-Kambing","Kambing-Kuda-Ikan-Kambing","Kuda-Ikan-Ayam-Kambing","Ayam-Ikan-Kuda-Kambing"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metik);

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
                    Intent in = new Intent(getApplicationContext(),resultmetikActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),resultmetikActivity.class);
                startActivity(intent);
            }
        });
    }

}