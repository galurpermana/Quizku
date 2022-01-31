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

public class bindoActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Ibu membersihkan lantai dengan...",
            "Huruf kapital a adalah...",
            "Ayah mendengarkan radio dengan...",
            "Saat berpisah dengan teman, ktia mengucapkan...",
            "Rumahku bersih karena sering...",
            "Kucing itu bersuara...",
            "Membuang sampah harus di...",
            "Andi belum makan, maka Andi merasa...",
            "Ibu membeli ... di apotek.",
            "Binatang  yang bisa merayap adalah..."
    };
    String answers[] = {"Sapu","A","Telinga","Sampai jumpa","Dibersihkan","Mengeong","Tempat sampah","Lapar","Obat","Ayam-Ikan-Kuda-Kambing"};
    String opt[] = {
            "Pulpen","Sapu","Sula","Tas",
            "A","R","P","J",
            "Mata","Alis","Telinga","Tangan",
            "Terimakasih","Sampai jumpa","Apa kabar?","Selamat pagi",
            "Dibersihkan","Dikotori","Dibiarkan","Dirusak",
            "Berkicau","Mengaum","Berkokok","Mengeong",
            "Tempat sampah","Sungai","Jalanan","Halaman",
            "Lapar","Kenyang","Sedih","Senang",
            "Baju","Obat","Kentang","Roti",
            "Kucing","Katak","Cicak","Kadal"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindo);

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
                    Intent in = new Intent(getApplicationContext(),resultbindoActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),resultbindoActivity.class);
                startActivity(intent);
            }
        });
    }

}