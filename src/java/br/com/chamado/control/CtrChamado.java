package br.com.chamado.control;

import br.com.chamado.dao.DaoChamadoc;
import br.com.chamado.dao.DaoDescricao;
import br.com.chamado.dao.DaoEmail;
import br.com.chamado.dao.DaoMensagem;
import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Descricao;
import br.com.chamado.model.Email;
import br.com.chamado.model.EmailConfig;
import br.com.chamado.model.EnviaEmail;
import br.com.chamado.model.FuncaoChamado;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.Collections;
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
@ManagedBean(name = "ctrChamado")
@SessionScoped
public class CtrChamado implements Serializable {

    private final DaoChamadoc acessoHibernate;
    private final DaoMensagem acessoHibernateMensagem;
    private Chamadoc chamadoc;
    private final Email email;
    private final DaoEmail acessoHibernateEmail;
    private Mensagem mensagem;
    private Usuario usuario;
    private EnviaEmail mail = EnviaEmail.getInstancia();
    private DaoDescricao daoDescricao;

    public CtrChamado() {
        acessoHibernate = new DaoChamadoc();
        acessoHibernateMensagem = new DaoMensagem();
        email = new Email();
        acessoHibernateEmail = new DaoEmail();
        daoDescricao = new DaoDescricao();
    }

    public String gravarChamado() throws EmailException {

        try {
            FuncaoChamado chamadoAbrir = new FuncaoChamado();
            chamadoAbrir.abrir(chamadoc, mensagem);
          
          //  mail.enviar(); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Enviado"));
            return "/paginas/chamado/cadastrar/chamadoClienteTi";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Chamado não Enviado"));
            return "/paginas/chamado/cadastrar/chamadoClienteTi";
        }
    }
     public String gravarChamadoImpressora() throws EmailException {

        try {
            FuncaoChamado chamadoAbrir = new FuncaoChamado();
            chamadoAbrir.abrirChamadoImpressora(chamadoc, mensagem);
          
          //  mail.enviar(); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Enviado"));
            return "/paginas/chamado/cadastrar/chamadoClienteTi";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Chamado não Enviado"));
            return "/paginas/chamado/cadastrar/chamadoClienteTi";
        }
    }

    public String alterarChamado() {
        try {

            acessoHibernate.alterar(chamadoc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Mensagem enviada"));
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Mensagem não enviada"));
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        }

    }

    public String alterarChamados() {
        try {
            FuncaoChamado atenderChamado = new FuncaoChamado();
            atenderChamado.atenderChamada(chamadoc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Em Andamento"));

            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Chamado não alterado"));

            return "falha";
        }

    }

    public String fecharChamado(Chamadoc chamadoc) {
        try {
            FuncaoChamado fecharChamado = new FuncaoChamado();
            fecharChamado.fechar(chamadoc);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Fechado"));
            return "/paginas/chamado/lista/listaChamadoTi";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Chamado Não Fechado"));
            return "/paginas/chamado/lista/listaChamadoTi";
        }
    }

    public String reabrirChamado(Chamadoc chamadoc) {
        try {
            FuncaoChamado reabrirChamado = new FuncaoChamado();
            this.chamadoc = reabrirChamado.reabrirChamado(chamadoc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Reaberto"));
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro não foi possivel reabrir o chamado"));
            return "/paginas/chamado/lista/listaChamadoTi";
        }
    }

    public String paginaChamadoAberto(Chamadoc chamado) {
        try {
            this.chamadoc = chamado;
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public String paginaChamadoAtende(Chamadoc chamado) {
        try {
            this.chamadoc = chamado;
            return "/paginas/chamado/administrador/permissao/alterar/atendente";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public List carregarChamado() {
        try {
            return acessoHibernate.carregaChamadoOrdernado();
        } catch (HibernateException e) {

            return Collections.emptyList();
        }
    }

    public List carregarChamadoManutencaoTi() {
        try {
            return acessoHibernate.carregaChamadoOrdernadoChamadoTi();
        } catch (HibernateException e) {

            return Collections.emptyList();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
