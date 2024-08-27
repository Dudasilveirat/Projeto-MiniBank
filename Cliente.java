public class Cliente {
    private String nome;
    private String cpf;
    private String email;

    // Construtor
    Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // Encapsulamento
    void setNome(String nome) {
        this.nome = nome;
    }

    String getNome() {
        return this.nome;
    }

    void setCPF(String cpf) {
        this.cpf = cpf;
    }

    String getCPF() {
        return this.cpf;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getEmail() {
        return this.email;
    }
}
