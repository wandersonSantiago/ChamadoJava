package br.com.chamado.model;

import br.com.chamado.dao.DaoPermissao;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wandersonSantiago
 */
@ManagedBean(name = "liberaAcesso")
@SessionScoped

public class LiberaAcesso {

    private HashMap<String, Pagina> keyPaginas;
    private DaoPermissao daoPermissao = new DaoPermissao();

    public LiberaAcesso() {

        keyPaginas = new HashMap<String, Pagina>();
        adicionarPaginaHashMap();
    }

    private void adicionarPaginaHashMap() {
        List<Pagina> paginas = daoPermissao.buscarPermissoes(SessionContext.getInstance().getUsuarioLogado());
        for (int i = 0; i < paginas.size(); i++) {
            keyPaginas.put(paginas.get(i).getNomepagina(), paginas.get(i));
        }
    }

    //Paginas de acesso
    public Boolean alterarPaginas() {
        return keyPaginas.containsKey("root");
    }

    public Boolean alterarSenhaUser() {
        return keyPaginas.containsKey("usuario");
    }

    public Boolean servicoImpressora() {
        return keyPaginas.containsKey("suporte");
    }

    public Boolean alterarSetor() {
        return keyPaginas.containsKey("suporte");
    }

    public Boolean alterarUnidade() {
        return keyPaginas.containsKey("suporte");
    }

    public Boolean alterarUsuario() {
        return keyPaginas.containsKey("suporte");
    }

    public Boolean cadastrarPaginas() {
        return keyPaginas.containsKey("root");

    }

    public Boolean cadastrarSetor() {
        return keyPaginas.containsKey("suporte");

    }

    public Boolean permissao() {
        return keyPaginas.containsKey("suporte");
    }

    public Boolean cadastrarUnidade() {
        return keyPaginas.containsKey("root");
    }

    public Boolean cadastrarUsuarios() {
        return keyPaginas.containsKey("suporte");
    }

    public Boolean chamadoAbertoCliente() {
        return keyPaginas.containsKey("usuario");
    }

    public Boolean chamadoClienteManutenção() {
        return keyPaginas.containsKey("usuario");
    }

    public Boolean chamadoClienteTi() {
        return keyPaginas.containsKey("usuario");
    }

    public Boolean configuracao() {
        return keyPaginas.containsKey("suporte");
    }

    //Não vai usar 
    public Boolean servicoEmail() {
        return keyPaginas.containsKey("root");
    }

    public Boolean foneUnidades() {
        return keyPaginas.containsKey("usuario");
    }

    public Boolean listaChamadoManutencao() {
        return keyPaginas.containsKey("suporte");
    }

    public Boolean listaChamadoTi() {
        return keyPaginas.containsKey("usuario");
    }

    public Boolean ramalSetor() {
        return keyPaginas.containsKey("usuario");
    }

    //permissões de usuarios
    public Boolean fecharChamado() {
        return keyPaginas.containsKey("fecharChamado");
    }

    public Boolean gerenciarChamado() {
        return keyPaginas.containsKey("gerenciarChamado");
    }

    public Boolean permissaoUsuario() {
        return keyPaginas.containsKey("permissaoUsuario");
    }
    //permissão grupos

     public boolean atendeChamadoTi() {
        return keyPaginas.containsKey("atendeTi");
    }
      public boolean atendeChamadoManutencao() {
        return keyPaginas.containsKey("atendeManu");
    }
    public boolean grupoSuporte() {
        return keyPaginas.containsKey("suporte");
    }

    public boolean userRoot() {
        return keyPaginas.containsKey("root");
    }
}
