/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.dao.DaoPermissao;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Permissao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
@ManagedBean(name = "ctrPermissao")
@SessionScoped
public class CtrPermissao implements  Serializable{
    
    private final DaoPermissao acessoHibernatePermissao;
    private Permissao permissao;
    
    
    public CtrPermissao()
    {
      acessoHibernatePermissao = new DaoPermissao();
    }
    public String gravarPermissao() {
        try {
           // acessoHibernatePermissao.salvar(permissao);
            
           List<Pagina> lista = permissao.getPagina();
           
           
            return "index";
        } catch (HibernateException e) {

            return "index";
        }
    }
    public String updatePermissao() {
        try {
            acessoHibernatePermissao.alterar(permissao);

            return "index";
        } catch (HibernateException e) {
            return "falha";
        }

    }
    
    public List carregarPermissao() {
        try {

            return  acessoHibernatePermissao.carregaTudoOrdernado(Permissao.class, "id");
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
  
}
