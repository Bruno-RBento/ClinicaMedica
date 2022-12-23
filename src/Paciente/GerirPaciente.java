package Paciente;

import Ler.Ler;
import java.io.*;
import java.util.ArrayList;
import Pessoa.Pessoa;

public class GerirPaciente {

  public static int menu() {
    int opcao;
    System.out.println("1 - Adicionar paciente");
    System.out.println("2 - Remover paciente");
    System.out.println("3 - Listar pacientes");
    System.out.println("4 - Encontrar pacientes por nome");
    System.out.println("7 - Voltar");
    System.out.println("Qual a sua opcao:");
    opcao = Ler.umInt();
    return opcao;
  }

  public static void gerirPaciente() {
    int op;
    // Lista que vai conter todos os livros;
    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    // Ler ficheiro
    try {

      ObjectInputStream is = new ObjectInputStream(new FileInputStream("../MemoryFile/paciente.dat"));
      Paciente.setUltimo(is.readInt());
      pacientes = (ArrayList<Paciente>) is.readObject();
      is.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    do {
      op = menu();
      switch (op) {
      case 1:
        pacientes.add(Paciente.novoPaciente());
        break;
      case 2:
        System.out.print("Id do utilizador que se pretende remover: ");
        int id = Ler.umInt();
        boolean removed = false;
        for (int i = 0; i < pacientes.size(); i++) {
          if (pacientes.get(i).getId() == id) {
            pacientes.remove(i);
            removed = true;
            break;
          }
        }

        if (removed) {
          System.out.println("Foi removido com sucesso!");
        } else {
          System.out.println("Nao encontrou o utilizador!");
        }

        break;
      case 3:
        System.out.println(pacientes);
        break;
      case 4:
        System.out.print("Encontrar por Nome ou Apelido: ");
        String nap = Ler.umaString();
        ArrayList<Paciente> pf = new ArrayList<Paciente>();
        for (int i = 0; i < pacientes.size(); i++) {
          if (pacientes.get(i).getNome().contains(nap) || pacientes.get(i).getApelido().contains(nap))
            pf.add(pacientes.get(i));
        }

        if (pf.size() > 0) {
          System.out.println(pf);
        } else {
          System.out.println("Nao foram encontrados resultados!");
        }
        break;
      default:
        break;
      }

      FuncPaciente.saveTofile(pacientes);
    } while (op != 7);
  }
}
