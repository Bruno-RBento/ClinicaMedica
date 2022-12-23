package consultorio;

import java.io.*;
import java.util.ArrayList;
import medico.Especialidade;
import ler.Ler;

public class FuncConsultorio {
	private static File file1 = new File("...MempryFile\\salas.dat"); 
	
	public static void adicionarConsultorio(ArrayList<Consultorio> salas) {
		System.out.println("Qual a especialidade do Consultorio?");
		Especialidade esp = list(); //escolhe uma opção da lista de especialidades
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
				salas.get(i).setEspecialidade(list());
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
	
	private static Especialidade list() {
		System.out.println("1 - CARDIOLOGIA"
        				+ "\n2 - ANESTESIOLOGIA"
        				+ "\n3 - DERMATOLOGIA"
        				+ "\n4 - ENDOCRINOLOGIA"
        				+ "\n5 - GASTROENTEROLOGIA"
        				+ "\n6 - PNEUMOLOGIA"
        				+ "\n7 - OBSTERICIA"
        				+ "\n8 - PSIQUIATRIA"
        				+ "\n9 - CIRUGIA_GERAL"
        				+ "\n10 - MEDICINA_TRABALHO"
        				+ "\n11 - MEDICINA_DESPORTIVA"
        				+ "\n12 - MEDICINA_FISICA_E_REABILITCAO"
        				+ "\n13 - MEDICINA_GERAL_E_FAMILIAR");
        int opcao = Ler.umInt();

        switch (opcao){
            case 1: return Especialidade.CARDIOLOGIA;
            case 2: return Especialidade.ANESTESIOLOGIA;
            case 3: return Especialidade.DERMATOLOGIA;
            case 4: return Especialidade.ENDOCRINOLOGIA;
            case 5: return Especialidade.GASTROENTEROLOGIA;
            case 6: return Especialidade.PNEUMOLOGIA;
            case 7: return Especialidade.OBSTERICIA;
            case 8: return Especialidade.PSIQUIATRIA;
            case 9: return Especialidade.CIRUGIA_GERAL;
            case 10: return Especialidade.MEDICINA_TRABALHO;
            case 11: return Especialidade.MEDICINA_DESPORTIVA;
            case 12: return Especialidade.MEDICINA_FISICA_E_REABILITCAO;
            case 13: return Especialidade.MEDICINA_GERAL_E_FAMILIAR;
            default:
                throw new IllegalStateException("Unexpected value: " + opcao);
        }
	}
	
}
