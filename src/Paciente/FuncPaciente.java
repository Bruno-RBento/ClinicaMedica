package Paciente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FuncPaciente {
  public static void saveTofile(ArrayList<Paciente> pacientes) {
    // atualizar ficheiro
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./MemoryFile/paciente.dat"));
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
