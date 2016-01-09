package br.com.chamado.dao;

import br.com.chamado.model.Setor;
import br.com.chamado.model.Usuario;
import java.util.List;

/**
 *
 * @author Wanderson Santiago
 */
public class DaoSetor extends  DaoGenerico{
    
   private final DaoGenerico daoGenerico = new DaoGenerico();
   private String hql;
   public List carregaSetorrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return new DaoGenerico().carregaTudoOrdernado(Setor.class,"id");
        }
        hql ="";
        return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);
    }
}
