package consulta;

import Consultorio.FuncConsultorio;
import Consultorio.Consultorio;
import Ler.Ler;
import Medico.FuncMedico;
import Medico.Medico;
import Medico.Especialidade;
import Paciente.Paciente;
import Paciente.FuncPaciente;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class GerirConsulta {

    public static int menuConsulta() {
        int opcao;
        System.out.println("#########################################################");
        System.out.println("|                    Menu Consulta                       |");
        System.out.println("|________________________________________________________|");
        System.out.println("|                    1 - Criar Consulta                  |");
        System.out.println("|                    2 - Listar as Consultas             |");
        System.out.println("|                    3 - Remover as Consulta             |");
        System.out.println("|                    7 - Sair                            |");
        System.out.println("#########################################################");
        System.out.println("                    Selecione uma opcao                  ");
        opcao = Ler.umInt();
        return opcao;
    }
    public static int menuEspecialidade(ArrayList<Medico> medicos){
        int opcao;
        do {
            for (int i = 0; i < medicos.size(); i++) {
                System.out.println(  i + " - " + medicos.get(i).getNome() + " " + medicos.get(i).getApelido() + " "  + medicos.get(i).getEspecialidade());
            }
            System.out.println("Qual a sua opcao");

            opcao = Ler.umInt();

        }while (opcao < 0 || opcao > medicos.size());//TODO change to not allow other numbers
        return medicos.get(opcao).getId();
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
                    System.out.println("__________________________________________________________");
                    System.out.println("                    Não encontrado Paciente              ");
                    //System.out.println("Não encontrado");
                    continue;
                }
                int escolha = FuncConsulta.menuMedico();
                Especialidade especialidade;
                ArrayList<Medico> medicosSelecionados = new ArrayList<Medico>();
                Medico m = null;
                if(escolha == 1){

                    do {
                        System.out.println("#########################################################");
                        System.out.println("|              Menu Selcione Especialidade               |");
                        System.out.println("|________________________________________________________|");
                        especialidade = Especialidade.getEspecialidade();
                        System.out.println(especialidade);

                        boolean bool = FuncMedico.searchEspecialidade(medicos, especialidade).isEmpty();
                        if (bool){
                            System.out.println("A especialidade selecionada nao tem medicos nesta clinica");
                        }

                    }while (FuncMedico.searchEspecialidade(medicos, especialidade).isEmpty());

                    medicosSelecionados = FuncMedico.searchEspecialidade(medicos,especialidade);
                    System.out.println(medicosSelecionados);

                    int idMedico = menuEspecialidade(medicosSelecionados);


                    for (int i = 0; i <medicos.size(); i++) {
                        if(medicos.get(i).getId() == idMedico){

                            m = medicos.get(i);
                        }
                    }



                }else{
                    m = FuncMedico.searchMedico(medicos);
                if (m == null) {
                    System.out.println("__________________________________________________________");
                    System.out.println("                    Não encontrado Medico                 ");
                    continue;
                }
                }

                Consultorio rio = FuncConsultorio.searchConsultorio(consultorios);
                if (rio == null) {
                    System.out.println("__________________________________________________________");
                    System.out.println("                    Não encontrado Consultorio            ");
                    continue;
                }

                LocalDateTime data;
                while (true) {
                   // TODO change this
                    System.out.println("__________________________________________________________");
                    System.out.println("                    Horario para a consulta!            ");
                    //System.out.println("                    Não encontrado Consultorio            ");
                    //System.out.print("Horario para a consulta!");
                    System.out.print("Dia: ");
                    int dd = Ler.umInt();

                    System.out.print("\nMes: ");
                    int mm = Ler.umInt();
                    Month month;
                    try {
                        month = Month.of(mm);
                    } catch (DateTimeException e) {
                        System.out.println("__________________________________________________________");
                        System.out.println("                    Mes invalido!                 ");
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
                        System.out.println("__________________________________________________________");
                        System.out.println("                    Data invalida!                 ");
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
