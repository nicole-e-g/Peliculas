package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView peliculas;
    RecyclerView.LayoutManager miLayout;
    RecyclerView.Adapter miAdaptador;
    FirebaseFirestore db;
    List<Peliculas> resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        peliculas= findViewById(R.id.mirecycler);

        miLayout = new LinearLayoutManager(this);
        peliculas.setLayoutManager(miLayout);

        resultado = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        db.collection("Contenido")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot peli: task.getResult()){
                                String id = peli.getId();
                                String poster = peli.getData().get("image").toString();
                                String nombre = peli.getData().get("nombre").toString();
                                String genero = peli.getData().get("genero").toString();
                                String descripcion = peli.getData().get("Sinopsis").toString();
                                String director = peli.getData().get("Director").toString();
                                String duracion = peli.getData().get("Duracion").toString();
                                resultado.add(new Peliculas(id,poster,nombre,genero, descripcion, director, duracion));
                            }
                            miAdaptador = new Adaptador(resultado);
                            peliculas.setAdapter(miAdaptador);
                        }
                        else{
                            Log.e("Proyecto", "Error", task.getException());
                        }

                    }
                });

    }

}