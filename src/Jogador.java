
public class Jogador {
	private  String nome;
	private Sexo sexo;
	private String CPF;
	private String email;
	
	public String toString(String nome) {
		return nome;
	}
	
	
	public Jogador(String nome, Sexo sexo, String CPF, String email) {
		this.nome = nome;
		this.sexo = sexo;
		if(CPF.equals(CPF)!= true) {
			this.CPF =  CPF;
		}
		if(email.equals(email)!= true) {
			this.email = email;
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getCPF() {
		return CPF;
	}
	public String getEmail() {
		return email;
	}
	
}
