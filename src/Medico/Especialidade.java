package Medico;

import Ler.Ler;

public enum Especialidade {
    CARDIOLOGIA, ANESTESIOLOGIA, DERMATOLOGIA, ENDOCRINOLOGIA, GASTROENTEROLOGIA, PNEUMOLOGIA, OBSTERICIA, PSIQUIATRIA,
    CIRUGIA_GERAL, MEDICINA_TRABALHO, MEDICINA_DESPORTIVA, MEDICINA_FISICA_E_REABILITCAO, MEDICINA_GERAL_E_FAMILIAR;

    public static Especialidade getEspecialidade() {
        System.out.println("1 - CARDIOLOGIA" + "\n2 - ANESTESIOLOGIA" + "\n3 - DERMATOLOGIA" + "\n4 - ENDOCRINOLOGIA"
                + "\n5 - GASTROENTEROLOGIA" + "\n6 - PNEUMOLOGIA" + "\n7 - OBSTERICIA" + "\n8 - PSIQUIATRIA"
                + "\n9 - CIRUGIA_GERAL" + "\n10 - MEDICINA_TRABALHO" + "\n11 - MEDICINA_DESPORTIVA"
                + "\n12 - MEDICINA_FISICA_E_REABILITCAO" + "\n13 - MEDICINA_GERAL_E_FAMILIAR");
        int opcao = Ler.umInt();

        switch (opcao) {
        case 1:
            return Especialidade.CARDIOLOGIA;
        case 2:
            return Especialidade.ANESTESIOLOGIA;
        case 3:
            return Especialidade.DERMATOLOGIA;
        case 4:
            return Especialidade.ENDOCRINOLOGIA;
        case 5:
            return Especialidade.GASTROENTEROLOGIA;
        case 6:
            return Especialidade.PNEUMOLOGIA;
        case 7:
            return Especialidade.OBSTERICIA;
        case 8:
            return Especialidade.PSIQUIATRIA;
        case 9:
            return Especialidade.CIRUGIA_GERAL;
        case 10:
            return Especialidade.MEDICINA_TRABALHO;
        case 11:
            return Especialidade.MEDICINA_DESPORTIVA;
        case 12:
            return Especialidade.MEDICINA_FISICA_E_REABILITCAO;
        case 13:
            return Especialidade.MEDICINA_GERAL_E_FAMILIAR;
        default:
            throw new IllegalStateException("Unexpected value: " + opcao);
        }
    }
}
