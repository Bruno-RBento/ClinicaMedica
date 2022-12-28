package consulta;

import Consultorio.Consultorio;
import Medico.Medico;
import Paciente.Paciente;

import java.io.Serializable;

public class Consulta implements Serializable {
	private static int ultimoId = 0;
	private static long ult_id = 000000001;
	private long id_cons;
	//TODO CHANGE DATATYPE
	private int hora_inicio;
	private Consultorio cons;
	private Medico medico;
	private Paciente paciente;
	
	public Consulta() {
		ult_id++;
		this.id_cons = ult_id;
		this.hora_inicio = 0;

	}
	
	public Consulta(int h_i, Consultorio cons, Medico med, Paciente p) {
		ult_id++;
		this.id_cons = ult_id;
		this.hora_inicio = h_i;

		this.cons = cons;
		this.medico = med;
		this.paciente = p;
		ultimoId++;
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

	public static int getUltimo() {
		return ultimoId;
	}

	public static void setUltimo(int i) {
		ultimoId = i;
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
				+ "\nHora de Inicio: " + hora_inicio
				+ "\nConsultório: " + cons
				+ "\nMedico: " + medico
				+ "\nPaciente: " + paciente + "\n";
	}
	
	
	
}
