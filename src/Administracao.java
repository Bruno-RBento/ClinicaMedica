import Consultorio.GerirConsultorio;
import Ler.Ler;
import Medico.GerirMedico;
import Paciente.GerirPaciente;
import consulta.GerirConsulta;

class Administracao {
  public static void main(String[] args) {
    int op = 0;
    do {
      System.out.println("1 - Gerir pacientes");
      System.out.println("2 - Gerir medicos");
      System.out.println("3 - Gerir Consultorio");
      System.out.println("4 - Gerir Consulta");
      System.out.println("-1 - Sair");
      op = Ler.umInt();

      switch (op) {
      case 1:
        GerirPaciente.gerirPaciente();
        break;
      case 2:
        GerirMedico.gerirMedicos();
        break;
      case 3:
        GerirConsultorio.gerirConsultorio();
        break;
      case 4:
        GerirConsulta.gerirConsultas();
        break;
      }
    } while (op != -1);

  }
}
