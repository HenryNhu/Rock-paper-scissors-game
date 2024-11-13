package com.example.onthith_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnKeo, btnBua, btnBao, btnNghiChoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnKeo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnBua.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnBao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnNghiChoi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void xuLyRa(View v) {
        String banRa = ((Button)v).getText().toString().toUpperCase();
        Intent intent = new Intent(MainActivity.this, KetquaActivity.class);
        intent.putExtra("BANRA",banRa);
        startActivity(intent);
    }

    private void addControls() {
        btnKeo = findViewById(R.id.btn_Keo);
        btnBua = findViewById(R.id.btn_Bua);
        btnBao = findViewById(R.id.btn_Bao);
        btnNghiChoi = findViewById(R.id.btn_NghiChoi);
    }
    
}