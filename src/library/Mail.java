package library;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class Mail {
	private JavaMailSender mailer;
	
	public Mail(JavaMailSender mailer) {
		this.mailer=mailer;
	}
	
	public boolean send(String email,String body,String tille)
	{	
		try {
			MimeMessage mail=this.mailer.createMimeMessage();
			
			MimeMessageHelper helper=new MimeMessageHelper(mail);
			helper.setFrom("tainguyenzz18@gmail.com");
			helper.setTo(email);
			helper.setReplyTo("tainguyenzz18@gmail.com");
			helper.setSubject(tille);
			helper.setText(body,true);
			
			this.mailer.send(mail);
		}
		catch (Exception e) {
			System.out.print(e);
			return false;
		}
		return true;
	}
}
