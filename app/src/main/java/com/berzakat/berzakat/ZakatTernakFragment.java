package com.berzakat.berzakat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ZakatTernakFragment extends Fragment {

    private RadioGroup radioGroup;
    private TextView txtZakatTernak;
    private EditText edtZakatTernak;

    public ZakatTernakFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_zakat_ternak, container, false);

        radioGroup = view.findViewById(R.id.radio_group);
        edtZakatTernak = view.findViewById(R.id.edt_ternak);
        Button btnHitung = view.findViewById(R.id.btn_zakat_ternak);
        txtZakatTernak = view.findViewById(R.id.txt_zakat_ternak);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadio = radioGroup.getCheckedRadioButtonId();
                if (idRadio == -1){
                    Toast.makeText(getContext(), "Pilih salah satu hewan ternak", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton radioButton = view.findViewById(idRadio);
                    if (edtZakatTernak.getText().toString().equals("")){
                        edtZakatTernak.setError("Jumlah hewan ternak harap diisi");
                    } else {
                        if (radioButton.getText().equals("Sapi")){
                            int sapi = Integer.parseInt(edtZakatTernak.getText().toString());
                            if (sapi <30){
                                edtZakatTernak.setError("Sapi minimal 30 ekor");
                            } else {
                                while (sapi%10 != 0){
                                    sapi--;
                                }
                                int tabi = 0;
                                int musinnah = 0;
                                if (sapi%30 == 0){
                                    tabi = sapi/30;
                                    musinnah = 0;
                                }
                                else if (sapi%40 == 0){
                                    tabi = 0;
                                    musinnah = sapi/40;
                                }
                                else if (sapi%30 != 0){
                                    if (sapi%30 == 10) {
                                        tabi = (sapi - 30) / 30;
                                        musinnah = 1;
                                    } else {
                                        //kasus 110  140  170  230  260
                                        tabi = (sapi - 80) / 30;
                                        musinnah = 2;
                                    }
                                }
                                String zakat = "Zakat Sapi :\n"+tabi+" ekor tabi'/tabi'ah\natau\n"+musinnah+" ekor musinnah";
                                txtZakatTernak.setText(zakat);
                            }
                        } else if (radioButton.getText().equals("Kambing")){
                            int kambing = Integer.parseInt(edtZakatTernak.getText().toString());
                            if (kambing <40){
                                edtZakatTernak.setError("Kambing minimal 40 ekor");
                            } else {
                                int zakat;
                                if (kambing <=120){
                                    zakat=1;
                                } else if (kambing>120 && kambing<=200){
                                    zakat=2;
                                } else if (kambing<=300) {
                                    zakat=3;
                                } else {
                                    zakat = kambing/100;
                                }
                                String text = "Zakat kambing : "+zakat+ " ekor";
                                txtZakatTernak.setText(text);
                            }
                        } else {
                            Toast.makeText(getContext(), "masuk", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });

        return view;
    }
}
