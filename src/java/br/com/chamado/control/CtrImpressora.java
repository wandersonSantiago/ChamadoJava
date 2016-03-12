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
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Impressora gravada"));
            return "";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Impressora não gravada"));
            return "";
        }
    }

    public String alterarImpressora() {
        try {
            
            acessoHibernateSetor.alterar(impressora);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Impressora alterada"));
           
            return "/paginas/chamado/administrador/permissao/cadastrarImpressora";
        } catch (HibernateException e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Impressora NÃO alterada"));
           
            return "";
        }
    }

    public List Impressora() {
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
        public String paginaCadastrarOrdemServiço(Impressora impressora) {
        try {
            this.impressora = impressora;
            return "/paginas/chamado/cadastrar/servicoImpressora";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public String updateImpressora() {
        try {
            acessoHibernateSetor.alterar(impressora);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "ordem de serviço / contador cadastrado SUCESSO"));
            return "/paginas/chamado/lista/impressora";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ordem de serviço / contador não cadastrado"));
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

    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
    }



}
