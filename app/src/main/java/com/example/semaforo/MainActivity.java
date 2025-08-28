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
    ImageView imgRojo1, imgAmarillo1, imgVerde1, imgRojo2, imgAmarillo2, imgVerde2;;
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
        mainLayout = findViewById(R.id.main);
        // Semaforo 1
        imgRojo1 = findViewById(R.id.imgRojo1);
        imgAmarillo1 = findViewById(R.id.imgAmarillo1);
        imgVerde1 = findViewById(R.id.imgVerde1);
        // Semaforo 2
        imgRojo2 = findViewById(R.id.imgRojo2);
        imgAmarillo2 = findViewById(R.id.imgAmarillo2);
        imgVerde2 = findViewById(R.id.imgVerde2);


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
                                    // Semáforo 1
                                    imgRojo1.setImageResource(R.drawable.luz_roja);
                                    imgAmarillo1.setImageResource(R.drawable.foco);
                                    imgVerde1.setImageResource(R.drawable.foco);

                                    // Semáforo 2
                                    imgRojo2.setImageResource(R.drawable.foco);
                                    imgAmarillo2.setImageResource(R.drawable.foco);
                                    imgVerde2.setImageResource(R.drawable.luz_verde);
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
                                    // Semáforo 1
                                    imgRojo1.setImageResource(R.drawable.foco);
                                    imgAmarillo1.setImageResource(R.drawable.luz_amarilla);
                                    imgVerde1.setImageResource(R.drawable.foco);

                                    // Semáforo 2
                                    imgRojo2.setImageResource(R.drawable.foco);
                                    imgAmarillo2.setImageResource(R.drawable.luz_amarilla);
                                    imgVerde2.setImageResource(R.drawable.foco);
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
                                    // Semáforo 1
                                    imgRojo1.setImageResource(R.drawable.foco);
                                    imgAmarillo1.setImageResource(R.drawable.foco);
                                    imgVerde1.setImageResource(R.drawable.luz_verde);

                                    // Semáforo 2
                                    imgRojo2.setImageResource(R.drawable.luz_roja);
                                    imgAmarillo2.setImageResource(R.drawable.foco);
                                    imgVerde2.setImageResource(R.drawable.foco);
                                }
                            });
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // Semáforo 1
                                    imgRojo1.setImageResource(R.drawable.foco);
                                    imgAmarillo1.setImageResource(R.drawable.luz_amarilla);
                                    imgVerde1.setImageResource(R.drawable.foco);

                                    // Semáforo 2
                                    imgRojo2.setImageResource(R.drawable.foco);
                                    imgAmarillo2.setImageResource(R.drawable.luz_amarilla);
                                    imgVerde2.setImageResource(R.drawable.foco);
                            }
                            });
                            try {
                                Thread.sleep(2000);
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