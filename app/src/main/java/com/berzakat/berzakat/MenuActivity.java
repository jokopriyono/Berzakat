package com.berzakat.berzakat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnTutorial = findViewById(R.id.btn_apa_sih);
        Button btnSimulasi = findViewById(R.id.btn_hitung_fitrah);
        Button btnTentang = findViewById(R.id.btn_tentang);

        btnTutorial.setOnClickListener(this);
        btnSimulasi.setOnClickListener(this);
        btnTentang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tentang:
                startActivity(new Intent(this, TentangActivity.class));
                break;
            case R.id.btn_apa_sih:
                startActivity(new Intent(this, ApaSihActivity.class));
                break;
            case R.id.btn_hitung_fitrah:
                startActivity(new Intent(this, SimulasiActivity.class));
                break;
        }
    }
}
