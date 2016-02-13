package br.com.chamado.dao;

import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;
import java.util.List;
/**
 *
 * @author WandersonSantiago
 */
public class DaoUnidade extends DaoGenerico{
    
      private String hql;
      private final Usuario usuarioDaSessao = SessionContext.getInstance().getUsuarioLogado();
      public List carregaUnidaedOrdernado()
      {
        if(usuarioDaSessao.isTiCentral())
        {
           return carregaTudoOrdernado(Unidade.class,"id");
        }
        hql = "from Unidade where id = " + usuarioDaSessao.getUnidade().getId();
        return carregaTudoOrdernadoUsandoHql(hql);
    }
}
