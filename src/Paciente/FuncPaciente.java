package Paciente;

import Ler.Ler;
import Medico.Medico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FuncPaciente {

    public static void adicionarPaciente(ArrayList<Paciente> pacientes){
        System.out.println("Qual é o numero de utente de saude?");
        int numUtente = Ler.umInt();

        //verificar se ja existe esse medico

        for (int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).getnUtenteSaude() == numUtente){
                System.out.println("ja existe um medico com esse numero");
                return;
            }
        }

        //escrever nome
        System.out.println("Qual é o nome proprio? ");
        String nomeP = Ler.umaString();

        //escrever Apelido
        System.out.println("Qual é o Apelido? ");
        String nomeA = Ler.umaString();

        //escrever direcçao
        System.out.println("Qual é a Direcao? ");
        String direcao = Ler.umaString();

        //create paciente
        Paciente paciente = new Paciente(numUtente,nomeP,nomeA,direcao);

        //adicionar o paciente
        pacientes.add(paciente);

        // atualizar ficheiro
        saveTofile(pacientes);
    }

    public static void removerPaciente(ArrayList<Paciente> pacientes) {
        System.out.println("Qual é o numero do Utente?");
        int numUtente = Ler.umInt();

        for (int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).getnUtenteSaude() == numUtente){
                pacientes.remove(i);
                saveTofile(pacientes);
                return;
            }
        }
    }

    public static  void listarMedicos(ArrayList<Paciente> pacientes){
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(pacientes.get(i).toString());
        }
    }

    public static void saveTofile(ArrayList<Paciente> pacientes){
        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\paciente.dat"));
            // escrever o objeto livros no ficheiro
            os.writeObject(pacientes);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
