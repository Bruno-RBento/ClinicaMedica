package Consultorio;

import java.io.Serializable;

import Medico.Especialidade;

@SuppressWarnings("serial")
public class Consultorio implements Serializable {
    private static int ultNumero = 0;
    private int num;
    private Especialidade especialidade;
    private int area;

    public Consultorio() {
        ultNumero++;
        num = ultNumero;
    }

    public Consultorio(Especialidade especialidade, int width, int height) {
        ultNumero++;
        this.num = ultNumero;
        this.especialidade = especialidade;
        area = width * height;
    }

    public static int getUltNumero() {
        return ultNumero;
    }

    public static void setUltNumero(int ultNumero) {
        Consultorio.ultNumero = ultNumero;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Consultorio [num=" + num + ", especialidade=" + especialidade + ", area=" + area + "]";
    }

    public boolean equals(Object o) {
        if (o != null && o.getClass() == this.getClass()) {
            Consultorio c = (Consultorio) o;
            return (c.getArea() == this.getArea() && c.getEspecialidade().equals(this.getEspecialidade()));
        }
        return false;
    }

    public Consultorio clone() {
        Consultorio x = new Consultorio();
        x.setEspecialidade(this.getEspecialidade());
        x.setArea(this.getArea());
        x.setNum(this.getNum());
        return x;
    }

}
