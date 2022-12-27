package Paciente;

import Ler.Ler;

import java.io.*;
import java.util.ArrayList;

public class FuncPaciente {

  //todo fix this
  public static Paciente searchPaciente(ArrayList<Paciente> pacientes) {

    System.out.print("Encontrar Paciente por Nome ou Apelido: ");
    String nap = Ler.umaString();
    for (int i = 0; i < pacientes.size(); i++) {
      if (pacientes.get(i).getNome().contains(nap) || pacientes.get(i).getApelido().contains(nap)) {
        pacientes.get(i);
        System.out.println(pacientes.get(i).getNome() + " " + pacientes.get(i).getNome());
        return pacientes.get(i);
      }
    }
      System.out.println("Nao foram encontrados resultados!");
    return null;
  }

  public static ArrayList<Paciente> getPacientes(){
    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    // Ler ficheiro
    try {

      ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\paciente.dat"));
      Paciente.setUltimo(is.readInt());
      pacientes = (ArrayList<Paciente>) is.readObject();
      is.close();
      System.out.println(pacientes);
      return pacientes;
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }


  public static void saveTofile(ArrayList<Paciente> pacientes) {
    // atualizar ficheiro
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\paciente.dat"));
      System.out.println("save to file");
      // escrever o objeto livros no ficheiro
      os.writeInt(Paciente.getUltimo());
      os.writeObject(pacientes);
      os.flush(); // os dados são copiados de memória para o disco
      os.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
