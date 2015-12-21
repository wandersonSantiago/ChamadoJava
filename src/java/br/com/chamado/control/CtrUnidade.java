/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;




import br.com.chamado.dao.DaoUnidade;
import br.com.chamado.model.Unidade;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrUnidade")
@SessionScoped
public class CtrUnidade {
    
    
    private final  DaoUnidade acessoHibernate ;
    private Unidade unidade;
    public CtrUnidade()
    {
     acessoHibernate = new DaoUnidade();
     
    }
    public String gravarUnidade() {
	try {
	    acessoHibernate.salvar(unidade);
	   return "index";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

   
    public String alterarUnidade(Unidade Unidade)
    {
       try
       {
	   acessoHibernate.salvar(unidade);
	   return "unidade";
       }catch(HibernateException e)
       {
         return "falha";
       }
	    
    }
    public List carregarUnidade()
    {
      try
      {
	  
	 return acessoHibernate.carregaTudoOrdernado(Unidade.class, "descricao");
      }catch(HibernateException e)
      {
        return null;
      }
    }
        public List getUnidades() {
	try {
	    return acessoHibernate.carregaTudoOrdernado(Unidade.class, "descricao");
	} catch (HibernateException e) {
	    return new ArrayList();
	}
        }

    public Unidade getUnidade() {
	return unidade;
    }

    public void setUnidade(Unidade unidade) {
	this.unidade = unidade;
    }
    
}
