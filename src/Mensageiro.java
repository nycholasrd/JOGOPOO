import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mensageiro {


	private static final String VAR_REMETENTE = "EMAIL_REMETENTE";
	private static final String VAR_SENHA = "EMAIL_SENHA";

	public static void enviarMensagem(String destinatario, String assunto, String mensagem) {
		final String remetente = System.getenv(VAR_REMETENTE);
		final String senha = System.getenv(VAR_SENHA);

		if (remetente == null || senha == null) {
			System.out.println("Defina as variáveis de ambiente " + VAR_REMETENTE + " e " + VAR_SENHA
					+ " para poder enviar e-mails.");
			return;
		}

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session sessao = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remetente, senha);
			}
		});

		try {
			MimeMessage email = new MimeMessage(sessao);
			email.setFrom(new InternetAddress(remetente));
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			email.setSubject(assunto, "UTF-8");
			email.setText(mensagem, "UTF-8");
			Transport.send(email);
			System.out.println("E-mail enviado para: " + destinatario);
		} catch (MessagingException e) {
			System.out.println("Falha ao enviar e-mail para " + destinatario + ": " + e.getMessage());
		}
	}
}
