package Medico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FuncMedico {
    public static void saveTofile(ArrayList<Medico> medicos) {
        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("../MemoryFile/medico.dat"));
            // escrever o objeto livros no ficheiro
            os.writeInt(Medico.getUltimo());
            os.writeObject(medicos);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
