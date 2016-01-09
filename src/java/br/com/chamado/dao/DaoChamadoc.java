 package br.com.chamado.dao;

import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Usuario;
import java.util.List;
/**
 *
 * @author WandersonSantiago 
 */
public class DaoChamadoc extends DaoGenerico{
    
      private final DaoGenerico daoGenerico = new DaoGenerico();
      private String hql;
      public List carregaChamadoOrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return daoGenerico.carregaTudoOrdernado(Chamadoc.class,"id");
        }
        hql = "from Chamadoc where  codfuncsolic = " + usuario.getId();
        return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);
    }
}
