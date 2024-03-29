package consulta;

import Consultorio.GerirConsultorio;
import Ler.Ler;
import Medico.GerirMedico;
import Paciente.GerirPaciente;

import java.io.*;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;

public class FuncConsulta {

    public static ArrayList<Consulta> getConsulta() {
        // Lista que vai conter todos os livros;
        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        // Ler ficheiro
        try {
            //TODO
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("./src/MemoryFile/consultas.dat"));
            //ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\consultas.dat"));
            Consulta.setUltimo(is.readInt());
            consulta = (ArrayList<Consulta>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return consulta;
    }

    public static void saveTofile(ArrayList<Consulta> consultas) {
        // atualizar ficheiro
        try {
            //todo
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./src/MemoryFile/consultas.dat"));
            //ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\consultas.dat"));
            // escrever o objeto livros no ficheiro
            os.writeInt(Consulta.getUltimo());
            os.writeObject(consultas);
            os.flush(); // os dados são copiados de memória para o disco
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int menuMedico() {
        int opcao;
        do {
        System.out.println("#########################################################");
        System.out.println("|                    Selecao do medico                   |");
        System.out.println("|________________________________________________________|");
        System.out.println("|         1 - Criar uma consulta por especialidade       |");
        System.out.println("|         2 - Criar uma consulta usando o nome do medico |");
        System.out.println("#########################################################");
        System.out.println("                    Selecione uma opcao                  ");
        opcao = Ler.umInt();
        }while (opcao != 1 && opcao != 2);//TODO change to not allow other numbers
        return opcao;
    }

    public static int menuMes() {

        int opcao;
        LocalDateTime dateTime = LocalDateTime.now();

        do {

            System.out.println("Selecione o mes para fazer a marcacao");
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " - " + dateTime.plusMonths(i).getMonth());
            }

            opcao = Ler.umInt();

        } while (opcao < 0 || opcao >= 5);
        return dateTime.plusMonths(opcao).getMonthValue();
    }

    public static LocalDateTime menuDia(int mes) {

        int start = 1;
        int end = 0;
        int year = 0;
        int opcao;

        LocalDateTime dateTime = LocalDateTime.now();
        int mesAtual = dateTime.getMonthValue();
        YearMonth mesC = YearMonth.of(dateTime.getYear(), dateTime.getMonth());
        int daysInMonth = mesC.lengthOfMonth();
        if (mesAtual == mes) {
            int day = dateTime.getDayOfMonth();
            System.out.println("Selecione o dia para fazer a marcacao");

            start = day;
            end = daysInMonth;
            year = dateTime.getYear();
            for (int i = day; i <= daysInMonth; i++) {
                LocalDateTime date = LocalDateTime.of(year, dateTime.getMonth(), i, 0, 0, 0);
                int diaSemana = date.getDayOfWeek().getValue();
                if (diaSemana != 6 && diaSemana != 7) {

                    System.out.println(i + " " + dateTime.getMonth());
                }
            }
        } else {

            start = 1;
            end = daysInMonth;

            System.out.println("Selecione o dia para fazer a marcacao");
            LocalDateTime dateTimeM = LocalDateTime.of(2023, mes, 1, 0, 0, 0);
            year = dateTimeM.getYear();
            YearMonth mes2 = YearMonth.of(dateTimeM.getYear(), dateTimeM.getMonth());
            int daysInThisM = mes2.lengthOfMonth();
            for (int i = 1; i <= daysInThisM; i++) {
                LocalDateTime nextdateTime = LocalDateTime.of(2023, mes, i, 0, 0, 0);
                int diaSemana = nextdateTime.getDayOfWeek().getValue();

                if (diaSemana != 6 && diaSemana != 7) {
                    // System.out.println("dia da semana " + diaSemana);
                    System.out.println(i + " " + nextdateTime.getMonth());

                }
                ;
            }
        }
        do {
            opcao = Ler.umInt();
        } while (opcao <= start && opcao >= end);
        int hora = menuHora();
        return LocalDateTime.of(year, mes, opcao, hora, 0, 0);
    }

    public static int menuHora() {
        // Todo filtrar pela disponibilidade do medico criar uma classe nas marcacoes
        // basta um for
        int opcao;

        do {
            System.out.println("Selecione o hora para fazer a marcacao");

            for (int i = 8; i <= 17; i++) {
                // if()filtrar pela disponibilidade do medico
                System.out.println(i + " horas");
            }
            opcao = Ler.umInt();
        } while (opcao < 8 || opcao >= 17);
        return opcao;
    }

}
