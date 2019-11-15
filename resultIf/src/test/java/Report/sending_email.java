package Report;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class sending_email {

	
	  public static void main(String[] args) throws EmailException, MalformedURLException 
	  	{
		  attachement();
		 // htmlAttachement();
	    }
	 
	public static void sendemail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("vipanshu.walia@gmail.com", "98120773904"));
		email.setAuthenticator(new DefaultAuthenticator("vipanshuw@travelboutiqueonline.com", "Fareportal@2"));
		email.setSSLOnConnect(true);
		email.setFrom("vipanshu.walia@gmail.com");
		email.setSubject("Automation email send");
		email.setMsg("Kindly download the report and open with excel ... :-)");
		email.addTo("vipanshu.walia@gmail.com");
		// email.addCc("abansal@travelboutiqueonline.com");
		email.send();
	}

	public static void attachement() throws EmailException {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("E:\\TimeSuplierCount.xls");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("result of last report");
		attachment.setName("Report.xls");

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		 email.setAuthenticator(new DefaultAuthenticator("vipanshu.walia@gmail.com", "98120773904"));
		email.setAuthenticator(new DefaultAuthenticator("vipanshuw@travelboutiqueonline.com", "Fareportal@2"));
		email.setSSLOnConnect(true);
		email.addTo("jatin@tboair.com");
		email.addCc("pankaj.choudhary@travelboutiqueonline.com");
		email.addCc("anudeep@tboair.com");
		email.addCc("Naveen@tboair.com");
		email.addCc("himanshus@tboair.com");
		email.addCc("vipanshuw@travelboutiqueonline.com");
		email.setFrom("vipanshuw@travelboutiqueonline.com");
		email.setSubject("Automation Execution Report");
		email.setMsg("Please download the report and drag the download report to the open excel sheet or open office");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

	}

	public static void htmlAttachement() throws EmailException, MalformedURLException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("vipanshuw@travelboutiqueonline.com", "Fareportal@1"));
		email.setSSLOnConnect(true);
		// email.addTo("pankaj.choudhary@travelboutiqueonline.com");
		email.addCc("vipanshu.walia@gmail.com");
		email.setFrom("vipanshuw@travelboutiqueonline.com");
		email.setSubject("Automation Execution Report");
		email.setMsg("Here is the picture you wanted");

		/*
		 * URL url = new URL(
		 * "C:\\Users\\vipanshuw\\eclipse-workspace\\Integration\\test-output\\emailable-report.html"
		 * ); String cid = email.embed(url, "Apache logo");
		 */
		email.setHtmlMsg("C:\\Users\\vipanshuw\\eclipse-workspace\\Integration\\test-output\\emailable-report.html");
		email.send();

	}

}
