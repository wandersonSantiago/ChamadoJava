package br.com.chamado.dao;

import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;
import java.util.List;
/**
 *
 * @author WandersonSantiago
 */
public class DaoUnidade extends DaoGenerico{
    
    
      private final DaoGenerico daoGenerico = new DaoGenerico();
      private String hql;
      public List carregaUnidaedOrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return new DaoGenerico().carregaTudoOrdernado(Unidade.class,"id");
        }
        hql = "from Unidade where id = " + usuario.getUnidade().getId();
        return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);
    }
}
