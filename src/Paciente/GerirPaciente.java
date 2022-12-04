package Paciente;

import Ler.Ler;
import Medico.Medico;

import java.io.*;
import java.util.ArrayList;


public class GerirPaciente {

    public static int menu() {
        int opcao;
        System.out.println("1 - Adicionar doente");
        System.out.println("2 - Remover doente");
        System.out.println("3 - Listar doentes");
        System.out.println("7 - Sair");
        System.out.println("Qual a sua opcao:");
        opcao = Ler.umInt();
        return opcao;
    }

    public static void main(String[] args) {
        int escolha;
// Lista que vai conter todos os livros;
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
// Ler ficheiro
        try {

            ObjectInputStream is = new ObjectInputStream( new FileInputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\paciente.dat"));
            pacientes = (ArrayList<Paciente>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        do{
            escolha = menu();
            switch (escolha){
                case 1: FuncPaciente.adicionarPaciente(pacientes);
                    break;
                case 2: FuncPaciente.removerPaciente(pacientes);
                    break;
                case 3: FuncPaciente.listarMedicos(pacientes);
                    break;
            }
        } while(escolha != 7);
    }

}
