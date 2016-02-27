package br.com.chamado.control;

import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eduardo
 */
@ManagedBean(name = "controleSessao")
@SessionScoped
public class ControleSessao {
    
    
    private final Usuario usuarioDaSessao = SessionContext.getInstance().getUsuarioLogado();
    public Usuario getUsuarioDaSessao() {
        return usuarioDaSessao;
    }

    
}
