package br.com.chamado.control;

import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.model.Usuario;
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
    private Usuario usuarioTemp = null;
    private final DaoUsuario daoUsuario = new DaoUsuario();

    public LoginController() {
    }

    public String login() {

        FacesMessage message = null;
        
      
        usuarioTemp = daoUsuario.buscarUsuario(usuarioLogin.getUsuario());
        
        if(usuarioTemp == null)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario", "usuário não existe na base de dados");
        }
        else {
      
        if (usuarioLogin.getUsuario().equals(usuarioTemp.getUsuario()) && usuarioLogin.getSenha().equals(usuarioTemp.getSenha())) {

          logado = true;
               
              System.out.println("logado Usuario");
               return "index";
       } else {

            
            return "index";
        }
        }
         return "index";

    }
    public Usuario usuariLogado() {

        return usuarioLogin;

    }

    public String efetuarLogout() {
       
        logado = false;
        return "index";
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
    
