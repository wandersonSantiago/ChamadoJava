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
           System.out.println("Gravando OK");
 	    acessoHibernate.salvar(usuario);
	    return "index";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

    public String alterarUsuario() {
	try {
           acessoHibernate.alterar(usuario);
	   return "/paginas/chamado/administrador/usuarios/cadastrarUsuarios";
	} catch (HibernateException e) {
	     return "falha";
	}

    }
    public String paginaAlterarUsuario(Usuario user) {
        try {
            this.usuario = user;
            return "/paginas/chamado/administrador/permissao/alterar/alterarUsuario";
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
