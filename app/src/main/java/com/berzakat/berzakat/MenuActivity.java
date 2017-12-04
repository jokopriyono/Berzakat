package com.berzakat.berzakat;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnTutorial = findViewById(R.id.btn_tutorial);
        Button btnSimulasi = findViewById(R.id.btn_simulasi);
        ImageView imgAndroid = findViewById(R.id.img_android);

        btnTutorial.setOnClickListener(this);
        btnSimulasi.setOnClickListener(this);
        imgAndroid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tutorial:
                startActivity(new Intent(this, TutorialActivity.class));
                break;
            case R.id.btn_simulasi:
                startActivity(new Intent(this, SimulasiActivity.class));
                break;
            case R.id.img_android:
                new AlertDialog.Builder(this)
                        .setMessage("Ini gambar")
                        .setPositiveButton("OK", null)
                        .setCancelable(true)
                        .create().show();
        }
    }
}
