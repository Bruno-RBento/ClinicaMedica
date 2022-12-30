package Consultorio;

import java.io.*;
import java.util.ArrayList;

import Ler.Ler;

public class FuncConsultorio {

	public static Consultorio searchConsultorio(ArrayList<Consultorio> consultorios) {
		System.out.print("Num do consultorio: ");
		int num = Ler.umInt();
		System.out.println();
		for (int i = 0; i < consultorios.size(); i++) {
			if (consultorios.get(i).getNum() == num) {
				return consultorios.get(i);
			}
		}

		return null;
	}

	public static ArrayList<Consultorio> getConsultorios() {
		ArrayList<Consultorio> salas = new ArrayList<Consultorio>();

		try {
			//TODO
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("./src/MemoryFile/salas.dat"));
			//ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\salas.dat"));
			Consultorio.setUltimo(is.readInt());
			salas = (ArrayList<Consultorio>) is.readObject();
			is.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return salas;
	}

	public static void saveToFile(ArrayList<Consultorio> salas) {
		try {
			//TODO
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./src/MemoryFile/salas.dat"));
			//ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bruno\\IdeaProjects\\ClinicaMedica\\src\\MemoryFile\\salas.dat"));
			// escrever o objeto livros no ficheiro
			os.writeInt(Consultorio.getUltimo());
			os.writeObject(salas);
			os.flush(); // os dados são copiados de memória para o disco
			os.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
