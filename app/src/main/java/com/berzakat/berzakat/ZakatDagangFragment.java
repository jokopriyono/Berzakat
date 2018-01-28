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

public class ZakatDagangFragment extends Fragment {

    private EditText edtModal;
    private EditText edtLaba;
    private EditText edtHutang;
    private TextView txtZakatDagang;

    public ZakatDagangFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zakat_dagang, container, false);

        edtModal = view.findViewById(R.id.edt_modal);
        edtLaba = view.findViewById(R.id.edt_laba);
        edtHutang = view.findViewById(R.id.edt_hutang);
        txtZakatDagang = view.findViewById(R.id.txt_zakat_dagang);
        Button btnHitung = view.findViewById(R.id.btn_hitung);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtModal.getText().toString().equals("")){
                    edtModal.setError("Modal dagang mohon diisi");
                } else {
                    Double laba, hutang;
                    Double modal = Double.parseDouble(edtModal.getText().toString());
                    if (edtLaba.getText().toString().equals(""))
                        laba=0.0;
                    else
                        laba = Double.parseDouble(edtLaba.getText().toString());
                    if (edtHutang.getText().toString().equals(""))
                        hutang = 0.0;
                    else
                        hutang = Double.parseDouble(edtHutang.getText().toString());

                    Double zakat = ((modal-hutang)+laba)*2.5/100;
                    txtZakatDagang.setText("Zakat dagang : "+zakat);
                }
            }
        });

        return view;
    }
}
