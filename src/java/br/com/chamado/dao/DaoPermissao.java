package br.com.chamado.dao;

import br.com.chamado.model.Pagina;
import br.com.chamado.model.Permissao;
import br.com.chamado.model.Usuario;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class DaoPermissao extends DaoGenerico{
 
    private DaoGenerico daoGenerico;
    private String hql;
    public String salvarPermissao(Permissao permissao,ArrayList<Pagina> paginas)
    {
        daoGenerico = new DaoGenerico();
        for(int i = 0 ; i < paginas.size(); i++)
        {
           permissao.setPagina(paginas.get(i));
           daoGenerico.salvar(permissao);
        }
       return "index.xhtml";
    }
    public List buscarPermissoes(Usuario usuarioSessao)
    {
        hql = "from Permissao where codusuario = " + usuarioSessao.getId();
        return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);
    }
}
