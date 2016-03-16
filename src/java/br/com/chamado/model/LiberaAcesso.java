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
        return keyPaginas.containsKey("alterarPaginas");
    }

    public Boolean alterarSenhaUser() {
        return keyPaginas.containsKey("alterarSenhaUser");
    }

    public Boolean servicoImpressora() {
        return keyPaginas.containsKey("servicoImpressora");
    }

    public Boolean alterarSetor() {
        return keyPaginas.containsKey("alterarSetor");
    }

    public Boolean alterarUnidade() {
        return keyPaginas.containsKey("alterarUnidade");
    }

    public Boolean alterarUsuario() {
        return keyPaginas.containsKey("alterarUsuario");
    }

    public Boolean cadastrarPaginas() {
        return keyPaginas.containsKey("cadastrarPaginas");

    }

    public Boolean cadastrarSetor() {
        return keyPaginas.containsKey("cadastrarSetor");

    }

    public Boolean permissao() {
        return keyPaginas.containsKey("permissao");
    }

    public Boolean cadastrarUnidade() {
        return keyPaginas.containsKey("cadastrarUnidade");
    }

    public Boolean cadastrarUsuarios() {
        return keyPaginas.containsKey("cadastrarUsuarios");
    }

    public Boolean chamadoAbertoCliente() {
        return keyPaginas.containsKey("chamadoAbertoCliente");
    }

    public Boolean chamadoClienteManutenção() {
        return keyPaginas.containsKey("chamadoClienteManutenção");
    }

    public Boolean chamadoClienteTi() {
        return keyPaginas.containsKey("chamadoClienteTi");
    }

    public Boolean configuracao() {
        return keyPaginas.containsKey("configuracao");
    }

    //Não vai usar 
    public Boolean servicoEmail() {
        return keyPaginas.containsKey("servicoEmail");
    }

    public Boolean foneUnidades() {
        return keyPaginas.containsKey("foneUnidades");
    }

    public Boolean listaChamadoManutencaoParaTi() {
        return keyPaginas.containsKey("listaChamadoManutencaoParaTi");
    }

    public Boolean listaChamadoTi() {
        return keyPaginas.containsKey("listaChamadoTi");
    }

    public Boolean ramalSetor() {
        return keyPaginas.containsKey("ramalSetor");
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
        return keyPaginas.containsKey("atendeChamadoTi");
    }
      public boolean atendeChamadoManutencao() {
        return keyPaginas.containsKey("atendeChamadoManutencao");
    }
    public boolean grupoSuporte() {
        return keyPaginas.containsKey("grupoSuporte");
    }

    public boolean userRoot() {
        return keyPaginas.containsKey("root");
    }
}
