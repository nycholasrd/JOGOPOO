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

			} else if (!opcao.equalsIgnoreCase("S")) {
				System.out.println("Opção inválida.");
			}
		}

		System.out.println("Encerrando o sistema.");
		sc.close();
	}
}