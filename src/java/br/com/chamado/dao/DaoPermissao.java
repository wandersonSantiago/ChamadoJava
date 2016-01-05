/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.dao;

import br.com.chamado.model.Pagina;
import br.com.chamado.model.Permissao;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class DaoPermissao extends DaoGenerico{
 
    public String salvar(Permissao permissao,ArrayList<Pagina> lista)
    {
        for(int i = 0 ; i < lista.size(); i++)
        {
            Session session = hibernateConfiguracao.openSession();
            Transaction transaction = session.beginTransaction();
	    permissao.setPagina(lista.get(i));
            session.save(permissao);
	    transaction.commit();  
            session.close(); 
        }
        lista = null;
	
        return "index.xhtml";
    }
}
