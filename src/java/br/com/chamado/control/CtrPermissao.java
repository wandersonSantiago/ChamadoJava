/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoPermissao;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Permissao;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "ctrPermissao")
@SessionScoped
public class CtrPermissao implements Serializable {

    private final DaoPermissao acessoHibernatePermissao;
    private Permissao permissao;
    private ArrayList<Pagina> paginas;
    private Usuario usuario;

    public CtrPermissao() {
        acessoHibernatePermissao = new DaoPermissao();
    }

    public String gravarPermissao() {
        try {
            acessoHibernatePermissao.salvarPermissao(permissao, paginas);
            paginas.clear();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Permissao gravada"));
            return "/paginas/chamado/administrador/permissao/permissao";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Permissao Não gravada"));
            return "/paginas/chamado/administrador/permissao/permissao";
        }
    }

    public String updatePermissao() {
        try {

            acessoHibernatePermissao.alterarPermissao(permissao, paginas);
            paginas.clear();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Permissao Alterada"));
            return "/paginas/chamado/administrador/permissao/alterar/alterarPermissao";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Permissao não Alterada"));
            return "/paginas/chamado/administrador/permissao/alterar/alterarPermissao";
        }
    }

    public List carregarPaginasUser() {
        try {
           
            return acessoHibernatePermissao.buscarPermissoes(usuario);
        } catch (HibernateException e) {
            return new ArrayList();
        }

    }

    public String paginaAlterarPermissao(Usuario usuario) {
        try {
            this.usuario = usuario;
            return "/paginas/chamado/administrador/permissao/alterar/alterarPermissao";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public List carregarPermissao() {
        try {

            return acessoHibernatePermissao.carregaTudoOrdernado(Permissao.class, "id");
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public ArrayList<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(ArrayList<Pagina> paginas) {
        this.paginas = paginas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
