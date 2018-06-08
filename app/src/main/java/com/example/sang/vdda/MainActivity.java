package com.example.sang.vdda;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView txtthoiGian;
    public static TextView txtDiem;
    TextView txtdoManh;
    public static TextView txtmang;
    TextView txttocDo;
    TextView txtbom;
    public static TextView txtgameover;

    boolean flagpause=false;
    Bom bom1 = new Bom();
    Bom bom2 = new Bom();
    Bom bom3 = new Bom();
    Bom bom4 = new Bom();
    Bom bom5 = new Bom();
    // List<Bom> bombs=new ArrayList<Bom>();
    CountDownTimer bomno;
    CountDownTimer bomno2;
    CountDownTimer bomno3;
    CountDownTimer bomno4;
    CountDownTimer bomno5;
    public static CountDownTimer quaiDiChuyen;
    public static CountDownTimer quaiDiChuyen2;
    public static CountDownTimer quaiDiChuyen3;
    CountDownTimer CDthoiGian;
    public static CountDownTimer quaiNV;
    public static boolean flagQuai=true;
    public static GridView grvBan;
    public static   ImageView imageNv;
    public static ImageView imageQuai;
    public static ImageView imageQuai2;
    public static ImageView imageQuai3;
    ImageView imgoVuong;
    public static ImageButton btnBom;
    public static ImageButton btnTren;
    public static ImageButton btnDuoi;
    public static ImageButton btnTrai;
    public static ImageButton btnPhai;
    ImageButton btnPause;
    ImageButton btnexit;
    ImageButton btnReload;

    public static int diem=0;
    int xQuaMan;
    int yQuaMan;
    int danhDauQuai=0;

    public static boolean quaMan=false;
    int nutPhai=3;
    int nutTren=3;

    int tocDo=1;

    public static ArrayList<HinhAnh> listHinhAnh;
    public static int mangKT[][] = new int[30][30];
    public static HinhanhAdapter adapter;
    public static HangSo hangso = new HangSo();
    NhanVat quai1=new NhanVat();
    NhanVat quai2=new NhanVat();
    NhanVat quai3=new NhanVat();
    public static CungCap tangdomanh = new CungCap(R.drawable.tangdomanh);
    public static CungCap tangmang = new CungCap(R.drawable.themmang);
    public static CungCap tangbom = new CungCap(R.drawable.tangbom);
    public static CungCap tangtocdo = new CungCap(R.drawable.tangtocdo);
    Random rd=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        hangso.setTiSopxdp(this);




        AnhXa();
        VeManHinh();




        btnTren.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (DkNutTren()) {

                    nutPhai=3;
                    imageNv.setY(imageNv.getY() - hangso.getBuocDichuyen());
                }  else{
                    int y=(int)((imageNv.getY()-grvBan.getY() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) / hangso.Chieudaio;
                    int x = (int) ((imageNv.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

                    x++;
                    if(mangKT[y][x]!=1&&mangKT[y][x]!=2) {

                        if(nutTren==1){

                            if (DkNutPhai()) {
                                imageNv.setX(imageNv.getX() + hangso.getBuocDichuyen());
                            }
                        }else
                        if(nutTren==0){

                            if (DkNutTrai()) {
                                imageNv.setX(imageNv.getX() - hangso.getBuocDichuyen());
                            }
                        }else
                        {
                            if ( ((imageNv.getX()-grvBan.getX() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) % hangso.Chieudaio <= hangso.Chieudaio / 2) {

                                nutTren=1;

                            }
                            else
                                nutTren=0;

                        }



                    }
                }

                return false;
            }
        });

        btnDuoi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (DkNutDuoi()) {
                    nutPhai=3;
                    imageNv.setY(imageNv.getY() + hangso.getBuocDichuyen());
                }
                else{
                    int y=(int)((imageNv.getY()-grvBan.getY() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) / hangso.Chieudaio;
                    int x = (int) ((imageNv.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

                    x++;
                    y++;
                    if(mangKT[y+1][x]!=1&&mangKT[y+1][x]!=2) {

                        if(nutTren==1){

                            if (DkNutPhai()) {
                                imageNv.setX(imageNv.getX() + hangso.getBuocDichuyen());
                            }
                        }else
                        if(nutTren==0){

                            if (DkNutTrai()) {
                                imageNv.setX(imageNv.getX() - hangso.getBuocDichuyen());
                            }
                        }else
                        {
                            if ( ((imageNv.getX()-grvBan.getX() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) % hangso.Chieudaio <= hangso.Chieudaio / 2) {

                                nutTren=1;

                            }
                            else
                                nutTren=0;

                        }



                    }
                }




                return false;
            }
        });
        btnTrai.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (DkNutTrai()) {
                    nutTren=3;
                    imageNv.setX(imageNv.getX() - hangso.getBuocDichuyen());

                } else{
                    int y=(int)((imageNv.getY()-grvBan.getY() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) / hangso.Chieudaio;
                    int x = (int) ((imageNv.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

                    y++;

                    if(mangKT[y][x]!=1&&mangKT[y][x]!=2) {

                        if(nutPhai==1){

                            if (DkNutDuoi()) {
                                imageNv.setY(imageNv.getY() + hangso.getBuocDichuyen());
                            }
                        }else
                        if(nutPhai==0){

                            if (DkNutTren()) {
                                imageNv.setY(imageNv.getY() - hangso.getBuocDichuyen());
                            }
                        }else
                        {
                            if ( ((imageNv.getY()-grvBan.getY() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) % hangso.Chieudaio <= hangso.Chieudaio / 2) {

                                nutPhai=1;

                            }
                            else
                                nutPhai=0;

                        }



                    }
                }
                return false;
            }
        });
        btnPhai.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {



                if (DkNutPhai()) {
                    nutTren=3;
                    imageNv.setX(imageNv.getX() + hangso.getBuocDichuyen());

                } else{
                int y=(int)((imageNv.getY()-grvBan.getY() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) / hangso.Chieudaio;
                int x = (int) ((imageNv.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

                    x+=2;
                    y++;
                if(mangKT[y][x]!=1&&mangKT[y][x]!=2) {

                    if(nutPhai==1){

                        if (DkNutDuoi()) {
                            imageNv.setY(imageNv.getY() + hangso.getBuocDichuyen());
                        }
                    }else
                    if(nutPhai==0){

                        if (DkNutTren()) {
                            imageNv.setY(imageNv.getY() - hangso.getBuocDichuyen());
                        }
                    }else
                    {
                        if ( ((imageNv.getY()-grvBan.getY() )* hangso.getTiSopxdp() + hangso.Chieudaio / 2) % hangso.Chieudaio <= hangso.Chieudaio / 2) {

                            nutPhai=1;

                        }
                        else
                            nutPhai=0;

                    }



                }



//                    if ( (imageNv.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2) % hangso.Chieudaio <= hangso.Chieudaio / 2) {
//
//                        imageNv.setY(imageNv.getY() - hangso.getBuocDichuyen());
//
//                    } else
//                    {

                }

                return false;
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });


        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstCreen.class));
            }
        });
        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hangso.setThoiGianVan(hangso.getTgianvanmacdinh());
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        bomno = new CountDownTimer(500*(bom1.getThoigian()+2), 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                bom1.XuLiBomNo(bom1, this);

            }

            @Override
            public void onFinish() {
            }
        };
        bomno2 = new CountDownTimer(500*(bom1.getThoigian()+5), 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                bom2.XuLiBomNo(bom2, this);
            }

            @Override
            public void onFinish() {
            }
        };
        bomno3 = new CountDownTimer(90000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                bom3.XuLiBomNo(bom3, this);
            }

            @Override
            public void onFinish() {
            }
        };
        bomno4 = new CountDownTimer(500*(bom1.getThoigian()+5), 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                bom4.XuLiBomNo(bom4, this);
            }

            @Override
            public void onFinish() {
            }
        };
        bomno5 = new CountDownTimer(500*(bom1.getThoigian()+5), 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                bom5.XuLiBomNo(bom5, this);
            }

            @Override
            public void onFinish() {
            }
        };
        quaiDiChuyen = new CountDownTimer(900000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                quai1.QuaiDiChuyen(imageQuai);

            }

            @Override
            public void onFinish() {
            }

        };
        quaiDiChuyen2 = new CountDownTimer(900000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                quai2.QuaiDiChuyen(imageQuai2);

            }

            @Override
            public void onFinish() {
            }

        };
      quaiDiChuyen3 = new CountDownTimer(900000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                quai3.QuaiDiChuyen(imageQuai3);

            }

            @Override
            public void onFinish() {
            }

        };
        CDthoiGian= new CountDownTimer(900000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(hangso.getThoiGianVan()>0){
                    hangso.setThoiGianVan(hangso.getThoiGianVan()-1);
                    txtthoiGian.setText(String.valueOf(hangso.getThoiGianVan()));
                }
                else
                {
                    //KetThucGame();
                }


            }

            @Override
            public void onFinish() {
            }};
        quaiNV =new CountDownTimer(3000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
               flagQuai=false;


            }

            @Override
            public void onFinish() {
                flagQuai=true;
            }};
        btnBom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x, y;
                int sobom=hangso.getSobomNV();
                y = (int) ((imageNv.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getY() * hangso.getTiSopxdp()) / hangso.Chieudaio);
                x = (int) ((imageNv.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

                if (bom1.isFlag() == false) {

                    ChonBom(x, y, bom1, bomno);
                    return;
                }
                if (bom2.isFlag() == false&&sobom>1) {
                    ChonBom(x, y, bom2, bomno2);
                    return;
                }
                if (bom3.isFlag() == false&&sobom>2) {
                    ChonBom(x, y, bom3, bomno3);
                    return;
                }
                if (bom4.isFlag() == false&&sobom>3) {
                    ChonBom(x, y, bom4, bomno4);
                    return;
                }
                if (bom5.isFlag() == false&&sobom>4) {
                    ChonBom(x, y, bom5, bomno5);
                    return;
                }

            }
        });
        quaiDiChuyen.start();
       quaiDiChuyen2.start();
         quaiDiChuyen3.start();
        CDthoiGian.start();

    }

    public static void MatQuai(int vx, int vy){


        int qy = (int) ((imageQuai.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getY() * hangso.getTiSopxdp()) / hangso.Chieudaio);
        int qx = (int) ((imageQuai.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

       int qy2 = (int) ((imageQuai2.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getY() * hangso.getTiSopxdp()) / hangso.Chieudaio);
        int qx2 = (int) ((imageQuai2.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

         int qy3 = (int) ((imageQuai3.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getY() * hangso.getTiSopxdp()) / hangso.Chieudaio);
        int qx3 = (int) ((imageQuai3.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);
        if(qx==vx&& qy==vy){

            flagQuai=false;
            MainActivity.diem=MainActivity.diem+5;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));

            imageQuai.setVisibility(View.INVISIBLE);
            quaiDiChuyen.cancel();
        }
        if(qx2==vx&& qy2==vy){

            flagQuai=false;
            MainActivity.diem=MainActivity.diem+5;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));

            imageQuai2.setVisibility(View.INVISIBLE);
            quaiDiChuyen2.cancel();
        }
        if(qx3==vx&& qy3==vy){

            flagQuai=false;
            MainActivity.diem=MainActivity.diem+5;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));


            imageQuai3.setVisibility(View.INVISIBLE);
            quaiDiChuyen3.cancel();
        }

    }
    public static  void TruMang(int vx, int vy){


        int y = (int) ((imageNv.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getY() * hangso.getTiSopxdp()) / hangso.Chieudaio);
        int x = (int) ((imageNv.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);


        if(x==vx&& y==vy){
            quaiNV.start();
            hangso.setMangNV(hangso.getMangNV()-1);
            MainActivity.diem=MainActivity.diem-5;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));

            txtmang.setText(String.valueOf(hangso.getMangNV()));
            if(hangso.getMangNV()<=0)
            {
                KetThucGame();
            }
        }


    }
    void NextBoom(int vx, int vy){


        vx--;
        vy--;
        if(bom1.getToadoX()==vx&& bom1.getToadoY()==vy){
            bom1.setBienDem(bom1.getThoigian()-1);
        }
        if(bom2.getToadoX()==vx&& bom2.getToadoY()==vy){
            bom2.setBienDem(bom2.getThoigian()-1);
        }
        if(bom3.getToadoX()==vx&& bom3.getToadoY()==vy){
            bom3.setBienDem(bom3.getThoigian()-1);
        }
        if(bom4.getToadoX()==vx&& bom4.getToadoY()==vy){
            bom4.setBienDem(bom4.getThoigian()-1);
        }
        if(bom5.getToadoX()==vx&& bom5.getToadoY()==vy){
            bom5.setBienDem(bom5.getThoigian()-1);
        }


    }
    boolean DKNo(int x, int y){
        if(mangKT[y][x] == 1||mangKT[y][x] == 3||mangKT[y][x] == 4||mangKT[y][x] == 5||mangKT[y][x] == 6||mangKT[y][x] == 7||
                mangKT[y][x] == 8||mangKT[y][x] == 9||mangKT[y][x] == 10||mangKT[y][x] == 13){
            return true;
        }
        return false;
    }

    void ChonBom(int vx, int vy, Bom vbom, CountDownTimer timer){

        vbom.setToadoX(vx);
        vbom.setToadoY(vy);
        vbom.setBienDem(0);

        listHinhAnh.set((vy*hangso.getChieuDaiBan())+vx, new HinhAnh(R.drawable.bomnho));
        adapter.notifyDataSetChanged();

        timer.start();
        vbom.setFlag(true);
    }

    boolean DkNutTren()
    {
        try {
        int x, y;
        y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
        x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

        /*y--;
            x--;*/



            if(DKfalse(x, y)){
                return false;
            }

            int i=(int)((imageNv.getX()*hangso.getTiSopxdp()-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);
                if(imageNv.getX()*hangso.getTiSopxdp()>=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                        imageNv.getX()*hangso.getTiSopxdp()<=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i)
                {


                        DKnut(x, y);


                    return true;
                }
        }
        catch (ArithmeticException e)

        {
            return false;
        }


        return false;

    }
    boolean DkNutDuoi()
    {
        try {
        int x, y;
            y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

        y++;
            /*y++;
            x++;*/
          /*  if (mangKT[y+1][x+1] ==4) {
               *//* bom1.setDoManh(bom1.getDoManh()+1);
                bom2.setDoManh(bom1.getDoManh());

                mangKT[y+1][x+1] =0;
                listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
                grvBan.setAdapter(adapter);*//*
                DKnut(x, y);
                return true;
            }*/

            if(DKfalse(x, y)){
            return false;
        }
            //for(int i=0; i<hangso.getChieuDaiBan(); i++)
            int i=(int)((imageNv.getX()*hangso.getTiSopxdp()-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);
                if(imageNv.getX()*hangso.getTiSopxdp()>=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                        imageNv.getX()*hangso.getTiSopxdp()<=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i)
                {

                        DKnut(x, y);


                    return true;
                }
        }
        catch (ArithmeticException e)

        {
            return false;
        }


        return false;

    }

    boolean DkNutPhai()
    {
        try {
        int x, y;
            y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

        x++;
        /*x++;
            y++;*/
            if(DKfalse(x, y)){
            return false;
        }
            int  i=(int)((imageNv.getY()*hangso.getTiSopxdp()-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            if(imageNv.getY()*hangso.getTiSopxdp()>=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                    imageNv.getY()*hangso.getTiSopxdp()<=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i)// cho vndi vao chinh giua hang
            {

                    DKnut(x, y);


                return true;
            }
    }
        catch (ArithmeticException e)

    {
        return false;
    }


        return false;

    }

    boolean DkNutTrai()
    {
        try {
            int x, y;
            y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

       /* x--;
            y--;*/

            if(DKfalse(x, y)){
                return false;
            }
            int  i=(int)((imageNv.getY()*hangso.getTiSopxdp()-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            if(imageNv.getY()*hangso.getTiSopxdp()>=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                    imageNv.getY()*hangso.getTiSopxdp()<=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i)// cho vndi vao chinh giua hang
            {

                DKnut(x, y);


                return true;
            }
        }
        catch (ArithmeticException e)

        {
            return false;
        }


        return false;

    }
    boolean DKfalse(int x, int y){
        if(mangKT[y][x]!=0&&mangKT[y][x]!=4&&mangKT[y][x]!=6&&mangKT[y][x]!=8&&mangKT[y][x]!=10&&mangKT[y][x]!=14&&mangKT[y][x]!=15){
            return true;//tra ve la dung de ham tren tr ve sai
        }
        return false;
    }
    void DKnut(int x , int y){
        if (mangKT[y][x] ==4) {
            bom1.setDoManh(bom1.getDoManh()+1);
            bom2.setDoManh(bom2.getDoManh()+1);
            bom3.setDoManh(bom3.getDoManh()+1);
            bom4.setDoManh(bom4.getDoManh()+1);
            bom5.setDoManh(bom5.getDoManh()+1);
            txtdoManh.setText(String.valueOf(bom1.getDoManh()));

            MainActivity.diem=MainActivity.diem+3;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));
            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==6) {//soluongbom

            MainActivity.diem=MainActivity.diem+3;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));
            hangso.setSobomNV(hangso.getSobomNV()+1);


            txtbom.setText(String.valueOf(hangso.getSobomNV()));
            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==8) {//tangmang
            MainActivity.diem=MainActivity.diem+3;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));
            hangso.setMangNV(hangso.getMangNV()+1);

            txtmang.setText(String.valueOf(hangso.getMangNV()));
            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==10) {//tangtocdo
            MainActivity.diem=MainActivity.diem+3;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));
            //hangso.setBuocDichuyen(hangso.getBuocDichuyen()+0);
            txttocDo.setText(String.valueOf(tocDo+1));
            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            if(tocDo%3==0){
                hangso.setBuocDichuyen(hangso.getBuocDichuyen()+1);
            }
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==14) {//key
            mangKT[y][x] =0;
           quaMan=true;
            MainActivity.diem=MainActivity.diem+5;
            MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));


            listHinhAnh.set(hangso.getChieuDaiBan()*(yQuaMan-1)+xQuaMan-1, new HinhAnh(R.drawable.quaman));


            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==15) {//quaman
            if(quaMan==true){
                MainActivity.diem=MainActivity.diem+hangso.getThoiGianVan()/2;
                MainActivity.txtDiem.setText(String.valueOf(MainActivity.diem));

                btnBom.setEnabled(false);
                btnDuoi.setEnabled(false);
                btnPhai.setEnabled(false);
                btnTrai.setEnabled(false);
                btnTren.setEnabled(false);
                txtgameover.setText("YOU WIN!!!");
            }

            return;
        }



    }


    void AnhXa()
    {
        listHinhAnh =new ArrayList<>();

        imageQuai=(ImageView) findViewById(R.id.quai);
        imageQuai2=(ImageView) findViewById(R.id.quai2);
        imageQuai3=(ImageView) findViewById(R.id.quai3);
        grvBan=(GridView) findViewById(R.id.banco);
        imgoVuong=(ImageView) findViewById(R.id.ovuong);
        imageNv=(ImageView) findViewById(R.id.nhanvat);
        btnTren=(ImageButton) findViewById(R.id.nuttren);
        btnDuoi=(ImageButton) findViewById(R.id.nutduoi);
        btnTrai=(ImageButton) findViewById(R.id.nuttrai);
        btnPhai=(ImageButton) findViewById(R.id.nutphai);
        btnPause=(ImageButton) findViewById(R.id.pause);
        btnexit=(ImageButton) findViewById(R.id.back);
        btnReload=(ImageButton) findViewById(R.id.reload);
        txtgameover=(TextView)findViewById(R.id.gameover) ;
        txtthoiGian=(TextView)findViewById(R.id.thoigian) ;
        txtDiem=(TextView)findViewById(R.id.diem) ;
        txtdoManh=(TextView)findViewById(R.id.domanh) ;
        txtmang=(TextView)findViewById(R.id.mang) ;
        txttocDo=(TextView)findViewById(R.id.tocdo) ;
        txtbom=(TextView)findViewById(R.id.bom) ;

        btnBom=(ImageButton) findViewById(R.id.nutbom);
    }

    public void VeManHinh()
    {

        btnTren.setBackgroundColor(Color.TRANSPARENT);
        btnDuoi.setBackgroundColor(Color.TRANSPARENT);
        btnTrai.setBackgroundColor(Color.TRANSPARENT);
        btnPhai.setBackgroundColor(Color.TRANSPARENT);
        btnBom.setBackgroundColor(Color.TRANSPARENT);
        //imgoVuong.set
        grvBan.setNumColumns(hangso.getChieuDaiBan());
   //  int dem=0;
        //khoi tao mang 2 chieu
        for(int r=0; r<hangso.getChieuRongBan(); r++)
            for(int d=0; d<hangso.getChieuDaiBan();d++)
            {
                //mangChiSo[r][d]=dem;
                mangKT[r+1][d+1]=0;
                mangKT[0][d+1]=2;
                mangKT[hangso.getChieuRongBan()+1][d+1]=2;
                mangKT[r+1][0]=2;
                mangKT[r+1][hangso.getChieuDaiBan()+1]=2;
                if(r%2!=0&&d%2!=0)
                {
                    mangKT[r+1][d+1]=2;
                }

              //  dem++;

            }
        mangKT[1][1]=1;
        mangKT[1][2]=1;
        mangKT[2][1]=1;
            //gan hinh

        RanDom(hangso.getSoGach(), 1);//gach
        RanDomTrongGach(hangso.getSotangdomanh(),3);//tangdomanh
        RanDomTrongGach(hangso.getSoTangSLBom(),5);//
        RanDomTrongGach(hangso.getSoTangMang(),7);//
        RanDomTrongGach(hangso.getSoTangTocDo(),9);//
        RanDomNgoaiGach(hangso.getSoLuongQuai(),11);//vitribatdau quai


        RanDomTrongGach(1, 13);//qua man
        RanDomTrongGach(1, 15);

        mangKT[1][1]=0;
        mangKT[1][2]=0;
        mangKT[2][1]=0;


        for(int r=0; r<hangso.getChieuRongBan(); r++)
            for(int d=0; d<hangso.getChieuDaiBan();d++)
            {
                if(mangKT[r+1][d+1]==15)
                {
                    xQuaMan=r+1;
                    yQuaMan=d+1;
                }

                if(mangKT[r+1][d+1]==2)
                {
                    listHinhAnh.add(new HinhAnh(R.drawable.xam));
                }
                else
                    if(mangKT[r+1][d+1]!=0&&mangKT[r+1][d+1]!=2&&mangKT[r+1][d+1]!=11)
                    {
                        listHinhAnh.add(new HinhAnh(R.drawable.gach));

                    }
                    else
                    listHinhAnh.add(new HinhAnh(R.drawable.ovuong));

                if(mangKT[r+1][d+1]==11){//quai
                    switch (danhDauQuai){
                        case 0:
                            imageQuai.setX(grvBan.getX() +(d)*hangso.getChieudaio()/hangso.getTiSopxdp());
                            imageQuai.setY(grvBan.getY() +(r)*hangso.getChieudaio()/hangso.getTiSopxdp());

                            mangKT[r+1][d+1]=0;
                            danhDauQuai++;
                            break;
                        case 1:
                            imageQuai2.setX(grvBan.getX() +(d)*hangso.getChieudaio()/hangso.getTiSopxdp());
                            imageQuai2.setY(grvBan.getY() +(r)*hangso.getChieudaio()/hangso.getTiSopxdp());

                            mangKT[r+1][d+1]=0;
                            danhDauQuai++;
                            break;
                        case 2:
                            imageQuai3.setX(grvBan.getX() +(d)*hangso.getChieudaio()/hangso.getTiSopxdp());
                            imageQuai3.setY(grvBan.getY() +(r)*hangso.getChieudaio()/hangso.getTiSopxdp());

                            mangKT[r+1][d+1]=0;
                            danhDauQuai++;
                            break;
                    }


                }
            }


        adapter=new HinhanhAdapter(this, R.layout.hinh_anh,listHinhAnh );
        grvBan.setAdapter(adapter);
        txttocDo.setText("1");
        txtmang.setText(String.valueOf(hangso.getMangNV()));
        txtbom.setText(String.valueOf(hangso.getSobomNV()));
        txtdoManh.setText(String.valueOf(bom1.getDoManh()));
    }
    void RanDom(int somax, int Sodanhdau)
    {
        int dem=0;
        Random rd1 = new Random();
        Random rd2 = new Random();
        while(dem<somax)
        {
            int x = rd1.nextInt(hangso.getChieuDaiBan());
            int y = rd2.nextInt(hangso.getChieuRongBan());
            while(x %2!= 0&&y %2!= 0)
            {
                x = rd1.nextInt(hangso.getChieuDaiBan());
                y = rd2.nextInt(hangso.getChieuRongBan());
            }

            if (mangKT[y+1][x+1] == 0)
            {
                mangKT[y+1][x+1] = Sodanhdau;
                dem++;

            }
        }
    }
    void RanDomTrongGach(int somax, int Sodanhdau)
    {
        int dem=0;
        Random rd1 = new Random();
        Random rd2 = new Random();
        while(dem<somax)
        {
            int x = rd1.nextInt(hangso.getChieuDaiBan());
            int y = rd2.nextInt(hangso.getChieuRongBan());
            while(x %2!= 0&&y %2!= 0)
            {
                x = rd1.nextInt(hangso.getChieuDaiBan());
                y = rd2.nextInt(hangso.getChieuRongBan());
            }

            if (mangKT[y+1][x+1] == 1)
            {
                mangKT[y+1][x+1] = Sodanhdau;
                dem++;

            }
        }
    }

    void RanDomNgoaiGach(int somax, int Sodanhdau)
    {
        int dem=0;
        Random rd1 = new Random();
        Random rd2 = new Random();
        while(dem<somax)
        {
            int x = rd1.nextInt(hangso.getChieuDaiBan());
            int y = rd2.nextInt(hangso.getChieuRongBan());
            while(x %2!= 0&&y %2!= 0)
            {
                x = rd1.nextInt(hangso.getChieuDaiBan());
                y = rd2.nextInt(hangso.getChieuRongBan());
            }

            if (mangKT[y+1][x+1] == 0)
            {
                mangKT[y+1][x+1] = Sodanhdau;
                dem++;

            }
        }
    }


    public static  void KetThucGame(){

        btnBom.setEnabled(false);
        btnDuoi.setEnabled(false);
        btnPhai.setEnabled(false);
        btnTrai.setEnabled(false);
        btnTren.setEnabled(false);
        FirstCreen.editor=FirstCreen.sharedPreferences.edit();
        FirstCreen.editor.putString(FirstCreen.highscore, String.valueOf(diem));
        FirstCreen.editor.commit();

        txtgameover.setText("Game over!");


}

    void  pause(){
    if(flagpause==false) {
        btnBom.setEnabled(false);
        btnDuoi.setEnabled(false);
        btnPhai.setEnabled(false);
        btnTrai.setEnabled(false);
        btnTren.setEnabled(false);
        CDthoiGian.cancel();
        quaiDiChuyen.cancel();
        quaiDiChuyen2.cancel();
        quaiDiChuyen3.cancel();
        flagpause=true;
    }
    else{
        btnBom.setEnabled(true);
        btnDuoi.setEnabled(true);
        btnPhai.setEnabled(true);
        btnTrai.setEnabled(true);
        btnTren.setEnabled(true);
        CDthoiGian.start();
        quaiDiChuyen.start();
        quaiDiChuyen2.start();
        quaiDiChuyen3.start();
        flagpause=false;
    }

    }

    public void onClick (View v){

    }


}