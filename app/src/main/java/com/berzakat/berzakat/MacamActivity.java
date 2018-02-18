package com.berzakat.berzakat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MacamActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macam);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnFitrah = findViewById(R.id.btn_fitrah);
        Button btnMaal = findViewById(R.id.btn_mal);
        btnFitrah.setOnClickListener(this);
        btnMaal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fitrah:
                startActivity(new Intent(this, ZakatFitrahActivity.class));
                break;
            case R.id.btn_mal:
                startActivity(new Intent(this, ZakatMaalActivity.class));
                break;
        }
    }
}
