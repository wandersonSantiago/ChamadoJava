package br.com.chamado.control;

import br.com.chamado.dao.DaoChamadoc;
import br.com.chamado.dao.DaoDescricao;
import br.com.chamado.dao.DaoEmail;
import br.com.chamado.dao.DaoMensagem;
import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Descricao;
import br.com.chamado.model.Email;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    private DaoDescricao daoDescricao;
    private Usuario usuarioDaSessao = SessionContext.getInstance().getUsuarioLogado();

    public CtrChamado() {
        acessoHibernate = new DaoChamadoc();
        acessoHibernateMensagem = new DaoMensagem();
        email = new Email();
        acessoHibernateEmail = new DaoEmail();
        daoDescricao = new DaoDescricao();
    }

    public String gravarChamado() {

        try {
            Usuario user = SessionContext.getInstance().getUsuarioLogado();
            Date hojeData = new Date();

            chamadoc.setData(hojeData);
            chamadoc.setUnidade(user.getUnidade());
            chamadoc.setCodfuncsolic(user);

            Descricao status = daoDescricao.carregarStatus(8);

            chamadoc.setStatus(status);

            acessoHibernate.salvar(chamadoc);

            mensagem.setNumeChamado(chamadoc.getId());
            mensagem.setData(hojeData);
            mensagem.setCodfuncautor(user);
            acessoHibernateMensagem.salvar(mensagem);
            chamadoc.limpar();
            mensagem.limpar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Enviado"));
            return "/paginas/chamado/cadastrar/chamadoClienteTi";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Chamado não Enviado"));
            return "/paginas/chamado/cadastrar/chamadoClienteTi";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
            Descricao status = daoDescricao.carregarStatus(10);
            chamadoc.setStatus(status);
            acessoHibernate.alterar(chamadoc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Em Andamento"));
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Chamado não alterado"));

            return "falha";
        }

    }

    public String fecharChamado(Chamadoc chamadoc) {
        try {
            Descricao status = daoDescricao.carregarStatus(9);
            chamadoc.setStatus(status);
            Date dataDoFechamento = new Date();
            chamadoc.setDatafechamento(dataDoFechamento);
            acessoHibernate.alterar(chamadoc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Chamado Fechado"));
            return "/paginas/chamado/lista/listaChamadoTi";
        } catch (HibernateException e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Chamado Não Fechado"));
            return "/paginas/chamado/lista/listaChamadoTi";
        }
    }

    public String reabrirChamado(Chamadoc chamadoc) {
        try {
            Descricao status = daoDescricao.carregarStatus(11);
            chamadoc.setStatus(status);
            acessoHibernate.alterar(chamadoc);
            this.chamadoc = chamadoc;
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
            Usuario usuarioSessao = SessionContext.getInstance().getUsuarioLogado();
            return acessoHibernate.carregaChamadoOrdernado(usuarioSessao);
        } catch (HibernateException e) {

            return Collections.emptyList();
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

    public Usuario getUsuarioDaSessao() {
        return usuarioDaSessao;
    }

    public void setUsuarioDaSessao(Usuario usuarioDaSessao) {
        this.usuarioDaSessao = usuarioDaSessao;
    }

}
