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
    public static void main(String[] args) {
        int escolha;
// Lista que vai conter todos os livros;
        ArrayList<Medico> medicos = new ArrayList<Medico>();
// Ler ficheiro
        try {

            ObjectInputStream is = new ObjectInputStream( new FileInputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\medico.dat"));
            medicos = (ArrayList<Medico>) is.readObject();
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
                case 1: FuncMedico.adicionarMedico(medicos);
                    break;
                case 2: FuncMedico.removerMedico(medicos);
                    break;
                case 3: FuncMedico.listarMedicos(medicos);
                    break;
            }
        } while(escolha != 7);
    }

    }

