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

            return "index";
        } catch (HibernateException e) {

            return "index";
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

    public List getSetores() {
        try {
            return acessoHibernateSetor.carregaTudoOrdernado(Setor.class, "nome");
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }

    public String paginaAlterarSetor(Setor setor) {
        try {
            this.setor = setor;
            return "/paginas/chamado/administrador/permissao/alterar/alterarSetor";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public String updateSetor() {
        try {
            acessoHibernateSetor.alterar(setor);

            return "/paginas/chamado/administrador/permissao/cadastrarSetor";
        } catch (HibernateException e) {
            return "falha";
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

}
