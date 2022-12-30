package Medico;

import Ler.Ler;

import java.io.*;
import java.util.ArrayList;

public class FuncMedico {

    public static ArrayList<Medico> getMedico() {
        // Lista que vai conter todos os livros;
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        // Ler ficheiro
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("./MemoryFile/medico.dat"));
            Medico.setUltimo(is.readInt());
            medicos = (ArrayList<Medico>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return medicos;
    }

    public static Medico searchMedico(ArrayList<Medico> medicos) {
        System.out.print("Encontrar Medico por Nome ou Apelido: ");
        String text = Ler.umaString();

        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getNome().contains(text) || medicos.get(i).getApelido().contains(text)) {
                System.out.print("Encontramos este medico: ");
                System.out.println(medicos.get(i));
                return medicos.get(i);
            }
        }
        System.out.println("Nao foram encontrados resultados!");
        return null;
    }

    public static ArrayList<Medico> searchEspecialidade(ArrayList<Medico> medicos, Especialidade especialidade) {
        ArrayList<Medico> medicosL = new ArrayList<Medico>();

        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getEspecialidade() == especialidade) {
                medicosL.add(medicos.get(i));
            }

        }
        return medicosL;
    }

    public static void saveTofile(ArrayList<Medico> medicos) {
        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./MemoryFile/medico.dat"));
            // escrever o objeto livros no ficheiro
            os.writeInt(Medico.getUltimo());
            os.writeObject(medicos);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
