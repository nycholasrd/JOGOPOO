import java.util.Date;

public class Palavra {
	private String palavra;
	private String dica;
	private Date dataDeCadastro;
	private Nivel nivel;

	public Palavra(String palavra, String dica, Nivel nivel) {
		this.palavra = palavra;
		this.dica = dica;
		this.nivel = nivel;
		this.dataDeCadastro = new Date();
	}


	public String toString() {
		return palavra + " - " + dica;
	}



	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Palavra)) {
			return false;
		}
		Palavra outra = (Palavra) obj;
		return palavra != null && palavra.equalsIgnoreCase(outra.palavra);
	}


	public int hashCode() {
		return palavra == null ? 0 : palavra.toLowerCase().hashCode();
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
