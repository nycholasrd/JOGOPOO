import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		Scanner sc = new Scanner(System.in);
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		System.out.println("=== SISTEMA DE CADASTRO DE JOGADORES ===");

		String opcao = "";
		while (!opcao.equalsIgnoreCase("S")) {
			System.out.println("\n1 - Novo jogador");
			System.out.println("2 - Listar todos os jogadores");
			System.out.println("3 - Exibir informações de um jogador específico");
			System.out.println("4 - Salvar palavras a partir de um arquivo CSV");
			System.out.println("5 - Listar todas as palavras salvas na central");
			System.out.println("6 - Gerar relatório em PDF");
			System.out.println("7 - Enviar uma mensagem para todos os jogadores");
			System.out.println("S - Sair");
			System.out.print("Opção: ");
			opcao = sc.nextLine();

			if (opcao.equals("1")) {
				System.out.print("Nome: ");
				String nome = sc.nextLine();

				System.out.print("Sexo (M/F): ");
				String s = sc.nextLine();
				Sexo sexo = s.equalsIgnoreCase("F") ? Sexo.FEMININO : Sexo.MASCULINO;

				System.out.print("CPF: ");
				String cpf = sc.nextLine();

				System.out.print("Email: ");
				String email = sc.nextLine();

				try {
					Jogador jogador = new Jogador(nome, sexo, cpf, email, central.getTodosOsJogadores());
					central.adicionarJogador(jogador);
					persistencia.salvarCentral(central, "central");
					System.out.println("Jogador cadastrado: " + jogador);
				} catch (Exception e) {
					System.out.println("Cadastro não realizado");
				}

			} else if (opcao.equals("2")) {
				if (central.getTodosOsJogadores().isEmpty()) {
					System.out.println("Nenhum jogador cadastrado");
				} else {
					System.out.println("Jogadores cadastrados");
					for (Jogador j : central.getTodosOsJogadores()) {
						System.out.println(j);
					}
				}

			} else if (opcao.equals("3")) {
				System.out.print("Informe o CPF do jogador: ");
				String cpf = sc.nextLine();

				Jogador encontrado = null;
				for (Jogador j : central.getTodosOsJogadores()) {
					if (j.getCPF() != null && j.getCPF().equals(cpf)) {
						encontrado = j;
					}
				}

				if (encontrado == null) {
					System.out.println("Jogador não encontrado.");
				} else {
					System.out.println("Nome: " + encontrado.getNome());
					System.out.println("Sexo: " + encontrado.getSexo());
					System.out.println("CPF: " + encontrado.getCPF());
					System.out.println("Email: " + encontrado.getEmail());
				}

			} else if (opcao.equals("4")) {
				System.out.print("Nome do arquivo CSV: ");
				String nomeCsv = sc.nextLine();

				ArrayList<Palavra> extraidas = ExtratorPalavrasCSV.extrairPalavras(nomeCsv);
				if (extraidas == null) {
					System.out.println("Não foi possível extrair as palavras: arquivo inexistente ou fora do formato esperado.");
				} else {
					int adicionadas = 0;
					for (Palavra p : extraidas) {
						if (central.adicionarPalavra(p)) {
							adicionadas++;
						}
					}
					persistencia.salvarCentral(central, "central");
					System.out.println(adicionadas + " palavra(s) adicionada(s); " + (extraidas.size() - adicionadas) + " repetida(s) ignorada(s).");
				}

			} else if (opcao.equals("5")) {
				if (central.getTodasAsPalavras().isEmpty()) {
					System.out.println("Nenhuma palavra cadastrada");
				} else {
					System.out.println("Palavras cadastradas");
					for (Palavra p : central.getTodasAsPalavras()) {
						System.out.println(p + " [" + p.getNivel() + "]");
					}
				}

			} else if (opcao.equals("6")) {
				GeradorDeRelatorios.gerarRelatorio(central);

			} else if (opcao.equals("7")) {
				if (central.getTodosOsJogadores().isEmpty()) {
					System.out.println("Nenhum jogador cadastrado");
				} else {
					System.out.print("Assunto: ");
					String assunto = sc.nextLine();
					System.out.print("Mensagem: ");
					String mensagem = sc.nextLine();

					for (Jogador j : central.getTodosOsJogadores()) {
						if (j.getEmail() != null && !j.getEmail().isEmpty()) {
							Mensageiro.enviarMensagem(j.getEmail(), assunto, mensagem);
						}
					}
				}

			} else if (!opcao.equalsIgnoreCase("S")) {
				System.out.println("Opção inválida.");
			}
		}

		System.out.println("Encerrando o sistema.");
		sc.close();
	}
}