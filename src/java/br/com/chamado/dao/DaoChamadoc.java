 package br.com.chamado.dao;

import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Usuario;
import java.util.List;
/**
 *
 * @author WandersonSantiago 
 */
public class DaoChamadoc extends DaoGenerico{
    
      private String hql;
      public List carregaChamadoOrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return carregaTudoOrdernado(Chamadoc.class,"id");
        }
        else if(usuario.isTi())
        {
           hql = "from Chamadoc where unidade = " + usuario.getUnidade().getId();
           return carregaTudoOrdernadoUsandoHql(hql);
        }
        else
        {
        hql = "from Chamadoc where  codfuncsolic = " + usuario.getId();
        return carregaTudoOrdernadoUsandoHql(hql);
        }
    }
}
