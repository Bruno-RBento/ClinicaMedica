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
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("./MemoryFile/salas.dat"));
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
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./MemoryFile/salas.dat"));
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
