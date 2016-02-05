package br.com.chamado.control;

import br.com.chamado.dao.DaoChamadoc;
import br.com.chamado.dao.DaoDescricao;
import br.com.chamado.dao.DaoEmail;
import br.com.chamado.dao.DaoGenerico;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
            limpar();
            return "/index";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return "erro404";
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
            limpar();
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            return "falha";
        }

    }

    public String alterarChamados() {
        try {
            Descricao status = daoDescricao.carregarStatus(10);
            chamadoc.setStatus(status);
            acessoHibernate.alterar(chamadoc);
            
            return "/paginas/chamado/cadastrar/chamadoAbertoCliente";
        } catch (HibernateException e) {
            return "falha";
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

    public void limpar() {
        this.chamadoc.setCategoria(null);
        this.chamadoc.setPrioridade(null);
        this.chamadoc.setTitulo(null);
        this.mensagem.setTexto(null);

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
