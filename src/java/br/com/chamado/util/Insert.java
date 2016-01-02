/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.util;

import br.com.chamado.dao.DaoGenerico;
import br.com.chamado.model.Setor;
import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;

/**
 *
 * @author Eduardo de Godoy Ferrari 
 */
public class Insert {
    
    private final DaoGenerico acessoHibernate ;
    
    public Insert()
    {
       acessoHibernate = new DaoGenerico();
    }
    
    public void gerar()
    {
        if(acessoHibernate.veriricar("usuario", "root", Usuario.class))
        {
            
            Setor setor = new Setor();
            setor.setNome("Tecnologia da informacao");
            setor.setRamal(999);
            acessoHibernate.salvar(setor);
            
            Unidade unidade = new Unidade();
            
            unidade.setBairro("Seu Bairro");
            unidade.setCidade("Sua Cidade");
            unidade.setEndereco("Seu Endereco");
            unidade.setFoneDiretor("0000000000");
            unidade.setFonePabx("0000000000");
            unidade.setMneumonico("informacao");
            unidade.setNome("Seu nome");
            acessoHibernate.salvar(unidade);
            
            
            Usuario usuario = new Usuario();
            usuario.setId(1);
            usuario.setNome("Root");
            usuario.setUsuario("root");
            usuario.setSenha("root1989");
            usuario.criptografar();
            usuario.setSetor(setor);
            usuario.setUnidade(unidade);
            usuario.setEmail("root@seuemail.com.br");
            
            acessoHibernate.salvar(usuario);
            
        }
    }
       
    
    
}
