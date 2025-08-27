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
    ImageView imgRojo, imgAmarillo, imgVerde;
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
        imgRojo = findViewById(R.id.imgRojo);
        imgAmarillo = findViewById(R.id.imgAmarillo);
        imgVerde = findViewById(R.id.imgVerde);
        mainLayout = findViewById(R.id.main);


        btnActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            // ROJO
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imgRojo.setImageResource(R.drawable.luz_roja);
                                    imgAmarillo.setImageResource(R.drawable.foco);
                                    imgVerde.setImageResource(R.drawable.foco);
                                }
                            });
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // AMARILLO
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imgRojo.setImageResource(R.drawable.foco);
                                    imgAmarillo.setImageResource(R.drawable.luz_amarilla);
                                    imgVerde.setImageResource(R.drawable.foco);
                                }
                            });
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // VERDE
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imgRojo.setImageResource(R.drawable.foco);
                                    imgAmarillo.setImageResource(R.drawable.foco);
                                    imgVerde.setImageResource(R.drawable.luz_verde);
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
                thread.start();
            }
        });

    }
}