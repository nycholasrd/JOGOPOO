import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<Jogador> todosOsJogadores = new ArrayList<Jogador>();
	private ArrayList<Palavra> todasAsPalavras = new ArrayList<Palavra>();

	public boolean adicionarPalavra(Palavra p) {
		for(Palavra buscaP: todasAsPalavras) {
			if(buscaP.equals(p)) {
				return false;
			}
		}
		todasAsPalavras.add(p);
		return true;
	}

	public boolean recuperarPalavra(Palavra p) {
		for(Palavra buscaP: todasAsPalavras) {
			if(buscaP.getPalavra().equals(p)) {
				return true;
			}
		}
		return false;
	}

	public boolean adicionarJogador(Jogador j) {
		for(Jogador buscaJ:todosOsJogadores) {
			if(buscaJ.equals(j)) {
				return false;
			}
		}
		todosOsJogadores.add(j);
		return true;
	}

	public boolean recuperarJogadorPorCPF(String CPF) {
		for(Jogador buscaJ:todosOsJogadores) {
			if(buscaJ.getCPF().equals(CPF)) {
				return true;
			}
		}
		return false;
	}


	public ArrayList<Jogador> getTodosOsJogadores() {
		return todosOsJogadores;
	}

	public void setTodosOsJogadores(ArrayList<Jogador> todosOsJogadores) {
		this.todosOsJogadores = todosOsJogadores;
	}


}