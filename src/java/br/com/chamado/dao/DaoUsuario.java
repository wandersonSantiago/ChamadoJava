package br.com.chamado.dao;

import br.com.chamado.model.SessionContext;
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

    private String hql;
    private final Usuario usuarioDaSessao = SessionContext.getInstance().getUsuarioLogado();
    public Usuario buscarUsuario(Usuario usuario) {

        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("usuario", usuario.getUsuario()));
        Object obj = criteria.uniqueResult();
        transaction.commit();
        Usuario objUsuario = (Usuario) obj;
        session.close();
        return objUsuario;
    }
    public List carregaUsuarioOrdernado()
    {
      if(usuarioDaSessao.isTiCentral())
        {
           return carregaTudoOrdernado(Usuario.class,"id");
        }
        hql = "from Usuario where unidade = " + usuarioDaSessao.getUnidade().getId();
        return carregaTudoOrdernadoUsandoHql(hql);
    }
    public List carregaUsuarioTi()
    {
        if(usuarioDaSessao.isTiCentral())
        {
          hql = "from Usuario where setor =  1";
        }
        else
        {
         hql = "from Usuario where setor =  1 AND unidade = " + usuarioDaSessao.getUnidade().getId();
        }
       return carregaTudoOrdernadoUsandoHql(hql);
    }
}
