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

public class ZakatEmasFragment extends Fragment {

    private TextView txtZakatEmas;
    private EditText edtEmas;

    public ZakatEmasFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zakat_emas, container, false);
        edtEmas = view.findViewById(R.id.edt_emas);
        txtZakatEmas = view.findViewById(R.id.txt_zakat_emas);
        Button btnHitungEmas = view.findViewById(R.id.btn_zakat_emas);

        btnHitungEmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtEmas.getText().toString().equals("")){
                    edtEmas.setError("Berat emas mohon diisi");
                } else {
                    Double gram = Double.parseDouble(edtEmas.getText().toString());
                    if (gram<=85){
                        edtEmas.setError("Emas harus diatas 85 gram");
                    } else {
                        gram = gram*2.5/100;
                        txtZakatEmas.setText("Zakat Emas : "+gram+" gram");
                    }
                }
            }
        });
        return view;
    }
}
