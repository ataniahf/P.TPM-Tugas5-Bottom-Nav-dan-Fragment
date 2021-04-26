package com.fti.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SinopsisActivity extends AppCompatActivity {
    private TextView tvJudulBuku,tvSinopsis, tvHarga;
    private ImageView ivGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis);

        tvJudulBuku = findViewById(R.id.tvjudulbuku);
        tvSinopsis = findViewById(R.id.tvsinopsis);
        ivGambar = findViewById(R.id.ivgambarbuku);
        tvHarga = findViewById(R.id.tvhargabuku);

        String sJudul = getIntent().getStringExtra("judulBuku");
        String sSinopsis = getIntent().getStringExtra("sinopsisBuku");
        String sHarga = "Rp. " + getIntent().getStringExtra("hargaBuku");
        int iGambar = getIntent().getIntExtra("gambarBuku",0);

        Glide.with(this).load(iGambar).into(ivGambar);
        tvJudulBuku.setText(sJudul);
        tvSinopsis.setText(sSinopsis);
        tvHarga.setText(sHarga);

    }
}