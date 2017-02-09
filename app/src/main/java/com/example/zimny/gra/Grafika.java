package com.example.zimny.gra;

/**
 * Created by ZimnY on 24.01.2017.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Grafika extends View  implements View.OnTouchListener {

    int x=-100, y=-100;
    String[] lista = new String[9];

    boolean b=false;
    int krzyzyk=1;
    public Grafika(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    protected void onDraw(Canvas canvas){

        Paint paint = new Paint();
        paint.setStrokeWidth(20);
        canvas.drawLine(0,getHeight()/3*1,getWidth(),getHeight()/3*1,paint);
        canvas.drawLine(0,getHeight()/3*2,getWidth(),getHeight()/3*2,paint);
        canvas.drawLine(getWidth()/3,0,getWidth()/3,getHeight(),paint);
        canvas.drawLine(getWidth()/3*2,0,getWidth()/3*2,getHeight(),paint);
        //for (int i=1;i<10;i++)
        //    drawo(i,paint,canvas);

        if (b) {
            for(int i=0;i<lista.length;i++)
            {
                if (lista[i]=="x")
                {
                    drawx(i+1, paint, canvas);
                }
                else if (lista[i]=="o")
                {
                    drawo(i+1, paint, canvas);
                }
            }
            b=false;
        }
        if (check(lista)!=null)
        {
            Toast.makeText(getContext(),"Wygrana "+check(lista),Toast.LENGTH_SHORT).show();
            for(int i=0;i<lista.length;i++)
            lista[i]=null;
            for(int i=0;i<lista.length;i++)
            {
                if (lista[i]=="x")
                {
                    drawx(i+1, paint, canvas);
                }
                else if (lista[i]=="o")
                {
                    drawo(i+1, paint, canvas);
                }
            }
         this.invalidate();
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        if (x>=0&&x<=getWidth()/3&&y>=0&&y<=getHeight()/3)
        {
            if (lista[0]==null) {
                if (krzyzyk == 1) {
                    lista[0] = "x";
                    krzyzyk = 0;
                } else {
                    lista[0] = "o";
                    krzyzyk = 1;
                }
                b = true;
                this.invalidate();
            }
        }
        if (x>=getWidth()/3&&x<=getWidth()/3*2&&y>=0&&y<=getHeight()/3) {
            if (lista[1] == null) {
                if (krzyzyk == 1) {
                    lista[1] = "x";
                    krzyzyk = 0;
                } else {
                    lista[1] = "o";
                    krzyzyk = 1;
                }

            b = true;
            this.invalidate();
        }
        }
        if (x>=getWidth()/3*2&&x<=getWidth()&&y>=0&&y<=getHeight()/3) {
            if (lista[2] == null) {
                if (krzyzyk == 1) {
                    lista[2] = "x";
                    krzyzyk = 0;
                } else {
                    lista[2] = "o";
                    krzyzyk = 1;
                }

            b = true;
            this.invalidate();
        }
        }
        if (x>=0&&x<=getWidth()/3&&y>=getHeight()/3&&y<=getHeight()/3*2) {
            if (lista[3] == null) {
                if (krzyzyk == 1) {
                    lista[3] = "x";
                    krzyzyk = 0;
                } else {
                    lista[3] = "o";
                    krzyzyk = 1;
                }

            b = true;
            this.invalidate();
        }
        }
        if (x>=getWidth()/3&&x<=getWidth()/3*2&&y>=getHeight()/3&&y<=getHeight()/3*2) {
            if (lista[4] == null) {
                if (krzyzyk == 1) {
                    lista[4] = "x";
                    krzyzyk = 0;
                } else {
                    lista[4] = "o";
                    krzyzyk = 1;
                }

            b = true;
            this.invalidate();
        }
        }
        if (x>=getWidth()/3*2&&x<=getWidth()&&y>=getHeight()/3&&y<=getHeight()/3*2) {
            if (lista[5] == null) {
                if (krzyzyk == 1) {
                    lista[5] = "x";
                    krzyzyk = 0;
                } else {
                    lista[5] = "o";
                    krzyzyk = 1;
                }

            b = true;
            this.invalidate();
        }
        }
        if (x>=0&&x<=getWidth()/3&&y>=getHeight()/3*2&&y<=getHeight()) {
            if (lista[6] == null) {
                if (krzyzyk == 1) {
                    lista[6] = "x";
                    krzyzyk = 0;
                } else {
                    lista[6] = "o";
                    krzyzyk = 1;
                }

                b = true;
                this.invalidate();
            }
        }
        if (x>=getWidth()/3&&x<=getWidth()/3*2&&y>=getHeight()/3*2&&y<=getHeight())
        {
            if (lista[7]==null) {
                if (krzyzyk == 1) {
                    lista[7] = "x";
                    krzyzyk = 0;
                } else {
                    lista[7] = "o";
                    krzyzyk = 1;
                }

                b = true;
                this.invalidate();
            }
        }
        if (x>=getWidth()/3*2&&x<=getWidth()&&y>=getHeight()/3*2&&y<=getHeight())
        {
        if (lista[8] == null) {
            if (krzyzyk == 1) {
                lista[8] = "x";
                krzyzyk = 0;
            } else {
                lista[8] = "o";
                krzyzyk = 1;
            }

        b = true;
        this.invalidate();
        }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
    public void drawx(int x, Paint paint, Canvas canvas)
    {
        int width = getWidth();
        int height = getHeight();
        int w9 =getWidth()/9;
        int h9 = getHeight()/9;
        switch(x)
        {
            case 1: drawx1(0+w9,0+h9,width/3-w9,height/3-h9,paint,canvas,w9,h9);
                drawx2(width/3-w9,0+h9,0+w9,height/3-h9,paint,canvas,w9,h9);break;
            case 2: drawx1(width/3+w9,0+h9,width/3*2-w9,height/3-h9,paint,canvas,w9,h9);
                drawx2(width/3*2-w9,0+h9,width/3+w9,height/3-h9,paint,canvas,w9,h9); break;
            case 3:  drawx1(width/3*2+w9,0+h9,width-w9,height/3-h9,paint,canvas,w9,h9);
                drawx2(width-w9,0+h9,width/3*2+w9,height/3-h9,paint,canvas,w9,h9);break;
            case 4: drawx1(0,height/3,width/3,height/3*2,paint,canvas,w9,h9);
                drawx2(width/3,height/3,0,height/3*2,paint,canvas,w9,h9);break;
            case 5: drawx1(width/3,height/3,width/3*2,height/3*2,paint,canvas,w9,h9);
                drawx2(width/3*2,height/3,width/3,height/3*2,paint,canvas,w9,h9);break;
            case 6:  drawx1(width/3*2,height/3,width,height/3*2,paint,canvas,w9,h9);
                drawx2(width,height/3,width/3*2,height/3*2,paint,canvas,w9,h9);break;
            case 7: drawx1(0,height/3*2,width/3,height,paint,canvas,w9,h9);
                drawx2(width/3,height/3*2,0,height,paint,canvas,w9,h9);break;
            case 8: drawx1(width/3,height/3*2,width/3*2,height,paint,canvas,w9,h9);
                drawx2(width/3*2,height/3*2,width/3,height,paint,canvas,w9,h9);break;
            case 9: drawx1(width/3*2,height/3*2,width,height,paint,canvas,w9,h9);
                drawx2(width,height/3*2,width/3*2,height,paint,canvas,w9,h9);break;

        }
    }
    public void drawx1(int x1,int y1,int x2,int y2,Paint paint,Canvas canvas, int w9, int h9)
    {
        canvas.drawLine(x1+w9,y1+h9,x2-w9,y2-h9,paint);
    }
    public void drawx2(int x1,int y1,int x2,int y2,Paint paint,Canvas canvas, int w9, int h9)
    {
        canvas.drawLine(x1-w9,y1+h9,x2+w9,y2-h9,paint);
    }
    public void drawo1(int x1,int y1, int radius,Paint paint,Canvas canvas)
    {
        canvas.drawCircle(x1,y1,radius,paint);
    }
    public void drawo(int x,Paint paint,Canvas canvas)
    {
        int wielkosc=getWidth()/12;
        switch(x)
        {
            case 1:drawo1(getWidth()/6,getHeight()/6,wielkosc,paint,canvas); break;
            case 2:drawo1(getWidth()/6+getWidth()/3,getHeight()/6,wielkosc,paint,canvas); break;
            case 3:drawo1(getWidth()/6+getWidth()/3*2,getHeight()/6,wielkosc,paint,canvas);   break;
            case 4:drawo1(getWidth()/6,getHeight()/6+getHeight()/3,wielkosc,paint,canvas);    break;
            case 5:drawo1(getWidth()/6+getWidth()/3,getHeight()/6+getHeight()/3,wielkosc,paint,canvas);   break;
            case 6:drawo1(getWidth()/6+getWidth()/3*2,getHeight()/6+getHeight()/3,wielkosc,paint,canvas); break;
            case 7:drawo1(getWidth()/6,getHeight()/6+getHeight()/3*2,wielkosc,paint,canvas);  break;
            case 8:drawo1(getWidth()/6+getWidth()/3,getHeight()/6+getHeight()/3*2,wielkosc,paint,canvas);   break;
            case 9:drawo1(getWidth()/6+getWidth()/3*2,getHeight()/6+getHeight()/3*2,wielkosc,paint,canvas); break;
        }
    }
    public String check(String[] lista)
    {
         for (int i=0;i<7;i+=3)
         if (lista[i]==lista[i+1]&&lista[i+1]==lista[i+2])
         {
             if (lista[i]!=null)
             return lista[i];
         }
        for (int i=0;i<3;i+=1)
            if (lista[i]==lista[i+3]&&lista[i+3]==lista[i+6])
            {
                if (lista[i]!=null)
                return lista[i];
            }
        if (lista[0]==lista[4]&&lista[4]==lista[8])
        {
            if (lista[4]!=null)
            return lista[4];
        }
        if (lista[2]==lista[4]&&lista[4]==lista[6])
        {
            if (lista[4]!=null)
            return lista[4];
        }

        return null;
    }

}