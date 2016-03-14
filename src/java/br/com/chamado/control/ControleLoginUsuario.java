package br.com.chamado.control;

import br.com.chamado.model.AutenticarUsuario;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrLogin")
@SessionScoped
public class ControleLoginUsuario {

    private Usuario loginUsuario = new Usuario();
    private AutenticarUsuario autenticar;
    private boolean logado = false;

    public String autenticar() {

        loginUsuario.criptografar();
        autenticar = new AutenticarUsuario(loginUsuario);
        autenticar.autenticarUsuario();
        
        if(autenticar.isResultadoAutenticacao()){
            logado = true;
            autenticar = null;
            loginUsuario = null;
            return "index";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario ou senha inválido"));
        return "";
    }

    public Usuario usuariLogado() {

        return loginUsuario;
    }
    public String efetuarLogout() {

        SessionContext.getInstance().encerrarSessao();
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
        return loginUsuario;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.loginUsuario = usuarioLogin;
    }
}
