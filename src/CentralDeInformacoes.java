import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<Jogador> todosOsJogadores = new ArrayList<Jogador>();
	
	public boolean adicionarJogador(Jogador j) {
		for(Jogador buscaJ:todosOsJogadores) {
			if(buscaJ.equals(j)!=  true) {
				todosOsJogadores.add(j);
				return true;
			}
		}
		return false;
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
