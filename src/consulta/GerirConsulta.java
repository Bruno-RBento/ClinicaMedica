package consulta;

import Consultorio.FuncConsultorio;
import Consultorio.Consultorio;
import Ler.Ler;
import Medico.FuncMedico;
import Medico.Medico;
import Paciente.Paciente;
import Paciente.FuncPaciente;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class GerirConsulta {

    public static int menuConsulta() {
        int opcao;
        System.out.println("1 - Criar Consulta");
        System.out.println("2 - Listar as Consultas");
        System.out.println("3 - Remover as Consulta");
        System.out.println("7 - Sair ");
        System.out.println("Selecione uma opcao");
        opcao = Ler.umInt();
        return opcao;
    }

    public static void gerirConsultas() {
        ArrayList<Medico> medicos = FuncMedico.getMedico();
        ArrayList<Paciente> pacientes = FuncPaciente.getPacientes();
        ArrayList<Consultorio> consultorios = FuncConsultorio.getConsultorios();
        ArrayList<Consulta> consultas = FuncConsulta.getConsulta();

        int escolha1;
        do {
            escolha1 = menuConsulta();

            switch (escolha1) {
            case 1:
                // Criar consulta
                Paciente p = FuncPaciente.searchPaciente(pacientes);
                if (p == null) {
                    System.out.println("Não encontrado");
                    continue;
                }

                Medico m = FuncMedico.searchMedico(medicos);
                if (m == null) {
                    System.out.println("Não encontrado");
                    continue;
                }

                Consultorio rio = FuncConsultorio.searchConsultorio(consultorios);
                if (rio == null) {
                    System.out.println("Nao encontrado");
                    continue;
                }

                LocalDateTime data;
                while (true) {
                    System.out.print("Horario para a consulta!");
                    System.out.print("Dia: ");
                    int dd = Ler.umInt();

                    System.out.print("\nMes: ");
                    int mm = Ler.umInt();
                    Month month;
                    try {
                        month = Month.of(mm);
                    } catch (DateTimeException e) {
                        System.out.println("Mes invalido");
                        continue;
                    }
                    System.out.print("\nAno: ");
                    int yyyy = Ler.umInt();
                    System.out.print("\nHora: ");
                    int hora = Ler.umInt();
                    System.out.print("\nMinutos: ");
                    int minuto = Ler.umInt();

                    try {
                        data = LocalDateTime.of(yyyy, month, dd, hora, minuto);
                        break;
                    } catch (DateTimeException e) {
                        System.out.println("Data invalida!");
                    }
                }

                consultas.add(new Consulta(data, rio, m, p));
                break;
            case 2:
                // Listar Consultas
                System.out.println(consultas);
                break;

            case 3:
                System.out.print("Id da Consulta que se pretende remover: ");
                int id = Ler.umInt();
                boolean removed = false;
                for (int i = 0; i < consultas.size(); i++) {
                    if (consultas.get(i).getId() == id) {
                        consultas.remove(i);
                        removed = true;
                    }
                }

                System.out.println(removed ? "Foi removido" : "Nao foi encontrado");
            }

            FuncConsulta.saveTofile(consultas);
        } while (escolha1 != 7);
    }

}
