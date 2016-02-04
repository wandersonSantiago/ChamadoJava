package br.com.chamado.dao;

import java.util.List;

/**
 *
 * @author CRC-TICWAN e Eduardo Ferrari
 */
public class DaoDescricao extends DaoGenerico {

    private DaoGenerico daoGenerico = new DaoDescricao();
    
    private String hql;

    public List carregaDescricao(int tipo) {

        hql = "from Descricao where tipo = " + tipo;
        return daoGenerico.carregaTudoOrdernadoUsandoHql(hql);

    }
}
