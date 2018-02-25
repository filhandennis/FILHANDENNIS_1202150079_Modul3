package com.lesson.filhan.filhandennis_1202150079_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
* Class SplashScreen
*/

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //Handler digunakan untuk menangani jeda yang berlangsung selama menjalankan activity
        //atau saat activity ini dibuat
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }, 3500); //menunda menjalankan aksi yang didalamnya selama 3500 (1000=1Detik)= 3,5Detik
    }
}
