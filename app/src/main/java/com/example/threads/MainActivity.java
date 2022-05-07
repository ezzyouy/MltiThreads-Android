package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Activity myActivity;
    myfirstThread T1;
    mySecondThread T2;
    boolean runer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myActivity=this;
    }

    public void Start(View view){
        runer=true;
        T1=new myfirstThread();
        T1.start();
        T2=new mySecondThread();
        T2.start();
    }
    public void stop(View view){
        runer=false;
    }

    public void AfficheMsg(View view){
        Toast.makeText(this, "Hi, you are click on message button",Toast.LENGTH_LONG).show();
    }

    class myfirstThread extends Thread{
        int x=0;
        public void run(){
            final TextView cpt1=findViewById(R.id.txtvThread1);
            while(runer){
                myActivity.runOnUiThread(()->{
                    cpt1.setText(String.valueOf(x));
                });
                x++;
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
        }
    }
    class mySecondThread extends  Thread{
        int y=100;
        public void run(){
            final TextView cpt1=findViewById(R.id.txtvThread2);
            while(runer){
                myActivity.runOnUiThread(()->{
                    cpt1.setText(String.valueOf(y));
                });
                y++;
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
        }
    }
}