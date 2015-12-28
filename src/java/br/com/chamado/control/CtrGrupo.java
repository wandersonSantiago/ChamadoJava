/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoGrupo;
import br.com.chamado.model.Grupo;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrGrupo")
@SessionScoped
public class CtrGrupo {

    private final DaoGrupo acessoHibernate;
    private Grupo grupo;

    public CtrGrupo() {
	acessoHibernate = new DaoGrupo();

    }


    public String gravarGrupo() {
	try {
	    acessoHibernate.salvar(grupo);
	    return "";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

    public String alterarGrupo(Grupo grupo) {
	try {

	    return "";
	} catch (HibernateException e) {
	    return "falaha";
	}

    }
       public String paginaAlterarGrupo(Grupo grupo) {
        try {
            this.grupo = grupo;
            return "/paginas/chamado/administrador/permissao/alterar/alterarGrupo";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public List carregarGrupo() {
	try {

	    return acessoHibernate.carregaTudoOrdernado(Grupo.class, "nome");
	} catch (HibernateException e) {
	    return null;
	}
    }
    
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
}
