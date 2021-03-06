/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoPagina;
import br.com.chamado.model.Pagina;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "CtrPagina")
@SessionScoped
public class CtrPagina implements  Serializable{

    private final DaoPagina acessoHibernate;
    private Pagina pagina;

    public CtrPagina() {
        acessoHibernate = new DaoPagina();

    }

    public String gravarPagina() {
        try {
            acessoHibernate.salvar(pagina);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Pagina gravada"));
            return "cadastrarPaginas";
        } catch (HibernateException e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Página não gravada"));
            return "falha";
        }
    }

    public String alterarPagina() {
        try {
            acessoHibernate.alterar(pagina);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Pagina Alterada"));
            return "/paginas/chamado/administrador/permissao/cadastrarPaginas";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Pagina não Alterada"));
            return "falha";
        }

    }
     public String excluirPagina(Pagina pagina) {
        try {
            acessoHibernate.deletar(pagina);
              
            return "/paginas/chamado/administrador/permissao/cadastrarPaginas";
        } catch (HibernateException e) {
            return "falha";
        }

    }

    public String paginaAlterarPaginas(Pagina pag) {
        try {
            this.pagina = pag;
            return "/paginas/chamado/administrador/permissao/alterar/alterarPaginas";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public List carregarPagina() {
        try {

            return acessoHibernate.carregaTudoOrdernado(Pagina.class, "nomepagina");
        } catch (HibernateException e) {
            return null;
        }
    }
   

    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }

}
