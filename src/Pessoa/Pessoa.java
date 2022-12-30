package Pessoa;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

import Ler.Ler;

public class Pessoa implements Serializable {
    String nome;
    String apelido;
    String morada;
    LocalDateTime nascimento;

    public Pessoa(String nome, String apelido, String morada, LocalDateTime nascimento) {
        this.nome = nome;
        this.apelido = apelido;
        this.morada = morada;
        this.nascimento = nascimento;
    }

    public static Pessoa novaPessoa() {
        System.out.print("O primeiro nome da pessoa: ");
        String nome = Ler.umaString();
        System.out.print("O apelido da pessoa: ");
        String apelido = Ler.umaString();
        System.out.print("A morada da pessoa: ");
        String morada = Ler.umaString();

        LocalDateTime nascimento;
        while (true) {
            System.out.print("Data de nascimento\n");
            System.out.print("Dia: ");
            int dd = Ler.umInt();

            System.out.print("\nMes: ");
            int mm = Ler.umInt();
            Month month;
            try {
                month = Month.of(mm);
            } catch (DateTimeException e) {
                System.out.println("Mes invalido");
                continue;
            }
            System.out.print("\nAno: ");
            int yyyy = Ler.umInt();

            try {
                nascimento = LocalDateTime.of(yyyy, month, dd, 0, 0);
                break;
            } catch (DateTimeException e) {
                System.out.println("Data invalida!");
            }
        }
        return new Pessoa(nome, apelido, morada, nascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getIdade() {
        Year nascimento = Year.of(this.nascimento.getYear());
        Year now = Year.now();
        return now.getValue() - nascimento.getValue();
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public String toString() {
        return String.format("Nome: %s, Apelido: %s, Morada: %s, Idade: %d", nome, apelido, morada, getIdade());
    }
}
