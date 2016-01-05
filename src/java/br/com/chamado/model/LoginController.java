package br.com.chamado.model;

import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Usuario;
import br.com.chamado.util.Insert;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wandersonSantiago
 */
@ManagedBean(name = "ctrLogin")
@SessionScoped
public class LoginController {

    private Usuario usuarioLogin = new Usuario();
    private boolean logado = false;
    private List listPermissão;
    private Usuario usuarioTemp = null;
    private final DaoUsuario daoUsuario = new DaoUsuario();

    public LoginController() {
   
        Insert insert  = new Insert();
        insert.gerar();
        }

    public String login() {

       
       usuarioTemp = daoUsuario.buscarUsuario(usuarioLogin.getUsuario());
       
      
        usuarioLogin.criptografar();
        if (usuarioTemp == null) {
           
        } else if (usuarioLogin.getUsuario().equals(usuarioTemp.getUsuario()) && usuarioLogin.getSenha().equals(usuarioTemp.getSenha())) {

             SessionContext.getInstance().setAttribute("usuarioLogado", usuarioTemp);
            logado = true;

            return "index";
        } else {

            return "erroAcesso";
        }
        return "erroAcesso";
    }
  
    public Usuario usuariLogado() {

        return usuarioLogin;

    }

    public String efetuarLogout() {

        logado = false;
        return "/login";
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

}
