/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.dao;

import br.com.chamado.model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author WandersonSantiago
 */
public class DaoUsuario extends DaoGenerico {

    public Usuario buscarUsuario(String usuario) {

        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        Object obj = criteria.uniqueResult();
        transaction.commit();

        Usuario objUsuario = (Usuario) obj;
        session.close();
        return objUsuario;
    }

}
