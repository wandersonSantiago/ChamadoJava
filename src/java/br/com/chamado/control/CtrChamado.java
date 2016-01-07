package br.com.chamado.control;

import br.com.chamado.dao.DaoChamadoc;
import br.com.chamado.dao.DaoEmail;
import br.com.chamado.dao.DaoMensagem;
import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Email;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

    public CtrChamado() {
        acessoHibernate = new DaoChamadoc();
        acessoHibernateMensagem = new DaoMensagem();
        email = new Email();
        acessoHibernateEmail = new DaoEmail();

    }

    public String gravarChamado() {

        try {
            Usuario user = SessionContext.getInstance().getUsuarioLogado();
            Date hojeData = new Date();

            chamadoc.setData(hojeData);
            chamadoc.setUnidade(user.getUnidade());
            chamadoc.setCodfuncsolic(user);
            acessoHibernate.salvar(chamadoc);

            mensagem.setNumeChamado(chamadoc.getId());
            mensagem.setData(hojeData);
            mensagem.setCodfuncautor(user);
            acessoHibernateMensagem.salvar(mensagem);

            email.setData(hojeData);
            email.setAssunto("Novo chamado por:" + user.getNome());
            email.setDestinatari("eduardo@smcaetano.com.br");

            email.setTexto(mensagem.getTexto());

            return "/index";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return "falha";
        }
    }

    public String alterarChamado(Chamadoc chamdo) {
        try {
            acessoHibernate.alterar(chamdo);
            return "";
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

}
