import Ler.Ler;
import Medico.GerirMedico;
import Paciente.GerirPaciente;

class Administracao {
  public static void main(String[] args) {
    int op = 0;
    do {
      System.out.println("1 - Gerir pacientes");
      System.out.println("2 - Gerir medicos");
      System.out.println("-1 - Sair");
      op = Ler.umInt();

      switch (op) {
      case 1:
        GerirPaciente.gerirPaciente();
        break;
      case 2:
        GerirMedico.gerirMedicos();
        break;
      }
    } while (op != -1);
  }
}
