package consulta;

import consultorio.Consultorio;
import medico.Medico;
import paciente.Paciente;

public class Consulta {
	private static long ult_id = 000000001;
	private long id_cons;
	private int hora_inicio;
	private int hora_fim;
	private Consultorio cons;
	private Medico medico;
	private Paciente paciente;
	
	public Consulta() {
		ult_id++;
		this.id_cons = ult_id;
		this.hora_inicio = 0;
		this.hora_fim = 0;
	}
	
	public Consulta(int h_i, int h_f, Consultorio cons, Medico med, Paciente p) {
		ult_id++;
		this.id_cons = ult_id;
		this.hora_inicio = h_i;
		this.hora_fim = h_f;
		this.cons = cons;
		this.medico = med;
		this.paciente = p;
	}
	
	public long getId_Cons() {
		return this.id_cons = ult_id;
	}

	public int getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public int getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(int hora_fim) {
		this.hora_fim = hora_fim;
	}

	public Consultorio getCons() {
		return cons;
	}

	public void setCons(Consultorio cons) {
		this.cons = cons;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Consulta:"
				+ "\nID: " + id_cons
				+ "\nHora de Inicio: " + hora_inicio + " até " + hora_fim
				+ "\nConsultório: " + cons 
				+ "\nMedico: " + medico
				+ "\nPaciente: " + paciente + "\n";
	}
	
	
	
}
