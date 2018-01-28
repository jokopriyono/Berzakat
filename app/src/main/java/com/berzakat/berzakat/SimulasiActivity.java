package com.berzakat.berzakat;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimulasiActivity extends AppCompatActivity {

    private EditText edtHargaBeras;
    private TextView txtZakatFitrah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulasi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        edtHargaBeras = findViewById(R.id.edt_harga_beras);
        txtZakatFitrah = findViewById(R.id.txt_zakat_fitrah);
        Button btnHitung = findViewById(R.id.btn_hitung_fitrah);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtHargaBeras.getText().toString().equals("")){
                    edtHargaBeras.setError("Harga beras mohon diisi");
                } else {
                    Double beras = Double.parseDouble(edtHargaBeras.getText().toString());
                    Double zakatFitrah = beras*2.5;
                    txtZakatFitrah.setText("Zakat Fitrah :" + zakatFitrah);
                }
            }
        });

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ZakatEmasFragment zakatEmasFragment = new ZakatEmasFragment();
        ZakatTernakFragment zakatTernakFragment = new ZakatTernakFragment();
        ZakatDagangFragment zakatDagangFragment = new ZakatDagangFragment();
        adapter.addFrag(zakatEmasFragment, "Emas");
        adapter.addFrag(zakatTernakFragment, "Ternak");
        adapter.addFrag(zakatDagangFragment, "Dagang");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
