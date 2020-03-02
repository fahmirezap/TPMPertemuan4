package com.example.pahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPahlawan extends AppCompatActivity {

    public static String DATA = "data";
    private ImageView ivFoto;
    private TextView tvNama, tvDeskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pahlawan);

        ivFoto = findViewById(R.id.iv_detail_foto);
        tvNama = findViewById(R.id.tv_detail_nama);
        tvDeskripsi = findViewById(R.id.tv_detail_deskrip);

        ModelPahlawan pahlawan = getIntent().getParcelableExtra(DATA);
        if (pahlawan!=null){
            Glide.with(this).load(pahlawan.getImage()).into(ivFoto);
            tvNama.setText(pahlawan.getName());
            tvDeskripsi.setText(pahlawan.getDescription());
            tvDeskripsi.setMovementMethod(new ScrollingMovementMethod());
        }

    }
}
