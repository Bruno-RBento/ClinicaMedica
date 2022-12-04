package Medico;

import java.io.Serializable;

public class Medico implements Serializable {
    private int medID;
    private String nome;
    private Especialidade especialidade;

    //TODO turnos add

    //TODO especialidade -->arraylist passar um araylist de enum

    public Medico(int medID, String nome, Especialidade especialidade) {
        this.medID = medID;
        this.nome = nome;
        this.especialidade = especialidade;
    }


    public int getMedID() {
        return medID;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico ( " +
                "medID=" + medID +
                ", nome='" + nome + '\'' +
                ", especialidade=" + especialidade +
                " )";
    }

}
