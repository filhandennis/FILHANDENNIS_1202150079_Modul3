package com.lesson.filhan.filhandennis_1202150079_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*
* Class MainActivity merupakan class yang pertama dijalankan setelah splashscreen
* berisikan form untuk melakukan Login sekaligus pengecekannya
*/

public class MainActivity extends AppCompatActivity {

    //Deklarasi Komponen View
    public TextView mUser, mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi ELement View
        mUser = (TextView)findViewById(R.id.txtUsername);
        mPass = (TextView)findViewById(R.id.txtPassword);
    }

    //Aksi Login [username=EAD, password=MOBILE]
    public void loginCheck(){
        String strUser,strPass;
        //Mengambil nilai dari EditText
        strUser = mUser.getText().toString();
        strPass = mPass.getText().toString();
        //Melakukan pemeriksaan Login
        if(!(strUser.equals("EAD") && strPass.equals("MOBILE"))){
            //Jika salah
            Toast.makeText(this,"Username / Password Salah",Toast.LENGTH_SHORT).show();
            return;
        }else{
            //Jika Benar
            Toast.makeText(this,"Berhasil Sign-In",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,DaftarMenu.class));
        }
    }

    //Method untuk Tombol yang diambil dari method LoginCheck
    public void login(View v){
        loginCheck();
    }
}
