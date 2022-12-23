package Medico;

import java.io.Serializable;

import Pessoa.Pessoa;

public class Medico extends Pessoa implements Serializable {
    private static int ultimoId = 0;
    private int id;
    private Especialidade especialidade;

    public static Medico novoMedico() {
        Pessoa p = Pessoa.novaPessoa();
        return new Medico(p, Especialidade.getEspecialidade());
    }

    public Medico(Pessoa p, Especialidade especialidade) {
        super(p.getNome(), p.getApelido(), p.getMorada(), p.getNascimento());
        this.especialidade = especialidade;
        this.id = ultimoId + 1;
        ultimoId++;
    }

    public static int getUltimo() {
        return ultimoId;
    }

    public static void setUltimo(int i) {
        ultimoId = i;
    }

    public int getId() {
        return id;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico ( " + "id=" + id + ", " + super.toString() + ", especialidade=" + especialidade + " )";
    }

}
