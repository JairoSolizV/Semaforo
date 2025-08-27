package com.example.semaforo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnActivar;
    ImageView imgFoco1, imgFoco2;
    View mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnActivar = findViewById(R.id.btnActivar);
        imgFoco1 = findViewById(R.id.imgFoco1);
        imgFoco2 = findViewById(R.id.imgFoco2);
        mainLayout = findViewById(R.id.main);


        btnActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread threadFocoArriba = new Thread(new Runnable() {
                    int color = 1;
                    @Override
                    public void run() {
                        while(true){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    switch (color)
                                        {
                                        case 1:
                                            imgFoco1.setImageResource(R.drawable.luz_roja);
                                            color = 2;
                                            break;
                                        case 2:
                                            imgFoco1.setImageResource(R.drawable.luz_amarilla);
                                            color = 3;
                                            break;
                                        case 3:
                                            imgFoco1.setImageResource(R.drawable.luz_verde);
                                            color = 1;
                                            break;
                                        }
                                }
                            });
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                threadFocoArriba.start();
                Thread threadFocoAbajo = new Thread(new Runnable() {
                    int color = 1;
                    @Override
                    public void run() {
                        while(true){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    switch (color) {
                                        case 1:
                                            imgFoco2.setImageResource(R.drawable.luz_verde);
                                            color = 2;
                                            break;
                                        case 2:
                                            imgFoco2.setImageResource(R.drawable.luz_amarilla);
                                            color = 3;
                                            break;
                                        case 3:
                                            imgFoco2.setImageResource(R.drawable.luz_roja);
                                            color = 1;
                                            break;
                                    }
                                }
                            });
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                });
                threadFocoAbajo.start();
            }
        });

    }
}