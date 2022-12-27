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
        return opcao;
    }

        public static void menuHorario(){
        //Todo provavelmente adicionar o mes seguinte para tentar fazer a marcacao
        int opcao;
            LocalDateTime dateTime = LocalDateTime.now();
            int day = dateTime.getDayOfMonth();
            YearMonth monthday = YearMonth.of(dateTime.getYear(), dateTime.getMonth());
            int daysInMonth = monthday.lengthOfMonth();

            System.out.println("Selecione o dia para fazer a marcacao");

            for (int i = day + 1; i < daysInMonth; i++) {
                int dayofWeek = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), i, 00, 00, 00).getDayOfWeek().getValue();
                if (dayofWeek != 5 && dayofWeek != 6) ;

                System.out.println(i + " " + dateTime.getMonth());
            }
            do {
                opcao = Ler.umInt();
        }while (opcao != -1);
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
                medicoSelecionado = medicos.get(menuEspecialidade(medicosSelecionados));
                System.out.println("O Medico selecioando foi "+ medicoSelecionado.toString());
                //TODO mostrar menu de escolha do horario.
                menuHorario();
                break;
            case 2:
                System.out.println(medicos.toString());
                  medicoSelecionado = FuncMedico.searchMedico(medicos);
                  System.out.println("O Medico selecioando foi "+ medicoSelecionado.toString());
                  //TODO mostrar menu de escolha do horario.
                menuHorario();
                break;
        }
    }while (num != 7);
}


}
