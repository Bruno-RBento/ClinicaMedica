package Consultorio;

import java.util.ArrayList;
import Ler.Ler;

public class GerirConsultorio {

	private static void menuConsul() {
		System.out.println("1 - Adicionar Consultorio");
		System.out.println("2 - Lista com dados dos Consultorios");
		System.out.println("3 - Encontrar o consultorio pelo numero");
		System.out.println("4 - Area Total dos Consultorios");
		System.out.println("5 - Remover Consultorio");
		System.out.println("7 - Sair");
	}

	public static void gerirConsultorio() {
		int inp = 0;
		ArrayList<Consultorio> salas = FuncConsultorio.getConsultorios();

		do {
			menuConsul();
			inp = Ler.umInt();

			switch (inp) {
			case 1:
				System.out.println("Qual as medidas do consultorio no formato - (width height)");
				String medidas = Ler.umaString();
				String lados[] = medidas.split(" ");

				Consultorio c = new Consultorio(Integer.parseInt(lados[0]), Integer.parseInt(lados[1]));
				salas.add(c);
				break;
			case 2:

				System.out.println(salas.toString());
				break;
			case 3:
				System.out.println("Qual o número do Consultorio?");
				int num = Ler.umInt();

				for (int i = 0; i < salas.size(); i++) {
					if (salas.get(i).getNum() == num) {
						System.out.println(salas.get(i));
						break;
					}
				}

				break;
			case 4:
				int areaT = 0;

				for (Consultorio i : salas) {
					areaT += i.getArea();
				}

				System.out.println("Area Total: " + areaT + " m2");
				break;
			case 5:
				System.out.println("Qual o número do Consultorio?");
				int d = Ler.umInt();
				boolean apagado = false;
				for (int i = 0; i < salas.size(); i++) {
					if (salas.get(i).getNum() == d) {
						apagado = true;
						break;
					}
				}
				System.out.println(apagado ? "Apagado" : "Nao foi encontrado");
				break;
			}

			FuncConsultorio.saveToFile(salas);
		} while (inp != 7);

	}

}
