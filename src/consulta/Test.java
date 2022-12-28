package consulta;

import Consultorio.Consultorio;
import Medico.Medico;
import Medico.Especialidade;
import Paciente.Paciente;
import Pessoa.Pessoa;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Consulta> consulta = FuncConsulta.getConsulta();

        Consultorio consultorio = new Consultorio(10,10);
        LocalDateTime dateTime = LocalDateTime.now();
        Pessoa pessoa = new Pessoa("aaa","bbbb","sdasdasdasd", dateTime);
        Medico medico = new Medico(pessoa,Especialidade.ANESTESIOLOGIA);
        Paciente paciente = new Paciente(pessoa);
        LocalDateTime data = LocalDateTime.now();
        Consulta consultaT = new Consulta(data,consultorio,medico,paciente);
        consulta.add(consultaT);
        FuncConsulta.saveTofile(consulta);
    }
}
