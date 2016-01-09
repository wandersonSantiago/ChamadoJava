package br.com.chamado.dao;

import br.com.chamado.model.Chamadoc;
import java.util.List;

/**
 *
 * @author WandersonSantiago
 */
public class DaoMensagem extends DaoGenerico{
    
   private final DaoGenerico daoGenerico = new DaoGenerico();
   public List carregaMensagemOrdernado(Chamadoc chamado)
   {
     return daoGenerico.carregaTudoOrdernadoUsandoHql("from Mensagem where  numchamado = " + chamado.getId());
   }
}
