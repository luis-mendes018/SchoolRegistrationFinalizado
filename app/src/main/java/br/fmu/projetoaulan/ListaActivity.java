package br.fmu.projetoaulan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        AppDatabase db = AppDatabase.getInstance(this);
        MaterialDao dao = db.materialDao();
        List<Material> materials = dao.getMaterial();
        recyclerView.setAdapter(new MaterialAdapter(materials,this));
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                        false);
        recyclerView.setLayoutManager(layoutManager);
    }
}