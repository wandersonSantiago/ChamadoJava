package br.com.chamado.control;

import br.com.chamado.dao.DaoUnidade;
import br.com.chamado.model.Unidade;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrUnidade")
@SessionScoped
public class CtrUnidade implements  Serializable{

    private final DaoUnidade acessoHibernate;
    private Unidade unidade;

    public CtrUnidade() {
        acessoHibernate = new DaoUnidade();

    }

    public String gravarUnidade() {
        try {
            acessoHibernate.salvar(unidade);
            unidade.limpar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Unidade gravada"));
            return "/paginas/chamado/administrador/permissao/unidade";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Unidade não gravada"));
            return "falha";
        }
    }

    public String alterarUnidade() {
        try {
            acessoHibernate.alterar(unidade);
            unidade.limpar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Unidade Alterada"));
            return "/paginas/chamado/administrador/permissao/unidade";
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Unidade não Alterada"));
            return "falha";
        }

    }

    public String paginaAlterarUnidade(Unidade unidade) {
        try {
            this.unidade = unidade;
            return "/paginas/chamado/administrador/permissao/alterar/alterarUnidade";
        } catch (HibernateException e) {
            return "falha";
        }
    }

    public List carregarUnidade() {
        try {
            return acessoHibernate.carregaUnidaedOrdernado();
           } catch (HibernateException e) {
            return null;
        }
    }
        public List getUnidades() {
        try {

            return acessoHibernate.carregaTudoOrdernado(Unidade.class, "nome");
        } catch (HibernateException e) {
            return null;
        }
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

}
