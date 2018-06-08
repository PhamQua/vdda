package com.example.sang.vdda;

import android.os.CountDownTimer;

/**
 * Created by asus on 01/03/2018.
 */

public class Bom {


    public int getDoManh() {
        return doManh;
    }

    public void setDoManh(int doManh) {
        this.doManh = doManh;
    }




    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }




    public int getBienDem() {
        return bienDem;
    }

    public void setBienDem(int bienDem) {
        this.bienDem = bienDem;
    }
    private  int doManh=2;
    private  int thoigian=7;// thoi gian no
    private  int bienDem=0;// dem den thoi gian no
    private  int toadoX=-1;
    private  int toadoY=-1;
    public int getToadoX() {
        return toadoX;
    }

    public void setToadoX(int toadoX) {
        this.toadoX = toadoX;
    }

    public int getToadoY() {
        return toadoY;
    }

    public void setToadoY(int toadoY) {
        this.toadoY = toadoY;
    }



    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private  boolean flag=false;//ranh



    void XuLiBomNo(Bom vbom, CountDownTimer timer) {
        int tren = 0, duoi = 0, trai = 0, phai = 0;
        int t = (vbom.getToadoY() * MainActivity.hangso.getChieuDaiBan()) + vbom.getToadoX();
        if (vbom.getBienDem() == vbom.getThoigian() - 1) {
            MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.lua));
            for (int i = 1; i < vbom.getDoManh(); i++)



            {
                if (phai == 0 && (t + i) % MainActivity.hangso.getChieuDaiBan() != 0 && MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] != 2)//nut phai
                {
                    MainActivity.listHinhAnh.set(t + i, new HinhAnh(R.drawable.lua));
                    if (MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] != 0) {
                        phai = 1;
                    }
                    MainActivity.TruMang(vbom.getToadoX()  + i,vbom.getToadoY()  );
                    MainActivity.MatQuai(vbom.getToadoX()  + i,vbom.getToadoY()  );
                   /* if(i!=1)
                    NextBoom(vbom.getToadoX() + 1 + i,vbom.getToadoY() + 1 );*/

                    // mangKT[vbom.getToadoY()+1][vbom.getToadoX()+1+i]=0;
                } else {
                    phai = 1;
                }
                if (trai == 0 && (t - i + 1) % MainActivity.hangso.getChieuDaiBan() != 0 && MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] != 2)//nut trai
                {
                    MainActivity.listHinhAnh.set(t - i, new HinhAnh(R.drawable.lua));
                    if (MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] != 0) {
                        trai = 1;
                    }
                    MainActivity.TruMang(vbom.getToadoX()  - i,vbom.getToadoY()  );
                    MainActivity.MatQuai(vbom.getToadoX()  - i,vbom.getToadoY()  );
                    /*if(i!=1)
                    NextBoom(vbom.getToadoX() + 1 - i,vbom.getToadoY() + 1 );*/
                    /*mangKT[vbom.getToadoY()+1][vbom.getToadoX()+1-i]=0;*/
                } else {
                    trai = 1;
                }

                if (duoi == 0 && t + (i - 1) * (MainActivity.hangso.getChieuDaiBan()) < MainActivity.hangso.getChieuDaiBan() * (MainActivity.hangso.getChieuRongBan() - 1) && MainActivity.mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] != 2)// nut duoi
                {
                    MainActivity.listHinhAnh.set(t + (i) * MainActivity.hangso.getChieuDaiBan(), new HinhAnh(R.drawable.lua));
                    if (MainActivity.mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] != 0) {
                        duoi = 1;
                    }MainActivity.TruMang(vbom.getToadoX() ,vbom.getToadoY()+i  );
                    MainActivity.MatQuai(vbom.getToadoX() ,vbom.getToadoY()+i  );
                    /*if(i!=1)
                    NextBoom(vbom.getToadoX() + 1,vbom.getToadoY()+i + 1 );*/
                    /*mangKT[vbom.getToadoY()+i+1][vbom.getToadoX()+1]=0;*/
                } else {
                    duoi = 1;
                }
                if (tren == 0 && t - (i - 1) * (MainActivity.hangso.getChieuDaiBan()) > MainActivity.hangso.getChieuDaiBan() + 1 && MainActivity.mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] != 2)// nut tren
                {
                    MainActivity.listHinhAnh.set(t - (i) * MainActivity.hangso.getChieuDaiBan(), new HinhAnh(R.drawable.lua));
                    if (MainActivity.mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] != 0) {
                        tren = 1;
                    } MainActivity.TruMang(vbom.getToadoX() ,vbom.getToadoY()-i  );
                    MainActivity.MatQuai(vbom.getToadoX() ,vbom.getToadoY()-i  );
                   /* if(i!=1)
                    NextBoom(vbom.getToadoX() + 1,vbom.getToadoY()-i + 1 );*/
                   /* mangKT[vbom.getToadoY()-i+1][vbom.getToadoX()+1]=0;*/
                } else {
                    tren = 1;
                }
            }
            MainActivity.adapter.notifyDataSetChanged();

            MainActivity.TruMang(vbom.getToadoX(), vbom.getToadoY());
            MainActivity. MatQuai(vbom.getToadoX(), vbom.getToadoY());
        }






        if (vbom.getBienDem() == vbom.getThoigian()) {
            vbom.setFlag(false);

            tren = 0;
            duoi = 0;
            trai = 0;
            phai = 0;

            MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

            for (int i = 1; i < vbom.getDoManh(); i++)

            {

                if (phai == 0 && (t + i) % MainActivity.hangso.getChieuDaiBan() != 0 && MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] != 2)//nut phai
                {

                    if (MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] != 0) {
                        phai = 1;
                    }


                    // listHinhAnh.set(t + i, new HinhAnh(R.drawable.ovuong));
                    XLSauKhiNo(vbom.getToadoY() + 1, vbom.getToadoX() + 1 + i, t + i);
                } else {
                    phai = 1;
                }
                if (trai == 0 && (t - i + 1) % MainActivity.hangso.getChieuDaiBan() != 0 && MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] != 2)//nut trai
                {

                    if (MainActivity.mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] != 0) {
                        trai = 1;
                    }

                    //listHinhAnh.set(t - i, new HinhAnh(R.drawable.ovuong));
                    XLSauKhiNo(vbom.getToadoY() + 1, vbom.getToadoX() + 1 - i , t - i);
                } else {
                    trai = 1;
                }

                if (duoi == 0 && t + (i - 1) * (MainActivity.hangso.getChieuDaiBan()) < MainActivity.hangso.getChieuDaiBan() * (MainActivity.hangso.getChieuRongBan() - 1) && MainActivity.mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] != 2)// nut duoi
                {

                    if (MainActivity.mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] != 0) {
                        duoi = 1;
                    }

                    //listHinhAnh.set(t + (i) * hangso.getChieuDaiBan(), new HinhAnh(R.drawable.ovuong));
                    XLSauKhiNo(vbom.getToadoY() + i + 1, vbom.getToadoX() + 1, t + (i) * MainActivity.hangso.getChieuDaiBan() );
                } else {
                    duoi = 1;
                }
                if (tren == 0 && t - (i - 1) * (MainActivity.hangso.getChieuDaiBan()) > MainActivity.hangso.getChieuDaiBan() + 1 && MainActivity.mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] != 2)// nut tren
                {
                    // listHinhAnh.set(t - (i) * hangso.getChieuDaiBan(), new HinhAnh(R.drawable.ovuong));

                    if (MainActivity.mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] != 0) {
                        tren = 1;
                    }

                    XLSauKhiNo(vbom.getToadoY() - i + 1,vbom.getToadoX() + 1, t - (i) * MainActivity.hangso.getChieuDaiBan());


                } else {
                    tren = 1;
                }
            }


            MainActivity.adapter.notifyDataSetChanged();
            vbom.setBienDem(0);
            ///////
            timer.cancel();

        } else
            vbom.setBienDem(vbom.getBienDem() + 1);


    }



    void XLSauKhiNo(int y, int x, int t)
    {
        MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));
        switch (MainActivity.mangKT[y][x]) {
            case 1:
                MainActivity.mangKT[y][x] = 0;
                MainActivity.diem=MainActivity.diem+1;
                MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));
                break;

            //domanh
            case 3:
                MainActivity.listHinhAnh.set(t, new HinhAnh(MainActivity.tangdomanh.getHinhNV()));
                MainActivity.mangKT[y][x] = 4;
                break;
            case 4:
                MainActivity.mangKT[y][x] = 0;
                MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;

            //slbom
            case 5:
                MainActivity.listHinhAnh.set(t, new HinhAnh(MainActivity.tangbom.getHinhNV()));
                MainActivity.mangKT[y][x] = 6;
                break;
            case 6:
                MainActivity.mangKT[y][x] = 0;
                MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;
            //mang
            case 7:
                MainActivity.listHinhAnh.set(t, new HinhAnh(MainActivity.tangmang.getHinhNV()));
                MainActivity.mangKT[y][x] = 8;
                break;
            case 8:
                MainActivity.mangKT[y][x] = 0;
                MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;
            //tocdo
            case 9:
                MainActivity.listHinhAnh.set(t, new HinhAnh(MainActivity.tangtocdo.getHinhNV()));
                MainActivity.mangKT[y][x] = 10;
                break;
            case 10:
                MainActivity.mangKT[y][x] = 0;
                MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;
            case 13://key
                MainActivity.mangKT[y][x] = 14;
                MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.key));

                break;
            case 14:
                //mangKT[y][x] = 0;
                MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.key));

                break;

            case 15://lo
                if(MainActivity.quaMan){
                    MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.quaman));
                }
                else
                //mangKT[y][x] = 16;
                MainActivity.listHinhAnh.set(t, new HinhAnh(R.drawable.congra));

                break;
            default:

                break;


        }
    }

}
