import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeRelatorios {


	public static void gerarRelatorio(CentralDeInformacoes central) {
		String nomeArquivo = "relatorio.pdf";
		Document documento = new Document();

		try {
			PdfWriter.getInstance(documento, new FileOutputStream(nomeArquivo));
			documento.open();

			Font fonteTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
			Font fonteSecao = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);

			documento.add(new Paragraph("Relatório do Jogo da Forca", fonteTitulo));
			documento.add(new Paragraph("Gerado em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())));
			documento.add(new Paragraph(" "));

			documento.add(new Paragraph("Jogadores cadastrados (" + central.getTodosOsJogadores().size() + ")", fonteSecao));
			documento.add(new Paragraph(" "));
			if (central.getTodosOsJogadores().isEmpty()) {
				documento.add(new Paragraph("Nenhum jogador cadastrado."));
			} else {
				for (Jogador j : central.getTodosOsJogadores()) {
					documento.add(new Paragraph(
							j.getNome() + " | " + j.getSexo() + " | CPF: " + j.getCPF() + " | E-mail: " + j.getEmail()));
				}
			}

			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Palavras cadastradas (" + central.getTodasAsPalavras().size() + ")", fonteSecao));
			documento.add(new Paragraph(" "));
			if (central.getTodasAsPalavras().isEmpty()) {
				documento.add(new Paragraph("Nenhuma palavra cadastrada."));
			} else {
				for (Palavra p : central.getTodasAsPalavras()) {
					documento.add(new Paragraph(p.getPalavra() + " | Dica: " + p.getDica() + " | Nível: " + p.getNivel()));
				}
			}

			System.out.println("Relatório gerado com sucesso: " + nomeArquivo);
		} catch (DocumentException | FileNotFoundException e) {
			System.out.println("Erro ao gerar o relatório: " + e.getMessage());
		} finally {
			if (documento.isOpen()) {
				documento.close();
			}
		}
	}
}
