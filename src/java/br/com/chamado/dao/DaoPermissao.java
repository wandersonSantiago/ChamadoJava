/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.dao;

import br.com.chamado.model.Pagina;
import br.com.chamado.model.Permissao;
import java.util.ArrayList;


/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class DaoPermissao extends DaoGenerico{
 
    private DaoGenerico daoGenerico;
    
    public String salvarPermissao(Permissao permissao,ArrayList<Pagina> paginas)
    {
        daoGenerico = new DaoGenerico();
        for(int i = 0 ; i < paginas.size(); i++)
        {
           permissao.setPagina(paginas.get(i));
           daoGenerico.salvar(permissao);
        }
       
	
        return "index.xhtml";
    }
}
