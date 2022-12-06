package br.fmu.projetoaulan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class MaterialAdapter extends RecyclerView.Adapter {
    private List<Material> materials;
    private Context context;
    public MaterialAdapter(List<Material> materials, Context context) {
        this.materials = materials;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_material,
                parent,false);
        return new MaterialViewHolder(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        MaterialViewHolder materialViewHolder = (MaterialViewHolder) holder;
        Material material = materials.get(position);
        materialViewHolder.id.setText(Integer.toString(material.getId()));
        materialViewHolder.nome.setText(material.getNome());
        materialViewHolder.dataCadastro.setText(dateFormat.format(material.getDataCadastro()));
        materialViewHolder.unidade.setText(Double.toString(material.getUnidade()));
        materialViewHolder.tipo.setText(material.getTipo());
    }
    @Override
    public int getItemCount() { return materials.size(); }

}
