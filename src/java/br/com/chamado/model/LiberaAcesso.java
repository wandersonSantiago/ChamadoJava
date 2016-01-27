/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        return true;
    }

    public Boolean alterarSetor() {
        return true;
    }

    public Boolean alterarUnidade() {
        return true;
    }

    public Boolean alterarUsuario() {
        return true;
    }

    public Boolean cadastrarPaginas() {
      return  keyPaginas.containsKey("cadastrarPaginas.xhtml");
       
    }

    public Boolean cadastrarSetor() {
         return  keyPaginas.containsKey("");
    }

    public Boolean permissao() {
         return  keyPaginas.containsKey("");
    }

    public Boolean cadastrarUnidade() {
        return  keyPaginas.containsKey("");
    }

    public Boolean cadastrarUsuarios() {
         return  keyPaginas.containsKey("");
    }

    public Boolean chamadoAbertoCliente() {
        return true;
    }

    public Boolean chamadoClienteManutenção() {
        return true;
    }

    public Boolean chamadoClienteTi() {
        return true;
    }

    public Boolean configuracao() {
         return  keyPaginas.containsKey("");
    }

    public Boolean servicoEmail() {
        return true;
    }

    public Boolean foneUnidades() {
        return true;
    }

    public Boolean listaChamadoManutencao() {
        return true;
    }

    public Boolean listaChamadoTi() {
        return true;
    }

    public Boolean ramalSetor() {
        return true;
    }
}
