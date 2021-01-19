package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUser, etPass;
    FirebaseFirestore db;
    Button btLogin;
    String User, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser= findViewById(R.id.etUsuario);
        etPass= findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btnIngresar);
        db= FirebaseFirestore.getInstance();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User = etUser.getText().toString();
                Pass = etPass.getText().toString();

                db.collection("Usuario")
                        .whereEqualTo("user", User)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()){
                                    String passdb = null;
                                    for (QueryDocumentSnapshot datos: task.getResult()){
                                        passdb = datos.getData().get("pass").toString();
                                    }
                                    if (Pass.equals(passdb)){
                                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "usuario o contraseña incorrectas", Toast.LENGTH_LONG).show();
                                    }
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "usuario o contraseña incorrectas", Toast.LENGTH_LONG).show();
                                }

                            }
                        });

            }
        });

    }


    public void Registro(View view) {
        Intent intent= new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}