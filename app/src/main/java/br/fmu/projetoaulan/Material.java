package br.fmu.projetoaulan;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Material {
    @PrimaryKey
    private int id;
    private String nome;
    private Date dataCadastro;
    private int unidade;
    private String tipo;

    public Material() {
    }

    public Material(int id, String nome, Date dataCadastro, int unidade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.unidade = unidade;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", unidade=" + unidade +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
