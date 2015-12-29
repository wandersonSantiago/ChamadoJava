package br.com.chamado.util;

import br.com.chamado.dao.DaoGenerico;
import br.com.chamado.model.EmailConfig;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class EnviaEmail {

    private static EmailConfig config = null;
    private static EnviaEmail instancia = null;
    private boolean status = false;
    private  String emailDe = "";
    private  String assunto = "";
    private  String msg = "";
    private EnviaEmail()
    {
         if(config == null)
	 {
	     DaoGenerico dao  = new DaoGenerico();
	     config = (EmailConfig) dao.carregarUm(1, EmailConfig.class);
	     
	 }
    }
    public static EnviaEmail getInstancia() 
    {
      
       if(instancia == null)
       {
         instancia = new EnviaEmail();
 	
       }
       return instancia;
    }

   public void setEmailDe(String emailDe) {
	this.emailDe = emailDe;
    }  
    public void setAssunto(String assunto) {
	this.assunto = assunto;
    }

  
    public void setMsg(String msg) {
	this.msg = msg;
    }
    public boolean getStatus()
    {
      return status;
    }
    public boolean testaEnvio()
    {
        assunto = "Teste de Email";
        emailDe = config.getUsuario();
        msg = "Teste de Email OK";
        enviar();
        
        return status;
        
    }
    public  synchronized  void enviar() 
    {
        try
        {
        SimpleEmail email = new SimpleEmail(); 
	email.setHostName(config.getServidor());
	email.setAuthentication(config.getUsuario(),config.getSenha());  
        email.setSmtpPort(config.getPorta());  
       
        email.setSSLOnConnect(config.isSsl());
	email.setStartTLSRequired(config.isTls());
	email.addTo(emailDe,"Teste");
	email.setFrom(config.getUsuario(),config.getMsgFrom());
	email.setSubject(assunto);
	email.setMsg(msg);
        email.send();
        status = true;
        }catch(EmailException e)
        {
           status = false;
            System.out.println(e.getMessage());
        }
	}
}
