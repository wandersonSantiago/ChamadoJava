/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.dao;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class DaoEmail extends DaoGenerico{
    
   
    
    
    public List listaEmail()
    {
        Session session = hibernateConfiguracao.openSession();
        Query query = session.createQuery("from Email where enviado = false");
        List lista = query.list();
        session.close();
        
       return lista;
        
        
    }
    public String salvaList(ArrayList lista)
    {
        Session session = hibernateConfiguracao.openSession();
	Transaction transaction = session.beginTransaction();
	session.save(lista);
	transaction.commit();
	session.close();
        return "";
    }
    
    
}
