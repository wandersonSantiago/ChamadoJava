package br.com.chamado.dao;

import br.com.chamado.model.Setor;
import br.com.chamado.model.Usuario;
import java.util.List;

/**
 *
 * @author Wanderson Santiago
 */
public class DaoSetor extends  DaoGenerico{
    
   private String hql;
   public List carregaSetorrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return carregaTudoOrdernado(Setor.class,"id");
        }
        hql ="";
        return carregaTudoOrdernadoUsandoHql(hql);
    }
}
