package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView cim;
    private ImageView image;
    private Button buttoniras;
    private Button buttonfej;
    private TextView dobasszam;
    private TextView gyozelemszam;
    private TextView veresegszam;
    private int dobas;
    private int gyozelem;
    private int vereseg;
    private AlertDialog.Builder felugro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        cim.setBackgroundColor(Color.MAGENTA);
        buttonfej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam=Random();
                kep(szam);
                if (szam==0)
                {
                    dobas++;
                    gyozelem++;
                    dobasszam.setText(String.valueOf(dobas));
                    gyozelemszam.setText(String.valueOf(gyozelem));
                    Toast.makeText(MainActivity.this,"Győztél",Toast.LENGTH_SHORT).show();
                    endgame();
                }
                else
                {
                    dobas++;
                    vereseg++;
                    dobasszam.setText(String.valueOf(dobas));
                    veresegszam.setText(String.valueOf(vereseg));
                    Toast.makeText(MainActivity.this,"Vesztettél",Toast.LENGTH_SHORT).show();
                    endgame();
                }
            }
        });
        buttoniras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam=Random();
                kep(szam);
                if (szam==0)
                {
                    dobas++;
                    vereseg++;
                    dobasszam.setText(String.valueOf(dobas));
                    veresegszam.setText(String.valueOf(vereseg));
                    Toast.makeText(MainActivity.this,"Vesztettél",Toast.LENGTH_SHORT).show();
                    endgame();
                }
                else
                {
                    dobas++;
                    gyozelem++;
                    dobasszam.setText(String.valueOf(dobas));
                    gyozelemszam.setText(String.valueOf(gyozelem));
                    Toast.makeText(MainActivity.this,"Győztél",Toast.LENGTH_SHORT).show();
                    endgame();
                }
            }
        });


    }
    private void init()
    {
        cim=findViewById(R.id.cim);
        image=findViewById(R.id.image);
        buttoniras=findViewById(R.id.buttoniras);
        buttonfej=findViewById(R.id.buttonfej);
        dobasszam=findViewById(R.id.dobasokszam);
        gyozelemszam=findViewById(R.id.gyozelemszam);
        veresegszam=findViewById(R.id.veresegszam);
        dobas=0;
        gyozelem=0;
        vereseg=0;
        felugro=new AlertDialog.Builder(MainActivity.this);
        felugro.setMessage("Újra akarod kezdeni?")
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Ujjatek();
                    }
                })
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }
    public void kep(int szam)
    {
        if (szam==0)
        {
            image.setImageResource(R.drawable.heads);
        }
        else
        {
            image.setImageResource(R.drawable.tails);
        }
    }
    public int Random()
    {
        Random random=new Random();
        int szam= random.nextInt(2);
        return szam;
    }
    public void endgame()
    {
        if(dobas==5)
        {
            if(gyozelem>vereseg)
            {
                felugro.setTitle("Győzelem").create();
                felugro.show();
            }
            else
            {
                felugro.setTitle("Vereség").create();
                felugro.show();
            }
        }
    }
    public void Ujjatek()
    {
        dobas=0;
        vereseg=0;
        gyozelem=0;
        gyozelemszam.setText(String.valueOf(gyozelem));
        veresegszam.setText(String.valueOf(vereseg));
        dobasszam.setText(String.valueOf(dobas));

    }
}