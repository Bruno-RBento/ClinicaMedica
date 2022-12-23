package consultorio;

import java.io.*;
import java.util.ArrayList;
import ler.Ler;

public class GerirConsultorio {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		String inp = "";
		File file1 = new File("...MemoryFile\\salas.dat"); 
		ArrayList<Consultorio> salas = new ArrayList<Consultorio>();
		
		try {
			FileInputStream fIs = new FileInputStream(file1);
			ObjectInputStream is = new ObjectInputStream(fIs);
			Consultorio.setUltNumero(is.readInt());
			salas = (ArrayList<Consultorio>)is.readObject();
			is.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		do {
			System.out.println(menuConsul());
			inp = Ler.umaString();
			
			switch(inp) {
			case "1":
				FuncConsultorio.adicionarConsultorio(salas);
				break;
			case "2":
				System.out.println(salas.toString());
				break;
			case "3":
				FuncConsultorio.getSala(salas);
				break;
			case "4":
				FuncConsultorio.altEsp(salas);
				break;
			case "5":
				FuncConsultorio.areaT(salas);
				break;
			}
		}while(!inp.equals("6"));
		
	}
	
	private static String menuConsul() {
		return ("1 - Adicionar Consultorio"
				+ "\n2 - Lista com dados dos Consultorios"
				+ "\n3 - Dados de um Consultorio dado o Número"
				+ "\n4 - Alterar Especialidade de Consultorio"
				+ "\n5 - Area Total dos Consultorios"
				+ "\n6 - Sair");
	}
}
