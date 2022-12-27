package consulta;

import Medico.Medico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FuncConsulta {


    public static void saveTofile(ArrayList<Consulta> consultas) {
        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\consultas.dat"));
            // escrever o objeto livros no ficheiro
            os.writeObject(consultas);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
