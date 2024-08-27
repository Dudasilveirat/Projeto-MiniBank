public class ContaBancaria {
    private String agencia;
    private String numero;
    private float saldo;
    private Cliente cliente;

    // Construtor
    ContaBancaria(String agencia, String numero, float saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    ContaBancaria(String agencia, String numero, float saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    public void sacar(float valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void mostrarDados() {
        System.out.println("Dados da conta: ");
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número da Conta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }
}