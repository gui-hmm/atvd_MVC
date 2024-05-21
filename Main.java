import entidade.Conta;
import fachadas.Fachada;
import fachadas.IFachada;
import excecao.ExcecaoElementoInexistente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IFachada fachada = new Fachada();
        Conta c = new Conta("Julio", "01", 200);
        Conta c2 = new Conta("Eva", "02", 550);
        fachada.inserirConta(c);
        fachada.inserirConta(c2);
        fachada.mostrarContas();

        Scanner scanner = new Scanner(System.in);

        int escolha = 1;
        while (escolha != 0) {
            System.out.println("-------------- MENU ---------------");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Inserir Conta");
            System.out.println("[2] - Apagar Conta");
            System.out.println("[3] - Alterar Conta");
            System.out.println("[4] - Buscar Conta");
            System.out.println("[5] - Relatorio de todas contas existentes");
            System.out.print("Escolha uma das opções: ");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    try {
                        System.out.print("Nº da Conta: ");
                        String numeroConta = scanner.next();

                        System.out.print("Titular da Conta: ");
                        String titular = scanner.next();
                        System.out.print("Digite um valor inicial: R$ ");
                        double saldo = scanner.nextDouble();

                        fachada.inserirConta(new Conta(numeroConta, titular, saldo));

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Nº da Conta: ");
                        String numero = scanner.next();
                        fachada.removerConta(numero);
                        System.out.println("Conta removida com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Lista de contas vazia!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o numero da conta que será alterada: ");
                    String numC = scanner.next();
                    fachada.alterarConta(numC);
                    break;
                case 4:
                    try {
                        System.out.print("Nº da Conta: ");
                        String num = scanner.next();
                        System.out.println(fachada.buscarConta(num));

                    } catch (ExcecaoElementoInexistente e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    fachada.mostrarContas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        }
    }
}