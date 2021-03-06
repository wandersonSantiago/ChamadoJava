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
 
    
    private String hql;
    public String salvarPermissao(Permissao permissao,ArrayList<Pagina> paginas)
    {
       
        for(int i = 0 ; i < paginas.size(); i++)
        {
           permissao.setPagina(paginas.get(i));
           salvar(permissao);
           
        }
       return "index";
    }
    
        public String alterarPermissao(Permissao permissao,ArrayList<Pagina> paginas)
    {
        
        for(int i = 0 ; i < paginas.size(); i++)
        {
           permissao.setPagina(paginas.get(i));
           alterar(permissao);
        }
       return "index";
    }
    public List<Pagina> buscarPermissoes(Usuario usuarioSessao)
    {
        
        hql = "from Permissao where codusuario =" + usuarioSessao.getId();
        List permissoes = carregaTudoOrdernadoUsandoHql(hql);
        List paginas = new ArrayList<Pagina>();
        for(int i = 0 ; i < permissoes.size(); i++)
        {
           Permissao permissao = (Permissao) permissoes.get(i);
           paginas.add(permissao.getPagina());
         
        }
        return paginas;
        
    }
}
