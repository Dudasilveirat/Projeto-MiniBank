import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MiniBank banco = new MiniBank();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem-vindo ao MiniBank");
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Escolha uma das opções: ");
            System.out.println("1 - Cadastrar conta bancária");
            System.out.println("2 - Excluir conta bancária");
            System.out.println("3 - Depósito");
            System.out.println("4 - Saque");
            System.out.println("5 - Transferência");
            System.out.println("6 - Sair");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    banco.cadastrarConta();
                    break;
                case 2:
                    banco.excluirConta();
                    break;
                case 3:
                    banco.realizarDeposito();
                    break;
                case 4:
                    banco.realizarSaque();
                    break;
                case 5:
                    banco.realizarTransferencia();
                    break;
                case 6:
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        System.out.println("Volte sempre!");

    }
}
