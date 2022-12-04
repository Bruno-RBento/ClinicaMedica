package Paciente;

import java.io.Serializable;

public class Paciente implements Serializable {

    private int nUtenteSaude;
    private String name;
    private String apelido;
    private String direccion;




    public Paciente(int nUtenteSaude, String name, String apelido, String direccion) {
        this.nUtenteSaude = nUtenteSaude;
        this.name = name;
        this.apelido = apelido;
        this.direccion = direccion;
    }


    public int getnUtenteSaude() {
        return nUtenteSaude;
    }

    public String getName() {
        return name;
    }

    public String getApelido() {
        return apelido;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Paciente( " +
                "nUtenteSaude=" + nUtenteSaude +
                ", name='" + name + '\'' +
                ", apelido='" + apelido + '\'' +
                ", direccion='" + direccion + '\'' +
                ')';
    }

}
