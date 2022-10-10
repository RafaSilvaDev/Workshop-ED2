package models;

public class Endereco {
	private String estado;
    private String cidade;
    
    public Endereco(String estado, String cidade) {
    	this.estado = estado;
    	this.cidade = cidade;
    }
    
    
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
    
    
}
