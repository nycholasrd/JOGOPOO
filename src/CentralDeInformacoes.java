import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<Jogador> todosOsJogadores = new ArrayList<Jogador>();
	private ArrayList<Palavra> todasAsPalavras = new ArrayList<Palavra>();

	public boolean adicionarPalavra(Palavra p) {
		if (p == null || todasAsPalavras.contains(p)) {
			return false;
		}
		todasAsPalavras.add(p);
		return true;
	}


	public Palavra recuperarPalavra(String palavra) {
		for (Palavra buscaP : todasAsPalavras) {
			if (buscaP.getPalavra().equalsIgnoreCase(palavra)) {
				return buscaP;
			}
		}
		return null;
	}

	public ArrayList<Palavra> getTodasAsPalavras() {
		return todasAsPalavras;
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