
package br.com.chamado.control;

import br.com.chamado.dao.DaoEmailConfig;
import br.com.chamado.model.EmailConfig;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrEmailConfig")
@SessionScoped
public class CtrEmailConfig {

    private final DaoEmailConfig acessoHibernate;
    private EmailConfig confemail;

    public CtrEmailConfig() {
	acessoHibernate = new DaoEmailConfig();
    }

    public String gravarConfig() {
	try {
	    acessoHibernate.salvar(confemail);
	    return "index.xhtml";
	} catch (HibernateException e) {
	   System.out.println(e.getMessage());
	    return "falha";
	}
    }

    public String alterarConfig(EmailConfig config) {
	try {
	    acessoHibernate.alterar(config);
	    return "index.xhtml";
	} catch (HibernateException e) {
	    return "falha";
	}

    }

    public EmailConfig getConfemail() {
	return confemail;
    }

    public void setConfemail(EmailConfig confemail) {
	this.confemail = confemail;
    }
   
    
    
    
}
