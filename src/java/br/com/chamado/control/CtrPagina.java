/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoPagina;
import br.com.chamado.model.Pagina;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "CtrPagina")
@SessionScoped
public class CtrPagina {
    
    private final DaoPagina acessoHibernate;
    private Pagina pagina;

    

    public CtrPagina() {
	acessoHibernate = new DaoPagina();
	
    }

    public String gravarPagina() {
	try {
	    acessoHibernate.salvar(pagina);
	    return "";
	} catch (HibernateException e) {
	    return "falha";
	}
    }
    
    public String alterarPagina(Pagina pagina) {
	try {
	    acessoHibernate.alterar(pagina);
	    return "";
	} catch (HibernateException e) {
	    return "falha";
	}
	
    }

    public List carregarPagina() {
	try {
	    
	    return acessoHibernate.carregaTudoOrdernado(Pagina.class, "nome");
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
