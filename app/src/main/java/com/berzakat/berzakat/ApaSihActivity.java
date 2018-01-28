package com.berzakat.berzakat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApaSihActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apa_sih);

        Button btnPengertian = findViewById(R.id.btn_pengertian);
        Button btnDalil = findViewById(R.id.btn_dalil);
        Button btnMacam = findViewById(R.id.btn_macam);

        btnPengertian.setOnClickListener(this);
        btnDalil.setOnClickListener(this);
        btnMacam.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_pengertian:
                break;
            case R.id.btn_dalil:
                startActivity(new Intent(this, DalilActivity.class));
                break;
            case R.id.btn_macam:
                startActivity(new Intent(this, MacamActivity.class));
                break;
        }
    }
}
