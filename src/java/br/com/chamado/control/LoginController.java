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

    private Usuario user = new Usuario();
    private boolean logado = false;
    private boolean admin = false;
    private boolean userAltera = false;
    private boolean userAtivo = false;
    private Usuario usuarioTemp = null;
    private final DaoUsuario daoUsuario = new DaoUsuario();

    public LoginController() {
    }

    public String login() {

        FacesMessage message = null;
        
        usuarioTemp = daoUsuario.buscarUsuario(user.getUsuario());

      
        if (user.getUsuario().equals(usuarioTemp.getUsuario()) && user.getSenha().equals(usuarioTemp.getSenha())) {

          logado = true;
               
              System.out.println("logado Usuario");
                
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo", user.getUsuario());
                return "index";
       

        } else {

            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Não logado", "Usuario invalido");
            return "unidade";
        }

    }
    public Usuario usuariLogado() {

        return user;

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

    public Usuario getUsuario() {
        return user;
    }

    public void setUsuario(Usuario usuario) {
        this.user = usuario;
    }
}
