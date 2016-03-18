package br.com.chamado.control;

import br.com.chamado.dao.DaoMensagem;
import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.EnviaEmail;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.EmailException;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "CtrMensagem")
@SessionScoped
public class CtrMensagem implements Serializable {

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
            mensagem.limpar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Mensagem enviada"));
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Mensagem Não enviada"));
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        }
    }

    public String alterarMensagem(Mensagem mensagem) {
        try {
            acessoHibernate.alterar(mensagem);
            mensagem.limpar();
            return "";
        } catch (HibernateException e) {
            return "falha";
        }

    }

    public List carregarMensagem(Chamadoc chamado) {
        try {
            return acessoHibernate.carregaMensagemOrdernado(chamado);

        } catch (HibernateException e) {
            return null;
        }
    }

    public void limpar() {
        this.mensagem.setTexto(null);
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
