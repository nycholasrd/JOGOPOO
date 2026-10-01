import java.util.ArrayList;

public class Jogador {
	private  String nome;
	private Sexo sexo;
	private String CPF;
	private String email;
	
	public String toString() {
		return nome;
	}
	
	
public Jogador(String nome, Sexo sexo, String CPF, String email, ArrayList<Jogador> jogadoresExistentes) {
	for (Jogador j : jogadoresExistentes) {
		//faz uma busca no ArrayList se já tiver um jogador cadastrado com essas informações ele nem chega a ser atribuido e é lançado um erro
		if (j.getCPF() != null && j.getCPF().equals(CPF)) {
			throw new IllegalArgumentException("Já existe um jogador cadastrado com esse CPF.");
		}
		if (j.getEmail() != null && j.getEmail().equalsIgnoreCase(email)) {
			throw new IllegalArgumentException("Já existe um jogador cadastrado com esse email.");
		}
		this.nome = nome;
		this.sexo = sexo;
		this.CPF =  CPF;
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
