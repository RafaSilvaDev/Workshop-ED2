package models;

public class Cliente {
	private Integer id;
    private String nome;
    private Endereco endereco;
    
	public Cliente(Integer id, String nome, String cidade, String estado) {
		this.id = id;
		this.nome = nome;
		endereco = new Endereco(estado, cidade);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
    
    
}
