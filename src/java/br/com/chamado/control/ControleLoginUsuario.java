package br.com.chamado.control;

import br.com.chamado.model.AutenticarUsuario;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
            return "index";
        }
        return "erroAcesso";
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
