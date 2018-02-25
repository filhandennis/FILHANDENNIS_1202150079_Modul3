package com.lesson.filhan.filhandennis_1202150079_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*
* Class DetailMenu digunakan untuk menampilkan Rincian Item
* yang dipilih pada daftar menu.
*/


public class DetailMenu extends AppCompatActivity {

    //Deklarasi Komponen View
    private Button btnAdd, btnMin;
    private ImageView progress, lblImg;
    private TextView lblJudul, lblDesc, lblStats;

    //Level digunakan untuk indikator tingkatan air 0-6 => 7
    private int level =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailitem);

        //Inisialisasi Komponen View
        btnAdd = (Button)findViewById(R.id.btnIsiTambah);
        btnMin = (Button)findViewById(R.id.btnIsiKurang);
        progress = (ImageView) findViewById(R.id.imgIsi);
        //Inisialisasi Komponen View
        lblJudul = (TextView) findViewById(R.id.lblJudul);
        lblDesc =  (TextView) findViewById(R.id.lblDeskripsi);
        lblImg =  (ImageView) findViewById(R.id.lblImg);
        lblStats =  (TextView) findViewById(R.id.lblStatus);

        //Mengambil Intent Ini
        Intent in = getIntent();
        //Mengambil nilai yang dilemparkan pada Intent Ini untuk Judul
        String title=in.getStringExtra("etitle");
        //Mengambil nilai yang dilemparkan pada Intent Ini untuk Deskripsi
        String description=in.getStringExtra("edesc");
        //Memeriksa isi deskripsi apabila kosong maka teks dibawah ini menjadi deskripsi
        if(description.length()<1){description="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ut tincidunt dui. Etiam et tincidunt dolor. Phasellus eu rhoncus sem. Suspendisse laoreet dolor eu nisi dictum congue id ut ipsum. Etiam sagittis sodales urna. Sed condimentum arcu at pretium laoreet. Nam venenatis leo sit amet sodales malesuada. Morbi quis convallis lorem, quis malesuada elit. Integer suscipit mauris et ex finibus, id aliquam nisi maximus. Quisque lacinia suscipit ipsum, in posuere elit eleifend vel. Vestibulum vehicula, est ac interdum tristique, elit odio volutpat ex, eu eleifend erat dolor a mauris.\nInterdum et malesuada fames ac ante ipsum primis in faucibus. Nunc sagittis sagittis orci, a mollis justo ultrices id. Vestibulum a neque eget magna ultricies posuere eget ut sem. Nunc egestas vestibulum metus. Praesent et mi quis dolor pellentesque mattis quis eu turpis. Nunc convallis quis elit vitae ornare. Sed venenatis sed lorem eget posuere. Nam lobortis diam dui, et sollicitudin velit faucibus quis. Donec sit amet neque non diam aliquam imperdiet.\n";}

        //Mengambil nilai yang dilemparkan pada Intent Ini untuk Gambar
        int imgRes = in.getIntExtra("eimg",0);

        //Set Judul pada Action Bar
        setTitle(title);
        //Set Judul
        lblJudul.setText(title);
        //Set Deskripsi
        lblDesc.setText(description);
        //Set Gambar
        lblImg.setImageResource(imgRes);
        //Aksi untuk menambah isi botol
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahIsi();
            }
        });
        //Aksi untuk menambah isi botol
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurangIsi();
            }
        });
    }


    //Method untuk menambahkan tingkat pada botol
    public void tambahIsi(){
        status();
        if(level==6){Toast.makeText(this,"Air Penuh",Toast.LENGTH_SHORT).show();return;}
        //MMenambah level pada botol
        progress.setImageLevel(++level);
    }
    //Method untuk mengurangi tingkat pada botol
    public void kurangIsi(){
        status();
        if(level==0){Toast.makeText(this,"Air Kosong",Toast.LENGTH_SHORT).show();return;}
        //Mengurangi level pada botol
        progress.setImageLevel(--level);
    }
    //Method untuk mengupdate status tingkat pada botol
    public void status(){
        lblStats.setText(""+level+"L");
    }
}
