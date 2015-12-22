/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrUsuario")
@SessionScoped
public class CtrUsuario {

    private final DaoUsuario acessoHibernate;
    private Usuario usuario;
   
    public CtrUsuario() {
	
	acessoHibernate = new DaoUsuario();

    }

    public String gravarUsuario() {
	try {
       
	    acessoHibernate.salvar(usuario);
	    return "index.xhtml";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

    public String alterarUsuario(Usuario usuario) {
	try {
           acessoHibernate.alterar(usuario);
	   return "";
	} catch (HibernateException e) {
	     return "falha";
	}

    }

    public List carregarUsuario() {
	try {

	    return acessoHibernate.carregaTudoOrdernado(Usuario.class, "nome");
	} catch (HibernateException e) {
	    return null;
	}
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }
    
}
