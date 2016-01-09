package br.com.chamado.dao;

import br.com.chamado.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author WandersonSantiago
 */
public class DaoUsuario extends DaoGenerico {

    private final DaoGenerico daoGenerico = new DaoGenerico();
    private String hql;
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
           return daoGenerico.carregaTudoOrdernado(Usuario.class,"id");
        }
        hql = "from Usuario where unidade = " + usuarioSessao.getUnidade().getId();
        return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);
    }
    public List carregaUsuarioTi(Usuario usuarioSessao)
    {
        if(usuarioSessao.isTiCentral())
        {
          hql = "from Usuario where setor =  1";
        }
        else
        {
         hql = "from Usuario where setor =  1 AND unidade = " + usuarioSessao.getUnidade().getId();
        }
       return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);
    }
}
