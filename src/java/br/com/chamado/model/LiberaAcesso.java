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

       keyPaginas = new HashMap<String,Pagina>();
       adicionarPaginaHashMap();
    }
    private void adicionarPaginaHashMap()
    {
      List<Pagina> paginas = daoPermissao.buscarPermissoes(SessionContext.getInstance().getUsuarioLogado());
      for(int i = 0 ; i < paginas.size(); i++)
      {
        keyPaginas.put(paginas.get(i).getNomepagina(), paginas.get(i));
      }
    }
    public Boolean alterarPaginas() {
        return  keyPaginas.containsKey("alterarPaginas.xhtml");
    }

    public Boolean alterarSetor() {
        return  keyPaginas.containsKey("alterarSetor.xhtml");
    }

    public Boolean alterarUnidade() {
      return  keyPaginas.containsKey("alterarUnidade.xhtml");
    }

    public Boolean alterarUsuario() {
      return  keyPaginas.containsKey("alterarUsuario.xhtml");
    }

    public Boolean cadastrarPaginas() {
      return  keyPaginas.containsKey("cadastrarPaginas.xhtml");
       
    }

    public Boolean cadastrarSetor() {
         return  keyPaginas.containsKey("cadastrarSetor.xhtml");
         
    }

    public Boolean permissao() {
         return  keyPaginas.containsKey("permissao.xhtml");
    }

    public Boolean cadastrarUnidade() {
        return  keyPaginas.containsKey("unidade.xhtml");
    }

    public Boolean cadastrarUsuarios() {
         return  keyPaginas.containsKey("cadastrarUsuarios.xhtml");
    }

    public Boolean chamadoAbertoCliente() {
        return  keyPaginas.containsKey("chamadoAbertoCliente.xhtml");
    }

    public Boolean chamadoClienteManutenção() {
       return  keyPaginas.containsKey("chamadoClienteManutencao.xhtml");
    }

    public Boolean chamadoClienteTi() {
        return  keyPaginas.containsKey("chamadoClienteTi.xhtml");
    }

    public Boolean configuracao() {
         return  keyPaginas.containsKey("configuracao.xhtml");
    }
    //Não vai usar 
    public Boolean servicoEmail() {
       return  keyPaginas.containsKey("servicoemail.xhtml");
    }

    public Boolean foneUnidades() {
        return  keyPaginas.containsKey("foneUnidades.xhtml");
    }

    public Boolean listaChamadoManutencao() {
        return  keyPaginas.containsKey("listaChamadoManutencao.xhtml");
    }

    public Boolean listaChamadoTi() {
        return  keyPaginas.containsKey("listaChamadoTi.xhtml");
    }

    public Boolean ramalSetor() {
        return  keyPaginas.containsKey("ramalSetor.xhtml");
    }
}
