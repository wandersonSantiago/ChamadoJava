package br.com.chamado.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.chamado.dao.DaoSetor;
import br.com.chamado.model.Setor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;

/**
 *
 * @author wandersonSantiago
 */
@ManagedBean(name = "ctrSetor")
@SessionScoped
public class CtrSetor {

    private final DaoSetor acessoHibernateSetor;
    private Setor setor;

    public CtrSetor() {
	acessoHibernateSetor = new DaoSetor();
    }

    public String gravarSetor() {
	try {
	    acessoHibernateSetor.salvar(setor);
	    
	    FacesMessage mensagem = new FacesMessage("Setor Salvo", "Concluido");
	    FacesContext.getCurrentInstance().addMessage("From:message", mensagem);
	    limpar();
	    return "/cadastrar/cadastrarSetor";
	} catch (HibernateException e) {
	     
	     FacesMessage message = new FacesMessage("Erro na hora de salvar!!","Erro");
             FacesContext.getCurrentInstance().addMessage("form:message", message); 
	    return "/cadastrar/cadastrarSetor";
	}
    }

    public String excluirSetor(Setor setor) {
	try {

	    if (acessoHibernateSetor.verifcarIntegridade(setor) == false) {
		acessoHibernateSetor.deletar(setor);
		return "/pesquisar/pesquisaSetor";
	    } else {
		FacesMessage mensagem = new FacesMessage("Setor não pode ser Excluido", "Erro");
		FacesContext.getCurrentInstance().addMessage("From:message", mensagem);
		return "/pesquisar/pesquisaSetor";
	    }

	} catch (HibernateException e) {
	    return "falha";
	}

    }

    public String alterarSetor(Setor setor) {
	try {
	    this.setor = setor;
	    return "/alterar/alterarSetor";
	} catch (HibernateException e) {
	    return "falha";
	}

    }

    public String updateSetor() {
	try {
	    acessoHibernateSetor.alterar(setor);

	    FacesMessage mensagem = new FacesMessage("Setor Alterado", "Concluido");
	    FacesContext.getCurrentInstance().addMessage("From:message", mensagem);
	    return "/alterar/alterarSetor";
	} catch (HibernateException e) {
	    return "falha";
	}

    }

    public List getSetores() {
	try {
	    return acessoHibernateSetor.carregaTudoOrdernado(Setor.class, "nome");
	} catch (HibernateException e) {
	    return new ArrayList();
	}
    }

    public List carregarSetor() {
	try {

	    return acessoHibernateSetor.carregaTudoOrdernado(Setor.class, "nome");
	} catch (HibernateException e) {
	    return new ArrayList();
	}
    }

    public Setor getSetor() {
	return setor;
    }

    public void setSetor(Setor setor) {
	this.setor = setor;
    }

    public void limpar() {

	this.setor.setNome("  ");
        //this.setor.setQtFuncionario();
	//this.setor.setRamal(00);
	
    }
}
