import java.util.Date;

public class Palavra {
	private String palavra;
	private String dica;
	private Date dataDeCadastro;
	private Nivel nivel;
	
	
	public String toString() {
		return "Palavra: " + palavra + "Dica: " + dica;
	}
	
	public boolean equals(Palavra p) {
		if(this.palavra == p.palavra) {
			return true;
		}
		return false;
	}
	
	public Palavra(String palavra, String dica, Nivel nivel) {
		this.palavra = palavra;
		this.dica = dica;
		this.nivel = nivel;
	}
	
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
	
}
