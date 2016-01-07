/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoUnidade;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
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
@ManagedBean(name = "ctrUnidade")
@SessionScoped
public class CtrUnidade implements  Serializable{

    private final DaoUnidade acessoHibernate;
    private Unidade unidade;

    public CtrUnidade() {
        acessoHibernate = new DaoUnidade();

    }

    public String gravarUnidade() {
        try {
            acessoHibernate.salvar(unidade);
            return "/paginas/chamado/administrador/permissao/unidade";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public String alterarUnidade() {
        try {
            acessoHibernate.alterar(unidade);
             FacesMessage mensagem = new FacesMessage("Unidade Alterado", "Alterado");
	    FacesContext.getCurrentInstance().addMessage("From:message", mensagem);
            return "/paginas/chamado/administrador/permissao/unidade";
        } catch (HibernateException e) {
            return "falha";
        }

    }

    public String paginaAlterarUnidade(Unidade unidade) {
        try {
            this.unidade = unidade;
            return "/paginas/chamado/administrador/permissao/alterar/alterarUnidade";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public List carregarUnidade() {
        try {
            Usuario usuarioSessao = SessionContext.getInstance().getUsuarioLogado();
            return acessoHibernate.carregaUnidaedOrdernado(usuarioSessao);
            //return acessoHibernate.carregaTudoOrdernado(Unidade.class, "nome");
          
        } catch (HibernateException e) {
            return null;
        }
    }
        public List getUnidades() {
        try {

            return acessoHibernate.carregaTudoOrdernado(Unidade.class, "nome");
        } catch (HibernateException e) {
            return null;
        }
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

}
