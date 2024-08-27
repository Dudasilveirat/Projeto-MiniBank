import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MiniBank {

    private ArrayList<ContaBancaria> contas;

    MiniBank() {
        contas = new ArrayList();
    }

    public void cadastrarConta() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu nome completo: ");
        String nome = entrada.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = entrada.nextLine();
        System.out.println("Digite seu E-mail: ");
        String email = entrada.nextLine();

        int numero = new Random().nextInt(10000);
        Cliente cliente = new Cliente(nome, cpf, email);
        ContaBancaria conta = new ContaBancaria("0001", String.valueOf(numero), 0, cliente);
        this.contas.add(conta);
        conta.mostrarDados();
    }

    public void excluirConta() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a agência da sua conta bancária: ");
        String agencia = entrada.nextLine();
        System.out.println("Digite o número da sua conta bancária: ");
        String numero = entrada.nextLine();

        for (int i = 0; i < this.contas.size(); i++) {
            ContaBancaria conta = contas.get(i);
            if (conta.getAgencia().equals(agencia) && conta.getNumero().equals(numero)) {
                this.contas.remove(conta);
                System.out.println("Sua conta foi excluída com sucesso");
                return;
            }
        }
        System.out.println("Conta não encontrada");
    }

    public void realizarDeposito() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a agência da sua conta bancária: ");
        String agencia = entrada.nextLine();
        System.out.println("Digite o número da sua conta bancária: ");
        String numero = entrada.nextLine();
        System.out.println("Digite o valor do depósito: ");
        System.out.print("R$");
        float valor = entrada.nextFloat();

        for (int i = 0; i < this.contas.size(); i++) {
            ContaBancaria conta = contas.get(i);
            if (conta.getAgencia().equals(agencia) && conta.getNumero().equals(numero)) {
                conta.depositar(valor);
                conta.mostrarDados();
                return;
            }
        }
        System.out.println("Conta não encontrada");
    }

    public void realizarSaque() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a agência da sua conta bancária: ");
        String agencia = entrada.nextLine();
        System.out.println("Digite o número da sua conta bancária: ");
        String numero = entrada.nextLine();
        System.out.println("Digite o valor do saque: ");
        System.out.print("R$");
        float valor = entrada.nextFloat();

        for (int i = 0; i < this.contas.size(); i++) {
            ContaBancaria conta = contas.get(i);
            if (conta.getAgencia().equals(agencia) && conta.getNumero().equals(numero)) {
                conta.sacar(valor);
                conta.mostrarDados();
                return;
            }
        }
        System.out.println("Conta não encontrada");
    }

    public ContaBancaria buscarConta(String agencia, String numero) {
        for (int i = 0; i < this.contas.size(); i++) {
            ContaBancaria conta = contas.get(i);
            if (conta.getAgencia().equals(agencia) && conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void realizarTransferencia() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a agência da conta de origem: ");
        String agencia = entrada.nextLine();
        System.out.println("Digite o número da conta de origem: ");
        String numero = entrada.nextLine();

        ContaBancaria contaOrigem = buscarConta(agencia, numero);
        if (contaOrigem == null) {
            System.out.println("Conta de origem não encontrada");
            return;
        }

        System.out.println("Digite a agência da conta de destino: ");
        agencia = entrada.nextLine();
        System.out.println("Digite o número da conta de destino: ");
        numero = entrada.nextLine();

        ContaBancaria contaDestino = buscarConta(agencia, numero);
        if (contaDestino == null) {
            System.out.println("Conta de destino não encontrada");
            return;
        }

        System.out.println("Digite o valor da transferência: ");
        System.out.print("R$");
        float valor = entrada.nextFloat();

        if (contaOrigem.getSaldo() < valor) {
            System.out.println("Saldo insuficiente");
            return;
        } else {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Tranferência realizada com sucesso!");
            System.out.println("Saldo da conta de origem: R$" + contaOrigem.getSaldo());
            System.out.println("Saldo da conta de destino: R$" + contaDestino.getSaldo());
        }
    }
}
