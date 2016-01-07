 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.dao;


import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author WandersonSantiago 
 */
public class DaoChamadoc extends DaoGenerico{
    
     /* public List carregaStatus(int status)
      { 
        Session session = hibernateConfiguracao.openSession();
	Criteria criteria = session.createCriteria(Chamadoc.class);
	criteria.add(Restrictions.eq("status",status));
	List list = criteria.list();
        session.close();
	return list;
       }*/
       public List carregaChamadoOrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return new DaoGenerico().carregaTudoOrdernado(Chamadoc.class,"id");
        }
        Session session = hibernateConfiguracao.openSession();
        Query query = session.createQuery("from Chamadoc where  codfuncsolic = " + usuario.getId());
        List lista = query.list();
        session.close();
        return lista;
    }
}
