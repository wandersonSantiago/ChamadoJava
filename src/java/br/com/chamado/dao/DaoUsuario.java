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
    public List carregaUsuarioOrdernado(Usuario usuarioSessao)
    {
      if(usuarioSessao.isTiCentral())
        {
           return new DaoGenerico().carregaTudoOrdernado(Usuario.class,"id");
        }
        Session session = hibernateConfiguracao.openSession();
        Query query = session.createQuery("from Usuario where unidade = " + usuarioSessao.getUnidade().getId());
        List lista = query.list();
        session.close();
        return lista;
    }

}
