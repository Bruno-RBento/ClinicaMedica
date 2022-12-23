package Medico;

public enum Especialidade {
    CARDIOLOGIA(2000,50),
    ANESTESIOLOGIA(3000,50),
    DERMATOLOGIA(2000,50),
    ENDOCRINOLOGIA(2000,50),
    GASTROENTEROLOGIA(2000,50),
    PNEUMOLOGIA(2000,50),
    OBSTERICIA(2000,50),
    PSIQUIATRIA(1500,50),
    CIRUGIA_GERAL(3500,50),
    MEDICINA_TRABALHO(1500,50),
    MEDICINA_DESPORTIVA(1500,50),
    MEDICINA_FISICA_E_REABILITCAO(1500,50),
    MEDICINA_GERAL_E_FAMILIAR(1500,50);

    private int salario;
    private int custoConsulta;

    Especialidade(int salario, int custoConsulta) {
        this.salario = salario;
        this.custoConsulta = custoConsulta;
    }


    public int getSalario() {
        return salario;
    }

    public int getCustoConsulta() {
        return custoConsulta;
    }
}
