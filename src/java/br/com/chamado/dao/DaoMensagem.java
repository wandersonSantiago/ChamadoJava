package br.com.chamado.dao;

import br.com.chamado.model.Chamadoc;
import java.util.List;

/**
 *
 * @author WandersonSantiago
 */
public class DaoMensagem extends DaoGenerico{
    
   public List carregaMensagemOrdernado(Chamadoc chamado)
   {
     return carregaTudoOrdernadoUsandoHql("from Mensagem where  numchamado = " + chamado.getId());
   }
}
