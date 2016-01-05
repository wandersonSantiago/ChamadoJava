package br.com.chamado.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author WandersonSantiago
 */


import br.com.chamado.util.HibernateConfiguracao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DaoGenerico {

    protected HibernateConfiguracao hibernateConfiguracao;

    public DaoGenerico() {
	hibernateConfiguracao = new HibernateConfiguracao();

    }

    public void salvar(Object obj) throws HibernateException {
    	
	Session session = hibernateConfiguracao.openSession();
	Transaction transaction = session.beginTransaction();
	session.save(obj);
	transaction.commit();
	session.close();
	
    }

    public void alterar(Object obj) {
	Session session = hibernateConfiguracao.openSession();
	Transaction transaction = session.beginTransaction();
	session.update(obj);
	transaction.commit();
	session.close();
    }

    public void deletar(Object obj) {
	Session session = hibernateConfiguracao.openSession();
	Transaction transaction = session.beginTransaction();
	session.delete(obj);
	transaction.commit();
	session.close();
    }
    public List carregaTudoOrdernado(Class classe,String ordem)
    {
          Session session = hibernateConfiguracao.openSession();
	  Criteria criterica = session.createCriteria(classe);
	  criterica.addOrder(Order.asc(ordem));
	  List lista = criterica.list();
          criterica.list();
          session.close();
	  return lista;
    }
    public List carregaTudoOrdernado(Class classe,String ordem,int unidade,int setor)
    {
      Session session = hibernateConfiguracao.openSession();
      
      Query query ;
      
      if(unidade == 1 && setor == 1)
      {
        query = session.createQuery("from "+classe.getName()+" order by " + ordem);
      }
      else
      {
       query = session.createQuery("from "+classe.getName() +" where unidade = " +unidade+ " order by " + ordem);
      }
      List lista = query.list();
      session.close();
      return lista;
        
    }
    public Object carregarUm(int id ,Class<?> classe)
    {
        Session session = hibernateConfiguracao.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(classe);
	criteria.add(Restrictions.eq("id",id));
	Object obj = criteria.uniqueResult();
	transaction.commit();
	session.close();
        return obj;
    }
   
    public boolean veriricar(String campo ,String valor,Class<?> classe)
    {
        
        Session session = hibernateConfiguracao.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(classe);
	criteria.add(Restrictions.eq(campo,valor));
	Object obj = criteria.uniqueResult();
	transaction.commit();
	session.close();
	return obj == null ? true:false;
    }
}
