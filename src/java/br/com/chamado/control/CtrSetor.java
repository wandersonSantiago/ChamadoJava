package br.com.chamado.control;

import br.com.chamado.dao.DaoSetor;
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
@ManagedBean(name = "ctrSetor")
@SessionScoped
public class CtrSetor implements Serializable {

    private final DaoSetor acessoHibernateSetor;
    private Setor setor;

    public CtrSetor() {
        acessoHibernateSetor = new DaoSetor();
    }

    public String gravarSetor() {
        try {
            acessoHibernateSetor.salvar(setor);
            setor.limpar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Setor gravada"));
            return "/paginas/chamado/administrador/permissao/cadastrarSetor";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Setor não gravada"));
            return "/paginas/chamado/administrador/permissao/cadastrarSetor";
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
            setor.limpar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Setor Alterado"));
            return "/paginas/chamado/administrador/permissao/cadastrarSetor";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Setor não Alterado"));
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
