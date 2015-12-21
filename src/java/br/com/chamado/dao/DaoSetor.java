package br.com.chamado.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.chamado.dao.DaoGenerico;
import br.com.chamado.model.Setor;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wanderson Santiago
 */
public class DaoSetor extends  DaoGenerico{
    
    
     public boolean verifcarIntegridade(Setor s)
    {
	Session session = hibernateConfiguracao.openSession();
        
        Query query = session.createQuery("from Unidade where setor = :id"); 
        query.setParameter("id", s);
        
	Query query2 = session.createQuery("from Usuario where setor = :id"); 
	query2.setParameter("id", s);
	
	List lista = query.list();
        List lista2 = query2.list();
     
      
       if(lista.size() > 0 || lista2.size() > 0)
      {
	  return true;
      }
      else
      {
         return false;
      }
    }
}
