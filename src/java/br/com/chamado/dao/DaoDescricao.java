package br.com.chamado.dao;

import br.com.chamado.model.Descricao;
import java.util.List;

/**
 *
 * @author CRC-TICWAN e Eduardo Ferrari
 */
public class DaoDescricao extends DaoGenerico {

    private DaoGenerico daoGenerico  = new DaoGenerico();
    
    private String hql;

    public List carregarDescricao(int tipo) {

        hql = "from Descricao where tipo = " + tipo;
        return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);

    }
    public Descricao carregarStatus(int id)
    {
        hql = "from Descricao where id = " + id + " and tipo = 2";
        Descricao status = (Descricao) daoGenerico.carregaUm(hql);
        return status;
        
    }
}
