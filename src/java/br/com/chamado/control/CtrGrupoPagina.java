/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoGrupoPagina;
import br.com.chamado.model.GrupoPagina;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "CtrGrupoPagina")
@SessionScoped
public class CtrGrupoPagina {

    private final DaoGrupoPagina acessoHibernate;
    private GrupoPagina grupoPagina;
    public CtrGrupoPagina() {
	acessoHibernate = new DaoGrupoPagina();

    }

    public String gravarGrupo() {
	try {
            acessoHibernate.salvar(grupoPagina);
	    return "";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

    public String alterarGrupopagina(GrupoPagina grupoPagina) {
	try {
            acessoHibernate.alterar(grupoPagina);
	    return "";
	} catch (HibernateException e) {
	    return "falha";
	}

    }

    public List carregarGrupoPaginao() {
	try {

	    return acessoHibernate.carregaTudoOrdernado(GrupoPagina.class, "nome");
	} catch (HibernateException e) {
	    return null;
	}
    }
}
