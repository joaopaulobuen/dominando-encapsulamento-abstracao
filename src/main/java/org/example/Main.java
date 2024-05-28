package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }

}

public class Main {
    public static void main(String[] args) {
        // Lê o tipo de cofre (primeira linha da entrada)
        Scanner scanner = new Scanner(System.in);
        String tipoCofre = scanner.nextLine();
        // TODO: Implemente a condição necessário para a verificação dos cofres seguros:
        if (tipoCofre.equalsIgnoreCase("digital")) {
            int senha = scanner.nextInt();
            CofreDigital cofreDigital = new CofreDigital(senha);

            int confirmaSenha = scanner.nextInt();

            if(!cofreDigital.validarSenha(confirmaSenha)) {
                cofreDigital.imprimirInformacoes();
                System.out.println("Senha incorreta!");
                return;
            }
            cofreDigital.imprimirInformacoes();
            System.out.println("Cofre aberto!");
            return;
        }

        if (tipoCofre.equalsIgnoreCase("fisico")){
            CofreFisico cofreFisico = new CofreFisico();
            cofreFisico.imprimirInformacoes();
            return;
        }
        System.out.println("Tipo de confre invalido!");
    }
}