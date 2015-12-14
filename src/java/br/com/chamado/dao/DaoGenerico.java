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
	
	if(obj == null)
	{
	   return true;
	}
	else
	{
	    return false;
	}
    }
}
