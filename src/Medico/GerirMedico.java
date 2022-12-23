package Medico;

import Ler.Ler;

import java.io.*;
import java.util.ArrayList;

public class GerirMedico {

    public static int menu() {
        int opcao;
        System.out.println("1 - Adicionar medico");
        System.out.println("2 - Remover medico");
        System.out.println("3 - Listar medicos");
        System.out.println("7 - Sair");
        System.out.println("Qual a sua opcao:");
        opcao = Ler.umInt();
        return opcao;
    }

    public static void gerirMedicos() {
        int escolha;
        // Lista que vai conter todos os livros;
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        // Ler ficheiro
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("../MemoryFile/medico.dat"));
            Medico.setUltimo(is.readInt());
            medicos = (ArrayList<Medico>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        do {
            escolha = menu();
            switch (escolha) {
            case 1:
                medicos.add(Medico.novoMedico());
                break;
            case 2:
                System.out.print("Qual é o numero do medico");
                int num = Ler.umInt();

                for (int i = 0; i < medicos.size(); i++) {
                    if (medicos.get(i).getId() == num) {
                        medicos.remove(i);
                        break;
                    }

                }
                break;
            case 3:
                System.out.println(medicos);
                break;
            }

            FuncMedico.saveTofile(medicos);
        } while (escolha != 7);
    }

}
