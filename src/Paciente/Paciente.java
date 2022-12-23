package Paciente;

import java.io.Serializable;

import Pessoa.Pessoa;

public class Paciente extends Pessoa implements Serializable {

  private static int ultimoId = 0;
  private int id;

  public static Paciente novoPaciente() {
    Pessoa p = novaPessoa();
    return new Paciente(p);
  }

  public Paciente(Pessoa p) {
    super(p.getNome(), p.getApelido(), p.getMorada(), p.getNascimento());
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

  public String toString() {
    return String.format("Paciente ( Id: %d, %s )", id, super.toString());
  }
}
