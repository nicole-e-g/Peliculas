package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class sinopsis extends AppCompatActivity {
    TextView tvSipn;
    ImageView imga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis);

        String id = getIntent().getExtras().getString("id");
        String image = getIntent().getExtras().getString("image");
        String sinopsis = getIntent().getExtras().getString("sinopsis");
        tvSipn = findViewById(R.id.tvSinopsis);
        tvSipn.setText(sinopsis);
        imga = findViewById(R.id.imageView2);
        Glide.with(imga.getContext()).load(image).into(imga);
        Toast.makeText(this, "Pelicula:"+id, Toast.LENGTH_SHORT).show();
    }
}