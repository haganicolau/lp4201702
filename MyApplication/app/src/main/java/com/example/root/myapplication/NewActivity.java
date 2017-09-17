package com.example.root.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        /*Bundle b = getIntent().getExtras();
        String value = b.getString("key");

        Log.d("MAIN", value);*/
        //message(this, String.valueOf(value));
    }

    public void backActivity(View view){
        //Intent it = new Intent(this, MainActivity.class);
        //startActivity(it);

        Intent devolve = new Intent(this, MainActivity.class);
        devolve.putExtra("Resposta", "Retornando Resposta");
        setResult(RESULT_OK, devolve);
        finish();
    }


    public void message(Context context, String mesage){
        Toast.makeText(context, mesage, Toast.LENGTH_SHORT).show();
    }
}
