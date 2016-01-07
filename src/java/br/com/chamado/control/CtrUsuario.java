/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.Collections;
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
public class CtrUsuario implements  Serializable{

    private final DaoUsuario acessoHibernate;
    private Usuario usuario;
   
    public CtrUsuario() {
	
	acessoHibernate = new DaoUsuario();

    }

    public String gravarUsuario() {
	try {
            usuario.criptografar();
 	    acessoHibernate.salvar(usuario);
	    return "index";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

    public String alterarUsuario() {
	try {
            usuario.criptografar();
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
            Usuario usuarioSessao = SessionContext.getInstance().getUsuarioLogado();      
            return acessoHibernate.carregaUsuarioOrdernado(usuarioSessao);
         } catch (HibernateException e) {
	    
            return Collections.emptyList();
	}
    }
   public List carregaUsuarioTi()
   {
         try {
            Usuario usuarioSessao = SessionContext.getInstance().getUsuarioLogado();      
            return acessoHibernate.carregaUsuarioTi(usuarioSessao);
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
    
}
