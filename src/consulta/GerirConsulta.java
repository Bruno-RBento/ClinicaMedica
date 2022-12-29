package consulta;

import Consultorio.FuncConsultorio;
import Consultorio.Consultorio;
import Ler.Ler;
import Medico.FuncMedico;
import Medico.Especialidade;
import Medico.Medico;
import Paciente.Paciente;
import Paciente.FuncPaciente;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerirConsulta {

    private static ArrayList<Medico> medicos = new ArrayList<Medico>();
    private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    private static ArrayList<Consultorio> consultorios = new ArrayList<Consultorio>();
    private static ArrayList<Consulta> consultas = new ArrayList<Consulta>();

    private static Paciente pacienteF;

<<<<<<< HEAD
=======

    public static int menuConsulta() {
        int opcao;
        System.out.println("1 - Criar Consulta");
        System.out.println("2 - Listar as Consultas");
        System.out.println("3 - Remover as Consultas");
        System.out.println("7 - Sair ");
        System.out.println("Selecione uma opcao");
        opcao = Ler.umInt();
        return opcao;
    }


>>>>>>> afef987b04c5ca8da0cb56b92dc4facab62f1fd9
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

    public static int menuEspecialidade(ArrayList<Medico> medicos) {
        int opcao;
        do {
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + " - " + medicos.get(i).getNome() + " " + medicos.get(i).getApelido() + " "
                    + medicos.get(i).getEspecialidade());
        }
        System.out.println("Qual a sua opcao");

            opcao = Ler.umInt();

<<<<<<< HEAD
        } while (opcao < 0 && opcao > medicos.size());
=======
        }while (opcao < 0 || opcao > medicos.size());//TODO change to not allow other numbers
>>>>>>> afef987b04c5ca8da0cb56b92dc4facab62f1fd9
        return medicos.get(opcao).getId();
    }

    public static int menuConsultorio() {
        int opcao;
        do {
        System.out.println("Selecione o mes para fazer a marcacao");
        for (int i = 0; i < consultorios.size(); i++) {
            System.out.println(
                    i + " Consultorio numero " + consultorios.get(i).getNum() + " " + consultorios.get(i).getArea());
        }
            opcao = Ler.umInt();

<<<<<<< HEAD
        } while (opcao < 0 && opcao > consultorios.size());
=======
        }while (opcao < 0 || opcao > consultorios.size());
>>>>>>> afef987b04c5ca8da0cb56b92dc4facab62f1fd9
        return consultorios.get(opcao).getNum();
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

                        //TODO Remover consultas

            }
            //System.out.println(novoPaciente.toString());
        }while (escolha1 != 7) ;
    }





    public static void selecionarPacientes() {
        int escolha;
        int escolha1;
        Paciente novoPaciente = null;

        pacientes = FuncPaciente.getPacientes();
        medicos = FuncMedico.getMedico();
        consultorios = FuncConsultorio.getConsultorios();

        do {
            escolha1 = menuPaciente();

            switch (escolha1) {
            case 1:
                if (FuncPaciente.searchPaciente(pacientes) != null) {
                    selecionarMedico();
                }
                break;
            case 2:
                pacientes.add(Paciente.novoPaciente());
                FuncPaciente.saveTofile(pacientes);

<<<<<<< HEAD
                selecionarMedico();
                break;
            }
            // System.out.println(novoPaciente.toString());
        } while (escolha1 != 7);
    }

    public static void selecionarMedico() {
        int num = menuMedico();
        Medico medicoSelecionado = null;
        do {
            switch (num) {
            case 1:
                ArrayList<Medico> medicosSelecionados = new ArrayList<Medico>();
                Especialidade especialidade = Especialidade.getEspecialidade();
                medicosSelecionados = FuncMedico.searchEspecialidade(medicos, especialidade);
=======
public static void selecionarMedico(){
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
                        System.out.println("A especialidade selecionada nao tem medicos nestq clinica");
                    }

                }while (FuncMedico.searchEspecialidade(medicos, especialidade).isEmpty());

                medicosSelecionados = FuncMedico.searchEspecialidade(medicos,especialidade);
>>>>>>> afef987b04c5ca8da0cb56b92dc4facab62f1fd9
                System.out.println(medicosSelecionados);

                int idMedico = menuEspecialidade(medicosSelecionados);

                for (int i = 0; i < medicos.size(); i++) {
                    if (medicos.get(i).getId() == idMedico) {

                        medicoSelecionado = medicos.get(i);
                    }
                }

                System.out.println("O Medico selecioando foi " + medicoSelecionado.getNome());
                LocalDateTime localDateTime = FuncConsulta.menuDia(FuncConsulta.menuMes());
<<<<<<< HEAD
                FuncConsulta.menuHora();
                // TODO Filtrar as Salas disponiveis
=======

                System.out.println("-----------------------");
                //TODO Filtrar as Salas disponiveis
>>>>>>> afef987b04c5ca8da0cb56b92dc4facab62f1fd9
                menuConsultorio();
                break;
            case 2:
                System.out.println(medicos.toString());
                medicoSelecionado = FuncMedico.searchMedico(medicos);
<<<<<<< HEAD
                System.out.println("O Medico selecioando foi " + medicoSelecionado.toString());
                FuncConsulta.menuHora();
                // TODO Filtrar as Salas disponiveis
=======
                System.out.println("O Medico selecioando foi "+ medicoSelecionado.toString());
                LocalDateTime localDateTime2 = FuncConsulta.menuDia(FuncConsulta.menuMes());
                System.out.println("-----------------------");
                //TODO Filtrar as Salas disponiveis
>>>>>>> afef987b04c5ca8da0cb56b92dc4facab62f1fd9
                menuConsultorio();
                break;
            }
        } while (num != 7);
    }

}
