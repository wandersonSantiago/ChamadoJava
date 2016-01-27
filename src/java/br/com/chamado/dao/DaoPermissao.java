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
    public List<Pagina> buscarPermissoes(Usuario usuarioSessao)
    {
        daoGenerico = new DaoGenerico();
        hql = "from Permissao where codusuario =" + usuarioSessao.getId();
        List permissoes = daoGenerico.carregaTudoOrdernadoUsandoHql(hql);
        List paginas = new ArrayList<Pagina>();
        for(int i = 0 ; i < permissoes.size(); i++)
        {
           Permissao permissao = (Permissao) permissoes.get(i);
           paginas.add(permissao.getPagina());
        }
        return paginas;
    }
}
