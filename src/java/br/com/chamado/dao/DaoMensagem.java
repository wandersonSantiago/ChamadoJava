/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.dao;

import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author WandersonSantiago
 */
public class DaoMensagem extends DaoGenerico{
    
   public List carregaMensagemOrdernado(Chamadoc chamado)
      {
        
        Session session = hibernateConfiguracao.openSession();
        Query query = session.createQuery("from Mensagem where  numchamado = " + chamado.getId());
        List lista = query.list();
        session.close();
        return lista;
    }
}
