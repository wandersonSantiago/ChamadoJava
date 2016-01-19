package br.com.chamado.model;

import br.com.chamado.dao.DaoUsuario;
import br.com.chamado.util.Insert;

/**
 *
 * @author wandersonSantiago
 */
public class AutenticarUsuario {

    private final Usuario usuarioAutenticar;
    private Usuario usuarioDaBusca;
    private final DaoUsuario daoUsuario = new DaoUsuario();
    private boolean resultadoAutenticacao = false;
    private boolean resultadoBusca;

    public AutenticarUsuario(Usuario usuarioAutenticar) {
        this.usuarioAutenticar = usuarioAutenticar;
    }

    public void autenticarUsuario() {
        
        new Insert().gerar();
        verificarSeUsuarioExiste();
        verificarSeUsuariosSaoIguais();
        adicionarUsuarioNaSessao();
    }

    public boolean isResultadoAutenticacao() {
        return resultadoAutenticacao;
    }

    private void buscarUsuario() {
       usuarioDaBusca = daoUsuario.buscarUsuario(usuarioAutenticar);
    }

    private void verificarSeUsuarioExiste() {
        buscarUsuario();
        if (usuarioDaBusca != null) {
            resultadoBusca = true;
        } else {
            resultadoBusca = false;
        }
    }

    private void verificarSeUsuariosSaoIguais() {

        if (resultadoBusca) {
            if (usuarioAutenticar.getUsuario().equals(usuarioDaBusca.getUsuario())
                    && usuarioAutenticar.getSenha().equals(usuarioDaBusca.getSenha())) {
                resultadoAutenticacao = true;
            }
        }
    }

    private void adicionarUsuarioNaSessao() {
        if (resultadoAutenticacao) {
            SessionContext.getInstance().setAttribute("usuarioLogado", usuarioDaBusca);
        }
    }

}
