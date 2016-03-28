package br.com.chamado.dao;

import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.util.List;

/**
 *
 * @author WandersonSantiago
 */
public class DaoChamadoc extends DaoGenerico {

    private String hql;
    private Usuario usuarioSessao = SessionContext.getInstance().getUsuarioLogado();

    public List carregaChamadoOrdernado() {
  
        if (usuarioSessao.isTiCentral()) {
        
            return carregaTudoOrdernado(Chamadoc.class, "id");
        
        } else if (usuarioSessao.isTi()) {
        
            hql = "from Chamadoc where unidade = " + usuarioSessao.getUnidade().getId() + "AND tipoChamado = 12" + "OR tipoChamado = 14 order by status, prioridade desc, data desc ";
           
            return carregaTudoOrdernadoUsandoHql(hql);
       
        } else if (usuarioSessao.isManutencao()) {

            hql = "from Chamadoc where unidade = " + usuarioSessao.getUnidade().getId() + "AND tipoChamado = 13" + "OR codfuncsolic = " + usuarioSessao.getId() + "order by status, prioridade, data desc ";
        
            return carregaTudoOrdernadoUsandoHql(hql);
        
        } else {
         
            hql = "from Chamadoc where  codfuncsolic = " + usuarioSessao.getId() + "order by status, prioridade desc, data desc";
            
            return carregaTudoOrdernadoUsandoHql(hql);

        }
    }

    public List carregaChamadoOrdernadoChamadoTi() {

        hql = "from Chamadoc where unidade = " + usuarioSessao.getUnidade().getId() + "AND tipoChamado = 13" + "OR codfuncsolic = " + usuarioSessao.getId() + "order by status, prioridade, data desc ";

        return carregaTudoOrdernadoUsandoHql(hql);
    }

}
