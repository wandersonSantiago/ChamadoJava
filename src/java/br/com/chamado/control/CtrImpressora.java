package br.com.chamado.control;

import br.com.chamado.dao.DaoImpressora;

import br.com.chamado.model.Impressora;

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
@ManagedBean(name = "ctrImpressora")
@SessionScoped
public class CtrImpressora implements Serializable {

    private final DaoImpressora acessoHibernateSetor;
    private Impressora impressora;

    public CtrImpressora() {
        acessoHibernateSetor = new DaoImpressora();
    }

    public String gravarImpressora() {
        try {
            acessoHibernateSetor.salvar(impressora);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Setor gravada"));
            return "";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Setor não gravada"));
            return "";
        }
    }

    public String alterarImpressora(Impressora impressora) {
        try {
            this.impressora = impressora;
            return "/paginas/chamado/";
        } catch (HibernateException e) {
            return "";
        }
    }

    public List getImpressora() {
        try {
            return acessoHibernateSetor.carregaTudoOrdernado(Impressora.class, "nome");
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }

    public String paginaAlterarImpressora(Impressora impressora) {
        try {
            this.impressora = impressora;
            return "/paginas/chamado/administrador/permissao/alterar/alterarImpressora";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public String updateImpressora() {
        try {
            acessoHibernateSetor.alterar(impressora);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Setor Alterado"));
            return "/paginas/chamado/administrador/permissao/cadastrarSetor";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Setor não Alterado"));
            return "falha";
        }

    }

    public List carregarImpressora() {
        try {

            return acessoHibernateSetor.carregaTudoOrdernado(Impressora.class, "nome");
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }



}
