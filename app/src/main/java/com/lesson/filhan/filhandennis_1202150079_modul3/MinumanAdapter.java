package com.lesson.filhan.filhandennis_1202150079_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * MinumanAdapter digunakan untuk penghubung antara kompulan data logic
 * menjadi kumpulan komponen view (RecyclerView Item)
 */


public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.MinumanViewHolder>{

    //ArrayList digunakan untuk menampung kumpulan data dengan objek sama
    public ArrayList<MinumanItem> datas;
    //Konstruktor untuk memasukkan kumpulan data
    public MinumanAdapter(ArrayList<MinumanItem> datas) {
        this.datas = datas;
        Log.d("JUMLAH_ARRAYLIST","Items: "+getItemCount());
    }

    @Override
    public MinumanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_menu, parent, false);
        return new MinumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MinumanViewHolder holder, int position) {
        //Position = 1 Object Minuman
        final MinumanItem item = datas.get(position);
        //Memberikan Nilai ke Objek Minuman berdasrkan posisi
        holder.bindTo(item);
        //Memberikan Aksi terhadap baris komponen item
        //Aksi pindah ke activiy lain = deskripsi item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mmbuat Intent
                Intent go = new Intent(view.getContext().getApplicationContext(),DetailMenu.class);
                //Membuat nilai yang akan dilempar ke intent tujuan
                //Judul
                go.putExtra("etitle",item.getNama());
                //Deskripsi
                go.putExtra("edesc",item.getDeskripsi());
                //Gambar
                go.putExtra("eimg",item.getGambar());
                //Pergi ke Intent Tujuan
                view.getContext().startActivity(go);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /*
    * Class ViewHolder yang digunakan untuk mendefinisikan apa bagaimanan
    * dan apa saja yang bisa dilakukan oleh tiap baris item di recycler view
    */
    class MinumanViewHolder extends RecyclerView.ViewHolder{

        private TextView mLblMinumanJudul;
        private TextView mLblMinumanInfo;
        private ImageView mLblMinumanImg;
        private Context mContext;
        private MinumanItem mCurrentMinuman;

        //Konstruktor untuk mengambil komponen view
        public MinumanViewHolder(View itemView) {
            super(itemView);
            mLblMinumanJudul = (TextView)itemView.findViewById(R.id.lblItemJudul);
            mLblMinumanInfo = (TextView)itemView.findViewById(R.id.lblItemDeskripsi);
            mLblMinumanImg = (ImageView)itemView.findViewById(R.id.lblItemImg);
        }

        //Method untuk melakukan inisialisasi nilai ke komponen view
        public void bindTo(MinumanItem minuman){
            mCurrentMinuman = minuman;
            mLblMinumanImg.setImageResource(minuman.getGambar());
            mLblMinumanJudul.setText(minuman.getNama());
            mLblMinumanInfo.setText(minuman.getInfo());
        }
    }
}
