package br.fmu.projetoaulan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CadastrarMaterial(View view) {
        Intent intent = new Intent(this, MaterialBDActivity.class);
        startActivity(intent);
    }


}