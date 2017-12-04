package com.berzakat.berzakat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimulasiActivity extends AppCompatActivity {

    private EditText edtKeuntungan;
    private EditText edtTabungan;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulasi);

        edtKeuntungan = findViewById(R.id.edt_keuntungan);
        edtTabungan = findViewById(R.id.edt_tabungan);
        Button btnHitung = findViewById(R.id.btn_hitung);
        txtHasil = findViewById(R.id.txt_hasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtKeuntungan.getText().toString().equals("")){
                    Toast.makeText(SimulasiActivity.this, "Keuntungan harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    Double untung = Double.parseDouble(edtKeuntungan.getText().toString());
                    Double tabung = 0.0;
                    if (!edtTabungan.getText().toString().equals("")){
                        tabung = Double.parseDouble(edtTabungan.getText().toString());
                    }

                    hitungZakat(untung, tabung);
                }
            }
        });
    }

    private void hitungZakat(Double untung, Double tabung) {
        Double hasil = untung+tabung;
        hasil = hasil*2.5;
        hasil = hasil/100;
        txtHasil.setText(String.valueOf(hasil.intValue()));
    }
}
