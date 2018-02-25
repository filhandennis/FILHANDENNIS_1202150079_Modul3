package com.lesson.filhan.filhandennis_1202150079_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * MinumanItem merupakan class yang digunakan sebagai Model Data
 * dari Objek Minuman
 * Bagaimana bentuk minumanannya, terdapat apa saja pada data minuman tersebut
 * Setter dan Getter dari Nama, Info(Penggalan Teks yang tampil di item recycler view),
 * Deskripsi, Gambar
 */

public class MinumanItem {
    private String nama, info, deskripsi;
    private int gambar;

    public MinumanItem(String nama, String info, String deskripsi, int gambar) {
        this.nama = nama;
        this.info = info;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public static Intent toClick(Context context, String title, String desc, @DrawableRes int img){
        Intent in = new Intent(context, DetailMenu.class);
        in.putExtra("EXTRA_TITLE",title);
        in.putExtra("EXTRA_DESC",desc);
        in.putExtra("EXTRA_IMG",img);
        return in;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
