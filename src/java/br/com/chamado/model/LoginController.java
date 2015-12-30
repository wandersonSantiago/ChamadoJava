package br.com.chamado.model;

import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Usuario;
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
    }

    public String login() {

        FacesMessage message = null;

        usuarioTemp = daoUsuario.buscarUsuario(usuarioLogin.getUsuario());

        if (usuarioTemp == null) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario", "usuário não existe na base de dados");
        } else if (usuarioLogin.getUsuario().equals(usuarioTemp.getUsuario()) && usuarioLogin.getSenha().equals(usuarioTemp.getSenha())) {

            logado = true;

            return "index";
        } else {

            return "erroAcesso";
        }
        return "erroAcesso";
    }
/*
    public Boolean userPermissão(Pagina pagina){
       if(usuarioLogin.getGrupo().equals(pagina))
    {
           return true;
       }
        
        return false;
       
    }
    */
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
