package com.example.onthith_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class KetquaActivity extends AppCompatActivity {
    public static ArrayList<String> kbb = new ArrayList<String>(){{
        add("KÉO");
        add("BÚA");
        add("BAO");
    }};
    TextView txtBanRa, txtMayRa, txtKetQua;
    Button btnTroLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ketqua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
        layThongTinBanChon();
    }

    private void layThongTinBanChon() {
        Intent intent = getIntent();
        if(intent.hasExtra("BANRA")) {
            String banRa = intent.getStringExtra("BANRA");
            if(banRa == "") {
                txtKetQua.setText("KHÔNG CÓ THÔNG TIN");
            }
            else {
                txtBanRa.setText("Bạn ra: " + banRa);
                int iBanRa = kbb.indexOf(banRa);
                int iMayRa = new Random().nextInt(kbb.size());
                String mayRa = kbb.get(iMayRa);
                txtMayRa.setText("Máy ra: " + mayRa);
                int kq = iBanRa - iMayRa;
                String kq_text = "";
                if(kq == 0){
                    kq_text = "HÒA";
                } else if (kq == 1 || kq == -2) {
                    kq_text = "BẠN THẮNG";
                } else {
                    kq_text = "BẠN THUA";
                }
                txtKetQua.setText("Kết quả: " + kq_text);
            }
        } else {
            txtBanRa.setText("KHÔNG CÓ THÔNG TIN");
        }
    }

    private void addEvents() {
        btnTroLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControls() {
        txtBanRa = findViewById(R.id.txtBanRa);
        txtMayRa = findViewById(R.id.txtMayRa);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnTroLai = findViewById(R.id.btnTroLai);
    }
    
}