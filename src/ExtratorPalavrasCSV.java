package JOGOPOO.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ExtratorPalavrasCSV {



	public static ArrayList<Palavra> extrairPalavras(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);
		if (!arquivo.exists() || !arquivo.isFile()) {
			return null;
		}

		ArrayList<Palavra> palavras = new ArrayList<Palavra>();

		try (BufferedReader leitor = new BufferedReader(
				new InputStreamReader(new FileInputStream(arquivo), StandardCharsets.UTF_8))) {

			String linha;
			boolean primeira = true;
			while ((linha = leitor.readLine()) != null) {
				if (primeira) {
					linha = linha.replace("\uFEFF", "");
					primeira = false;
				}
				if (linha.trim().isEmpty()) {
					continue;
				}


				String[] partes = linha.split(",", 3);
				if (partes.length != 3) {
					return null;
				}

				String palavra = partes[0].trim();
				String dica = partes[2].trim();
				if (palavra.isEmpty() || dica.isEmpty()) {
					return null;
				}

				Nivel nivel;
				try {
					nivel = converterNivel(Integer.parseInt(partes[1].trim()));
				} catch (NumberFormatException e) {
					return null;
				}
				if (nivel == null) {
					return null;
				}

				palavras.add(new Palavra(palavra, dica, nivel));
			}
		} catch (IOException e) {
			return null;
		}

		return palavras;
	}

	private static Nivel converterNivel(int codigo) {
		switch (codigo) {
		case 0:
			return Nivel.FACIL;
		case 1:
			return Nivel.MEDIO;
		case 2:
			return Nivel.DIFICIL;
		default:
			return null;
		}
	}
}
