package consulta;

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

        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(  i + " - " + medicos.get(i).getNome() + " " + medicos.get(i).getApelido() + " "  + medicos.get(i).getEspecialidade());
        }
        System.out.println("Qual a sua opcao");
        do {
            opcao = Ler.umInt();

        }while (opcao <0 && opcao > medicos.size());
        System.out.println("opcao" + opcao);
        System.out.println(medicos);
        System.out.println(medicos.get(opcao).getNome());
        System.out.println(medicos.get(opcao).getId());
        return medicos.get(opcao).getId();
    }


    public static void gerirConsultas() {
        int escolha;
        int escolha1;
        Paciente novoPaciente = null;

        pacientes = FuncPaciente.getPacientes();
medicos = FuncMedico.getMedico();

        do {
            escolha1 = menuPaciente();

            switch (escolha1) {
                case 1:
                    if(FuncPaciente.searchPaciente(pacientes) != null){
                        selecionarMedico();
                    }
                    break;
                case 2:
                    pacientes.add(Paciente.novoPaciente());
                    FuncPaciente.saveTofile(pacientes);

                    selecionarMedico();
                    break;
            }
            //System.out.println(novoPaciente.toString());
            }while (escolha1 != 7) ;
        }

public static void selecionarMedico(){
    int num = menuMedico();
    Medico medicoSelecionado = null;
    do{

        switch (num) {
            case 1:
                ArrayList<Medico> medicosSelecionados = new ArrayList<Medico>();
                Especialidade especialidade = Especialidade.getEspecialidade();
                medicosSelecionados = FuncMedico.searchEspecialidade(medicos,especialidade);
                System.out.println(medicosSelecionados);

                int idMedico = menuEspecialidade(medicosSelecionados);
                System.out.println("id medico " + idMedico + " " + medicos.get(idMedico).getNome());
                System.out.println("-------------");
                System.out.println(medicos);
                medicoSelecionado = medicos.get(idMedico);

                System.out.println("O Medico selecioando foi "+ medicoSelecionado.getNome());
                LocalDateTime localDateTime = FuncConsulta.menuDia(FuncConsulta.menuMes());
                FuncConsulta.menuHora();
                //TODO Filtrar as Salas disponiveis
                break;
            case 2:
                System.out.println(medicos.toString());
                medicoSelecionado = FuncMedico.searchMedico(medicos);
                System.out.println("O Medico selecioando foi "+ medicoSelecionado.toString());
                FuncConsulta.menuHora();
                //TODO Filtrar as Salas disponiveis
                break;
        }
    }while (num != 7);
}


}
