package com.example.sang.vdda;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by asus on 28/02/2018.
 */

public class HangSo {
    private int thoiGianVan=160;

    public int getTgianvanmacdinh() {
        return tgianvanmacdinh;
    }

    private int tgianvanmacdinh=thoiGianVan;
    private int chieuDaiBan=15;
    private int chieuRongBan=9;
    public static int Chieudaio=30;
    private int buocDichuyen=1;
    private float tiSopxdp;
    private int soGach=30;

    private int mangNV=10;
    private int sobomNV=3;

    private int sotangdomanh=5;
    private int soTangTocDo=4;
    private int soTangSLBom=5;
    private int soTangMang=4;


    private int soLuongQuai=3;


    public static int getChieudaio() {
        return Chieudaio;
    }


    public int getThoiGianVan() {
        return thoiGianVan;
    }

    public void setThoiGianVan(int thoiGianVan) {
        this.thoiGianVan = thoiGianVan;
    }



    public int getChieuDaiBan() {
        return chieuDaiBan;
    }



    public int getChieuRongBan() {
        return chieuRongBan;
    }





    public int getBuocDichuyen() {
        return buocDichuyen;
    }

    public void setBuocDichuyen(int buocDichuyen) {
        this.buocDichuyen = buocDichuyen;
    }


    public float getTiSopxdp() {
        return tiSopxdp;
    }

    public void setTiSopxdp( Context context) {
        this.tiSopxdp = convertPixelsToDp(context);
    }


    public int getMangNV() {
        return mangNV;
    }

    public void setMangNV(int mangNV) {
        this.mangNV = mangNV;
    }

    public int getSobomNV() {
        return sobomNV;
    }

    public void setSobomNV(int sobomNV) {
        this.sobomNV = sobomNV;
    }



    public int getSotangdomanh() {
        return sotangdomanh;
    }

    public void setSotangdomanh(int sotangdomanh) {
        this.sotangdomanh = sotangdomanh;
    }





    public int getSoTangTocDo() {
        return soTangTocDo;
    }

    public void setSoTangTocDo(int soTangTocDo) {
        this.soTangTocDo = soTangTocDo;
    }

    public int getSoTangSLBom() {
        return soTangSLBom;
    }

    public void setSoTangSLBom(int soTangSLBom) {
        this.soTangSLBom = soTangSLBom;
    }

    public int getSoTangMang() {
        return soTangMang;
    }

    public void setSoTangMang(int soTangMang) {
        this.soTangMang = soTangMang;
    }




    public int getSoGach() {
        return soGach;
    }

    public void setSoGach(int soGach) {
        this.soGach = soGach;
    }



    public int getSoLuongQuai() {
        return soLuongQuai;
    }


    public static float convertPixelsToDp(Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = 1 / (metrics.densityDpi / 160f);
        return dp;

    }


}
