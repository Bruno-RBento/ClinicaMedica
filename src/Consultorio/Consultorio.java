package Consultorio;

import java.io.Serializable;

import Medico.Especialidade;

@SuppressWarnings("serial")
public class Consultorio implements Serializable {
    private static int ultNumero = 0;
    private int num;

    private int area;

    public Consultorio() {
        ultNumero++;
        num = ultNumero;
    }

    public Consultorio(int width, int height) {
        ultNumero++;
        this.num = ultNumero;

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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Consultorio [num=" + num +  ", area=" + area + "]";
    }

    public boolean equals(Object o) {
        if (o != null && o.getClass() == this.getClass()) {
            Consultorio c = (Consultorio) o;
            return (c.getArea() == this.getArea());
        }
        return false;
    }

    public Consultorio clone() {
        Consultorio x = new Consultorio();
        x.setArea(this.getArea());
        x.setNum(this.getNum());
        return x;
    }

}
