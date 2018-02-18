package com.berzakat.berzakat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ZakatFitrahFragment extends Fragment {

    private EditText edtHargaBeras;
    private TextView txtZakatFitrah;

    public ZakatFitrahFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zakat_fitrah, container, false);

        Button btnHitung = view.findViewById(R.id.btn_hitung_fitrah);
        edtHargaBeras = view.findViewById(R.id.edt_harga_beras);
        txtZakatFitrah = view.findViewById(R.id.txt_zakat_fitrah);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtHargaBeras.getText().toString().equals("")){
                    edtHargaBeras.setError("Harga beras mohon diisi");
                } else {
                    Double beras = Double.parseDouble(edtHargaBeras.getText().toString());
                    Double zakatFitrah = beras*2.5;
                    String text = "Zakat Fitrah :" + zakatFitrah;
                    txtZakatFitrah.setText(text);
                }
            }
        });
        return view;
    }
}
