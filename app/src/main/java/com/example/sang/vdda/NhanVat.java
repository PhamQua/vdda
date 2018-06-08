package com.example.sang.vdda;

import android.widget.ImageView;

/**
 * Created by asus on 01/03/2018.
 */

public class NhanVat {


    public static int buocDiChuyenQuai=1;
    private boolean quaiTren=false;
    private boolean quaiPhai=false;
    private boolean quaiTrenDuoi=false;

    public  void QuaiDiChuyen(ImageView img){

        if(quaiTrenDuoi==true)
        {
            QuaiDiChuyenTrenDuoi(img);
        }

        else
            QuaiDiChuyenTraiPhai(img);


        if(MainActivity.flagQuai==true){
            int  y = (int) ((img.getY() * MainActivity.hangso.getTiSopxdp() + MainActivity.hangso.Chieudaio / 2 - MainActivity.grvBan.getY() * MainActivity.hangso.getTiSopxdp()) / MainActivity.hangso.Chieudaio);
            int x = (int) ((img.getX() * MainActivity.hangso.getTiSopxdp() + MainActivity.hangso.Chieudaio / 2 - MainActivity.grvBan.getX() * MainActivity.hangso.getTiSopxdp()) / MainActivity.hangso.Chieudaio);
            MainActivity.TruMang(x,y);
        }

    }
    void QuaiDiChuyenTrenDuoi(ImageView img){
        if(quaiTren==true){
            if(DkQuaiTren(img))
                img.setY(img.getY()-NhanVat.buocDiChuyenQuai);

            else
            {

                quaiTren=false;
                quaiTrenDuoi=false;

            }
        }

        if(quaiTren==false&&quaiTrenDuoi==true){
            if(DkQuaiDuoi(img))
                img.setY(img.getY()+NhanVat.buocDiChuyenQuai);

            else
            {
                quaiTren=true;
                quaiTrenDuoi=false;
            }
        }
    }

    void QuaiDiChuyenTraiPhai(ImageView img){


        if(quaiPhai==true){
            if(DkQuaiPhai(img))
                img.setX(img.getX()+NhanVat.buocDiChuyenQuai);

            else
            {
                quaiPhai=false;
                quaiTrenDuoi=true;

            }
        }

        if(quaiPhai==false&&quaiTrenDuoi==false){
            if(DkQuaiTrai(img))
                img.setX(img.getX()-NhanVat.buocDiChuyenQuai);

            else
            {
                quaiPhai=true;
                quaiTrenDuoi=true;
            }
        }
    }

    boolean  DkQuaiTren(ImageView img){
        try {
            int x, y;
            y=(int)((img.getY()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getY()*MainActivity.hangso.getTiSopxdp()-NhanVat.buocDiChuyenQuai)/MainActivity.hangso.Chieudaio);
            x=(int)((img.getX()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getX()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio/2)/MainActivity.hangso.Chieudaio);

           /* y--;
            x--;*/
            if(MainActivity.mangKT[y][x]!=0){
                return false;
            }
            return true;

        }
        catch (ArithmeticException e)

        {
            return false;
        }

    }


    boolean  DkQuaiDuoi(ImageView img){
        try {
            int x, y;
            y=(int)((img.getY()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getY()*MainActivity.hangso.getTiSopxdp()+NhanVat.buocDiChuyenQuai)/MainActivity.hangso.Chieudaio);
            x=(int)((img.getX()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getX()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio/2)/MainActivity.hangso.Chieudaio);

            y++;

            if(MainActivity.mangKT[y][x]!=0){
                return false;
            }
            return true;

        }
        catch (ArithmeticException e)

        {

            return false;
        }

    }
    boolean  DkQuaiPhai(ImageView img){
        try {
            int x, y;
            y=(int)((img.getY()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getY()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio/2)/MainActivity.hangso.Chieudaio);
            x=(int)((img.getX()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getX()*MainActivity.hangso.getTiSopxdp()+NhanVat.buocDiChuyenQuai)/MainActivity.hangso.Chieudaio);
            x++;





            if(MainActivity.mangKT[y][x]!=0){

                return false;
            }
            return true;

        }
        catch (ArithmeticException e)

        {

            return false;
        }

    }
    boolean  DkQuaiTrai(ImageView img){
        try {
            int x, y;
            y=(int)((img.getY()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getY()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio/2)/MainActivity.hangso.Chieudaio);
            x=(int)((img.getX()*MainActivity.hangso.getTiSopxdp()+MainActivity.hangso.Chieudaio-MainActivity.grvBan.getX()*MainActivity.hangso.getTiSopxdp()-NhanVat.buocDiChuyenQuai)/MainActivity.hangso.Chieudaio);


            if(MainActivity.mangKT[y][x]!=0){
                return false;
            }
            return true;

        }
        catch (ArithmeticException e)

        {
            return false;

        }

    }

}
