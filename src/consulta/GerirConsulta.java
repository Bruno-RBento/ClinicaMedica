package consulta;

import Consultorio.FuncConsultorio;
import Consultorio.Consultorio;
import Ler.Ler;
import Medico.FuncMedico;
import Medico.Especialidade;
import Medico.Medico;
import Paciente.Paciente;
import Paciente.FuncPaciente;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;

public class GerirConsulta {

    private static ArrayList<Medico> medicos = new ArrayList<Medico>();
    private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    private static ArrayList<Consultorio> consultorios = new ArrayList<Consultorio>();
    private static ArrayList<Consulta> consultas = new ArrayList<Consulta>();

    private static Paciente pacienteF;


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


    public static int menuPaciente() {
        int opcao;
        System.out.println("O paciente tem esta inscrito na clinica");
        System.out.println("Qual a sua opcao:");
        System.out.println("1 -Sim");
        System.out.println("2 - Nao");
        System.out.println("7 - Sair");
        opcao = Ler.umInt();
        return opcao;
    }

    public static int menuMedico() {
        int opcao;
        System.out.println("1 - Criar uma consulta por especialidade");
        System.out.println("2 - Criar uma consulta usando o nome do medico");
        System.out.println("7 - Sair");
        System.out.println("Qual a sua opcao:");
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

    public static Consultorio menuConsultorio(){
        int opcao;
        do {
        System.out.println("Selecione o mes para fazer a marcacao");
        for (int i = 0; i < consultorios.size(); i++) {
            System.out.println( i + " Consultorio numero " + consultorios.get(i).getNum() + " " + consultorios.get(i).getArea());
        }
            opcao = Ler.umInt();

        }while (opcao < 0 || opcao > consultorios.size());
        return consultorios.get(opcao);
    }

    public static void gerirConsultas() {
        int escolha1;
        do {
            escolha1 = menuConsulta();

            switch (escolha1) {
                case 1:
                    selecionarPacientes();
                    break;
                case 2:
                    //Listar Consultas
                    System.out.println(consultas);
                    break;

                case 3:
                    System.out.print("Id da Consulta que se pretende remover: ");
                    int id = Ler.umInt();
                    boolean removed = false;
                    for (int i = 0; i < consultas.size(); i++) {
                        if (consultas.get(i).getId_Cons() == id) {
                            consultas.remove(i);
                            removed = true;
                        }
                    }
            }
        }while (escolha1 != 7);
            }

    public static void selecionarPacientes() {
        int escolha;
        int escolha1;
        Paciente novoPaciente = null;

        pacientes = FuncPaciente.getPacientes();
        medicos = FuncMedico.getMedico();
        consultorios = FuncConsultorio.getConsultorios();
        consultas = FuncConsulta.getConsulta();

        do {
            escolha1 = menuPaciente();

            switch (escolha1) {
                case 1:
                    if(FuncPaciente.searchPaciente(pacientes) != null){
                        Paciente pacienteF = FuncPaciente.searchPaciente(pacientes);
                        selecionarMedico(pacienteF);
                    }
                    break;
                case 2:
                    Paciente pacienteF = Paciente.novoPaciente();
                    pacientes.add(Paciente.novoPaciente());
                    FuncPaciente.saveTofile(pacientes);

                    selecionarMedico(pacienteF);
                    break;
            }
            }while (escolha1 != 7) ;
        }

public static void selecionarMedico(Paciente pacienteF){
    int num = menuMedico();
    Medico medicoSelecionado = null;
    Especialidade especialidade;
    do{
        switch (num) {
            case 1:
                ArrayList<Medico> medicosSelecionados = new ArrayList<Medico>();

                do {
                    System.out.println("Selecione uma especialidade");
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

                medicoSelecionado = medicos.get(i);
                    }
                }

                System.out.println("O Medico selecioando foi "+ medicoSelecionado.getNome());
                LocalDateTime localDateTime = FuncConsulta.menuDia(FuncConsulta.menuMes());

                System.out.println("-----------------------");
                //TODO Filtrar as Salas disponiveis
                Consultorio consultorio = menuConsultorio();
                consultas.add (new Consulta(localDateTime,consultorio,medicoSelecionado,pacienteF));
                FuncConsulta.saveTofile(consultas);

                FuncConsulta.menuPrincipal();
                break;
            case 2:
                System.out.println(medicos.toString());
                medicoSelecionado = FuncMedico.searchMedico(medicos);
                System.out.println("O Medico selecioando foi "+ medicoSelecionado.toString());
                LocalDateTime localDateTime2 = FuncConsulta.menuDia(FuncConsulta.menuMes());
                System.out.println("-----------------------");
                //TODO Filtrar as Salas disponiveis

                Consultorio consultorio2 = menuConsultorio();
                consultas.add (new Consulta(localDateTime2,consultorio2,medicoSelecionado,pacienteF));
                FuncConsulta.saveTofile(consultas);

                FuncConsulta.menuPrincipal();
                break;
        }
    }while (num != 7);
}


}
