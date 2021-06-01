package com.example.min2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {


    ImageView perfil;
    TextView name;
    TextView surname;

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    //String name;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        perfil = findViewById(R.id.perfilImagen);
        surname = findViewById(R.id.surname);
        name = findViewById(R.id.nombreUser);
        progressBar = findViewById(R.id.progres);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        getUser();
        context = getApplicationContext();

    }



    public static Context context;


    public void getUser() {

        progressBar.setVisibility(View.VISIBLE);
        Call<User> call = ApiClient.getUserService().getInfo("TheKiller99");
        Intent intent = new Intent(this,MainActivity.class);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.code() == 200) {
                    User user = response.body();
                    progressBar.setVisibility(View.INVISIBLE);
                    name.setText(user.getName());
                    surname.setText(user.getSurname());
                    /*String avatar = user.getAvatar();
                    Glide.with(context).load(url).into(perfil);*/
                }
               else if (response.code() == 404){
                   // AlertDialog alertDialog = new AlertDialog.Builder (com.example.minimo2.InfoActivity.this).create();

                    /*alertDialog.setMessage("No se ha encontrado al usuario");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();*/

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                /*AlertDialog alertDialog = new AlertDialog.Builder (com.example.minimo2.InfoActivity.this).create();

                alertDialog.setMessage("Error en la conexión");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();*/

            }
        });



    }

   /* public void getAllRespositorios() {
        Call<List<Repositorio>> call = ApiClient.getUserService().getRespos(name);
        Intent intent = new Intent(this,MainActivity.class);
        call.enqueue(new Callback<List<Repositorio>>() {
            @Override
            public void onResponse(Call<List<Repositorio>> call, Response<List<Repositorio>> response) {
                List<Repositorio> repos = response.body();
                myAdapter = new MyAdapter();
                myAdapter.setData(repos);
                recyclerView.setAdapter(myAdapter);


            }

            @Override
            public void onFailure(Call<List<Repositorio>> call, Throwable t) {

            }
        });

    }*/

}