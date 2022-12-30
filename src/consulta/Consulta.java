package consulta;

import Consultorio.Consultorio;
import Medico.Medico;
import Paciente.Paciente;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Consulta implements Serializable {
	private static int ultimoId = 0;
	private int id;
	private LocalDateTime hora_inicio;
	private Consultorio cons;
	private Medico medico;
	private Paciente paciente;

	public Consulta(LocalDateTime h_i, Consultorio cons, Medico med, Paciente p) {
		ultimoId++;
		this.id = ultimoId;
		this.hora_inicio = h_i;

		this.cons = cons;
		this.medico = med;
		this.paciente = p;
	}

	public int getId() {
		return this.id;
	}

	public static int getUltimo() {
		return ultimoId;
	}

	public static void setUltimo(int i) {
		ultimoId = i;
	}

	public Consultorio getConsultorio() {
		return cons;
	}

	public void setConsultorio(Consultorio cons) {
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
		return "Consulta:" + "\n n do consultorio: " + id + "\nHora de Inicio: " + hora_inicio + "\nMedico: " + medico
				+ "\nPaciente: " + paciente + "\n";
	}

	public LocalDateTime getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(LocalDateTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Object clone() {
		Consulta copia = new Consulta(this.hora_inicio, this.cons, this.medico, this.paciente);
		return copia;
	}
}
