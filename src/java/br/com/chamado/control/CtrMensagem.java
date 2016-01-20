package br.com.chamado.control;

import br.com.chamado.dao.DaoMensagem;
import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "CtrMensagem")
@SessionScoped
public class CtrMensagem implements  Serializable{

    private final DaoMensagem acessoHibernate;
    private Mensagem mensagem;
    private Chamadoc chamadoc;
    public CtrMensagem() {
	acessoHibernate = new DaoMensagem();
    }

    public String gravarMensagem() {
	try {
            Date hojeData = new Date();
            mensagem.setData(hojeData);
            mensagem.setNumeChamado(chamadoc.getId());
            Usuario usuarioSessao = SessionContext.getInstance().getUsuarioLogado();
            mensagem.setCodfuncautor(usuarioSessao);
            acessoHibernate.salvar(mensagem);
	   
            return "index";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

    public String alterarMensagem(Mensagem mensagem) {
	try {
            acessoHibernate.alterar(mensagem);
	    return "";
	} catch (HibernateException e) {
	    return "falha";
	}

    }
  public List carregarMensagem(Chamadoc chamado) {
	try {
              return acessoHibernate.carregaMensagemOrdernado(chamado);
	  // return acessoHibernate.carregaTudoOrdernado(Mensagem.class, "nummensagem");
           
	} catch (HibernateException e) {
	    return null;
	}
    }
   
    public Mensagem getMensagem() {
	return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
	this.mensagem = mensagem;
    }

    public Chamadoc getChamadoc() {
        return chamadoc;
    }

    public void setChamadoc(Chamadoc chamadoc) {
        this.chamadoc = chamadoc;
    }
   
}
