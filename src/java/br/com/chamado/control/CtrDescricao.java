package br.com.chamado.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.chamado.dao.DaoDescricao;
import br.com.chamado.dao.DaoSetor;
import br.com.chamado.model.Descricao;
import br.com.chamado.model.Setor;
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
 * @author wandersonSantiago
 */
@ManagedBean(name = "ctrDescricao")
@SessionScoped
public class CtrDescricao implements  Serializable{

    private final DaoDescricao acessoHibernateDescricao;
    private Descricao descricao;

    public CtrDescricao() {
        acessoHibernateDescricao = new DaoDescricao();
    }

    public String gravarDescrcao() {
        try {
            acessoHibernateDescricao.salvar(descricao);

            return "index";
        } catch (HibernateException e) {

            return "index";
        }
    }

    public String alterarDescricao(Descricao descricao) {
        try {
            this.descricao = descricao;
            return "index";
        } catch (HibernateException e) {
            return "falha";
        }
    }
   public String paginaAlterarDescricao(Descricao descricao) {
        try {
            this.descricao = descricao;
            return "index";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public String updateDescricao() {
        try {
            acessoHibernateDescricao.alterar(descricao);

            return "index";
        } catch (HibernateException e) {
            return "falha";
        }

    }
            public List getDescricaos() {
        try {

            return acessoHibernateDescricao.carregaTudoOrdernado(Descricao.class, "descricao");
        } catch (HibernateException e) {
            return null;
        }
    }

    public List carregarDescricao(int tipo) {
        try {
        
            return  acessoHibernateDescricao.carregaDescricao(tipo);
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }
    

}
