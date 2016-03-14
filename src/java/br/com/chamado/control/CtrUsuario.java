package br.com.chamado.control;

import br.com.chamado.dao.DaoPermissao;
import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.model.Permissao;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.Collections;
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
@ManagedBean(name = "ctrUsuario")
@SessionScoped
public class CtrUsuario implements  Serializable{

    private final DaoUsuario acessoHibernate;
    private Usuario usuario;
    private Permissao permissao;
   
    public CtrUsuario() {
	
	acessoHibernate = new DaoUsuario();

    }

    public String gravarUsuario() {
	try {
            acessoHibernate.salvar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Gravado"));
	    return "/paginas/chamado/administrador/usuarios/cadastrarUsuarios";
	} catch (HibernateException e) {
	    return "falha";
	}
    }

    public String alterarUsuario() {
	try {
            usuario.criptografar();
            acessoHibernate.alterar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Alterado"));
	   return "";
	} catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario não Alterado"));
	     return "";
	}

    }
    public String paginaAlterarUsuario(Usuario user) {
        try {
            this.usuario = user;
            return "/paginas/chamado/administrador/permissao/alterar/alterarUsuario";
        } catch (HibernateException e) {
            return "falha";
        }
    }
        public String paginaAlterarUsuarioPerfil(Usuario user) {
        try {
            this.usuario = user;
            return "/paginas/chamado/administrador/permissao/alterar/userAlterarDadosUsuario";
        } catch (HibernateException e) {
            return "falha";
        }
    }
    public List carregarUsuario() {
	try {
            Usuario usuarioSessao = SessionContext.getInstance().getUsuarioLogado();      
            
            new DaoPermissao().buscarPermissoes(usuarioSessao);
            return acessoHibernate.carregaUsuarioOrdernado();
         } catch (HibernateException e) {
	    
             System.out.println(e.getMessage());
             return Collections.emptyList();
	}
    }
   public List carregaUsuarioTi()
   {
         try {
             
            return acessoHibernate.carregaUsuarioTi();
         } catch (HibernateException e) {
	    
            return Collections.emptyList();
	}
   }
      public List carregaUsuarioManu()
   {
         try {
             
            return acessoHibernate.carregaUsuarioManu();
         } catch (HibernateException e) {
	    
            return Collections.emptyList();
	}
   }
    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
    
}
