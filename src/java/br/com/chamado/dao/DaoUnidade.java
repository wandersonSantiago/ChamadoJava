/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.dao;


import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author WandersonSantiago
 */
public class DaoUnidade extends DaoGenerico{
    
    
    
      public List carregaUnidaedOrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return new DaoGenerico().carregaTudoOrdernado(Unidade.class,"id");
        }
        Session session = hibernateConfiguracao.openSession();
        Query query = session.createQuery("from Unidade where id = " + usuario.getUnidade().getId());
        List lista = query.list();
        session.close();
        return lista;
    }
}
