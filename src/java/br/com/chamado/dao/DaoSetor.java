package br.com.chamado.dao;

import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Setor;
import br.com.chamado.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wanderson Santiago
 */
public class DaoSetor extends  DaoGenerico{
    
    
   public List carregaSetorrdernado(Usuario usuario)
      {
        if(usuario.isTiCentral())
        {
           return new DaoGenerico().carregaTudoOrdernado(Setor.class,"id");
        }
        Session session = hibernateConfiguracao.openSession();
        Query query = session.createQuery("");
        List lista = query.list();
        session.close();
        return lista;
    }
}
