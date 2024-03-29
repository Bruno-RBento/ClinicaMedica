package Medico;

import Ler.Ler;

import java.util.ArrayList;

public class GerirMedico {

    public static int menu() {
        int opcao;
        System.out.println("#########################################################");
        System.out.println("|                    Menu Medico                         |");
        System.out.println("|________________________________________________________|");
        System.out.println("|                    1 - Adicionar medico                |");
        System.out.println("|                    2 - Remover medico                  |");
        System.out.println("|                    3 - Listar medicos                  |");
        System.out.println("|                    4 - Encontrar medico por nome       |");
        System.out.println("|                    7 - Sair                            |");
        System.out.println("#########################################################");
        System.out.println("                    Selecione uma opcao                  ");
        opcao = Ler.umInt();
        return opcao;
    }

    public static void gerirMedicos() {
        int escolha;
        // Lista que vai conter todos os livros;
        ArrayList<Medico> medicos = FuncMedico.getMedico();

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

            case 4:
                FuncMedico.searchMedico(medicos);
                break;
            }
            FuncMedico.saveTofile(medicos);
        } while (escolha != 7);
    }

}
