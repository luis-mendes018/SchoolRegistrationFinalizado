package br.fmu.projetoaulan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MaterialBDActivity extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextId;
    private EditText editTextDataCadastro;
    private EditText editTextUnidade;
    private EditText editTextTipo;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_bdactivity);
        editTextId = findViewById(R.id.editTextId);
        editTextNome = findViewById(R.id.editTextNome);
        editTextDataCadastro = findViewById(R.id.editTextDataCadastro);
        editTextUnidade = findViewById(R.id.editTextUnidade);
        editTextTipo = findViewById(R.id.editTextTipo);
    }
    public void cadastrar(View view ) {
        int id = Integer.parseInt(editTextId.getText().toString());
        String nome = editTextNome.getText().toString();
        Date dataCadastro;
        try {
            dataCadastro = dateFormat.parse(editTextDataCadastro.getText().toString());
        } catch (ParseException e) {
            dataCadastro = new Date();
        }
        int unidade = Integer.parseInt(editTextUnidade.getText().toString());
        String tipo = editTextTipo.getText().toString();
        AppDatabase db = AppDatabase.getInstance(this);
        MaterialDao dao = db.materialDao();
        Material mat = new Material(id,nome,dataCadastro,unidade, tipo);
        dao.insert(mat);
        Toast.makeText(this, "Material cadastrado com suscesso!", Toast.LENGTH_SHORT).show();
    }
    public void buscar(View view) {
        int id = Integer.parseInt(editTextId.getText().toString());
        AppDatabase db = AppDatabase.getInstance(this);
        MaterialDao dao = db.materialDao();
        Material material = dao.buscarPorId(id);
        editTextNome.setText(material.getNome());
        editTextDataCadastro.setText(dateFormat.format(material.getDataCadastro()));
        editTextUnidade.setText(Integer.toString(material.getUnidade()));
        editTextTipo.setText(material.getTipo());
    }
    public void excluir(View view) {
        int id = Integer.parseInt(editTextId.getText().toString());
        AppDatabase db = AppDatabase.getInstance(this);
        MaterialDao dao = db.materialDao();
        Material material = dao.buscarPorId(id);
        dao.delete(material);
        limpar();
        Toast.makeText(this, "Material deletado com suscesso!", Toast.LENGTH_SHORT).show();
    }
    public void alterar(View view) {
        int id = Integer.parseInt(editTextId.getText().toString());
        String nome = editTextNome.getText().toString();
        Date dataCadastrro;
        try {
            dataCadastrro = dateFormat.parse(editTextDataCadastro.getText().toString());
        } catch (ParseException e) {
            dataCadastrro = new Date();
        }
        int unidade = Integer.parseInt(editTextUnidade.getText().toString());
        String tipo = editTextTipo.getText().toString();
        AppDatabase db = AppDatabase.getInstance(this);
        MaterialDao dao = db.materialDao();
        Material mat = new Material(id,nome,dataCadastrro,unidade,tipo);
        dao.update(mat);
        Toast.makeText(this, "Material alterado com suscesso!", Toast.LENGTH_SHORT).show();
    }
    private void limpar() {
        editTextId.setText("");
        editTextNome.setText("");
        editTextDataCadastro.setText("");
        editTextUnidade.setText("");
        editTextTipo.setText("");
    }
    public void listar(View view) {
        Intent intent = new Intent(this,ListaActivity.class);
        startActivity(intent);
    }
}