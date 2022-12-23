package consultorio;

import java.io.*;
import java.util.ArrayList;
import medico.Especialidade;
import ler.Ler;

public class FuncConsultorio {
	private static File file1 = new File("...MemoryFile\\salas.dat"); 
	
	public static void adicionarConsultorio(ArrayList<Consultorio> salas) {
		System.out.println("Qual a especialidade do Consultorio?");
		Especialidade esp = Especialidade.getEspecialidade(); //escolhe uma opção da lista de especialidades
		System.out.println("Qual as medidas do consultorio no formato - (width height)");
		String medidas = Ler.umaString();
		String lados[] = medidas.split(" ");
		
		Consultorio c = new Consultorio(esp, Integer.parseInt(lados[0]), Integer.parseInt(lados[1]));
		salas.add(c);
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file1));
			os.writeInt(Consultorio.getUltNumero());
			os.writeObject(salas);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getSala(ArrayList<Consultorio> salas) {
		System.out.println("Qual o número do Consultorio?");
		int num = Ler.umInt();
		Consultorio x = new Consultorio();
		
		for(int i = 0; i < salas.size(); i++) {
			if(salas.get(i).getNum() == num) {
				x = salas.get(i).clone();
				break;
			}
		}
		
		System.out.println("Consultorio nº " + x.getNum()
							+ "\nEspecialidade: " + x.getEspecialidade()
							+ "\nArea: " + x.getArea());
	}
	
	public static void altEsp(ArrayList<Consultorio> salas) {
		System.out.println("Qual o número do Consultorio?");
		int num = Ler.umInt();
		for(int i = 0; i < salas.size(); i++) {
			if(salas.get(i).getNum() == num) {
				System.out.println("Qual a nova especialidade?");
				salas.get(i).setEspecialidade(Especialidade.getEspecialidade());
				break;
			}
		}
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file1));
			os.writeInt(Consultorio.getUltNumero());
			os.writeObject(salas);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void areaT(ArrayList<Consultorio> salas) {
		int areaT = 0;
		
		for(Consultorio i : salas) {
			areaT += i.getArea();
		}
		
		System.out.println("Area Total: " + areaT + " m2");
	}
	
}
