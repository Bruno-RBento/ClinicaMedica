package Medico;

import Ler.Ler;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FuncMedico {

    public static void adicionarMedico(ArrayList<Medico> medicos){
        System.out.println("Qual é o numero de identificacao do medico?");
        int num = Ler.umInt();

        //verificar se ja existe esse medico

        for (int i = 0; i < medicos.size(); i++) {
            if(medicos.get(i).getMedID()== num){
                System.out.println("ja existe um medico com esse numero");
                return;
            }
        }

        //escrever nome
        System.out.println("Qual é o nome do medico? ");
        String nome = Ler.umaString();


        //TODO dont let other numbers
        int opcao;
        System.out.println("1 - CARDIOLOGIA");
        System.out.println("2 - ANESTESIOLOGIA");
        System.out.println("3 - DERMATOLOGIA");
        System.out.println("4 - ENDOCRINOLOGIA");
        System.out.println("5 - GASTROENTEROLOGIA");
        System.out.println("6 - PNEUMOLOGIA");
        System.out.println("7 - OBSTERICIA");
        System.out.println("8 - PSIQUIATRIA");
        System.out.println("9 - CIRUGIA_GERAL");
        System.out.println("10 - MEDICINA_TRABALHO");
        System.out.println("11 - MEDICINA_DESPORTIVA");
        System.out.println("12 - MEDICINA_FISICA_E_REABILITCAO");
        System.out.println("13 - MEDICINA_GERAL_E_FAMILIAR");
        System.out.println("14 - Sair");
        System.out.println("Qual a sua opcao:");
        opcao = Ler.umInt();
        Especialidade especialidade;

            switch (opcao){
                case 1: especialidade =Especialidade.CARDIOLOGIA;
                    break;
                case 2: especialidade =Especialidade.ANESTESIOLOGIA;
                    break;
                case 3: especialidade =Especialidade.DERMATOLOGIA;
                    break;
                case 4: especialidade =Especialidade.ENDOCRINOLOGIA;
                    break;
                case 5: especialidade =Especialidade.GASTROENTEROLOGIA;
                    break;
                case 6: especialidade =Especialidade.PNEUMOLOGIA;
                    break;
                case 7: especialidade =Especialidade.OBSTERICIA;
                    break;
                case 8: especialidade =Especialidade.PSIQUIATRIA;
                    break;
                case 9: especialidade =Especialidade.CIRUGIA_GERAL;
                    break;
                case 10: especialidade =Especialidade.MEDICINA_TRABALHO;
                    break;
                case 11: especialidade =Especialidade.MEDICINA_DESPORTIVA;
                    break;
                case 12: especialidade =Especialidade.MEDICINA_FISICA_E_REABILITCAO;
                    break;
                case 13: especialidade =Especialidade.MEDICINA_GERAL_E_FAMILIAR;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opcao);
            }



        Medico medico = new Medico(num,nome, especialidade);
        medicos.add(medico);

        // atualizar ficheiro
        saveTofile(medicos);
    }

    public static void removerMedico(ArrayList<Medico> medicos){

        System.out.println("Qual é o numero do medico");
        int num = Ler.umInt();

        for (int i = 0; i < medicos.size(); i++) {
            if(medicos.get(i).getMedID()== num){
                medicos.remove(i);
                saveTofile(medicos);
                return;
            }

        }
    }

    public static  void listarMedicos(ArrayList<Medico> medicos){
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(medicos.get(i).toString());
        }
    }

    public static void saveTofile(ArrayList<Medico> medicos){
        // atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\medico.dat"));
        // escrever o objeto livros no ficheiro
            os.writeObject(medicos);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
