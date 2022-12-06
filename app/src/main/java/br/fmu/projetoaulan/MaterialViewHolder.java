package br.fmu.projetoaulan;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MaterialViewHolder extends RecyclerView.ViewHolder {
    final TextView id;
    final TextView nome;
    final TextView dataCadastro;
    final TextView unidade;
    final TextView tipo;
    public MaterialViewHolder(View itemView ) {
        super(itemView);
        id = itemView.findViewById(R.id.item_re);
        nome = itemView.findViewById(R.id.item_nome);
        dataCadastro = itemView.findViewById(R.id.item_dataAdm);
        unidade = itemView.findViewById(R.id.item_salario);
        tipo = itemView.findViewById(R.id.item_funcao);
    }
}
