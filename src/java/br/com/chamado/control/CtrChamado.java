
package br.com.chamado.control;

import br.com.chamado.dao.DaoChamadoc;
import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Email;
import br.com.chamado.model.Mensagem;
import br.com.chamado.util.ServicoEmail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrChamado")
@SessionScoped
public class CtrChamado implements  Serializable{
    
    private final  DaoChamadoc acessoHibernate;
    private Chamadoc chamadoc;
    private final Email email;
    private Mensagem mensagem;
    public CtrChamado()
    {
      acessoHibernate = new DaoChamadoc();
      email = new Email();
    }
    
    public String gravarChamado() {
	
        ServicoEmail.iniciar();
        
        
        
        try {
	   Date hoje = new Date();
	   
	   chamadoc.setData(hoje);
	   acessoHibernate.salvar(chamadoc);
	 
	   mensagem.setNumeChamado(chamadoc.getId());
	   mensagem.setData(hoje);
	   acessoHibernate.salvar(mensagem);
	   
           
           email.setData(hoje);
           email.setAssunto("Novo chamado por");
           email.setDestinatari("eduardo@smcaetano.com.br");
           email.setTexto(mensagem.getTexto());
           acessoHibernate.salvar(email);
           
           
	   
	   return "index";
	} catch (HibernateException e) {
	    System.out.println(e.getMessage());
	    return "falha";
	}
    }

    public String  alterarChamado(Chamadoc chamdo)
    {
       try
       {
	    acessoHibernate.alterar(chamdo);
	   return "";
       }catch(HibernateException e)
       {
         return "falha";
       }
	    
    }
    public List carregarChamado()
    {
      try
      {
	  
	 return acessoHibernate.carregaTudoOrdernado(Chamadoc.class, "id");
      }catch(HibernateException e)
      {
        return null;
      }
    }

    public Chamadoc getChamadoc() {
	return chamadoc;
    }

    public void setChamadoc(Chamadoc chamadoc) {
	this.chamadoc = chamadoc;
    }

    public Mensagem getMensagem() {
	return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
	this.mensagem = mensagem;
    }
    
   
    
}
