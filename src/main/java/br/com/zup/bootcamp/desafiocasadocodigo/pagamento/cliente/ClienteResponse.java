package br.com.zup.bootcamp.desafiocasadocodigo.pagamento.cliente;

public class ClienteResponse {

    private Long id;
    private String nome;
    private String sobrenome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public ClienteResponse(Cliente novoCliente) {
        this.id = novoCliente.getId();
        this.nome = novoCliente.getNome();
        this.sobrenome = novoCliente.getSobrenome();
    }
}
