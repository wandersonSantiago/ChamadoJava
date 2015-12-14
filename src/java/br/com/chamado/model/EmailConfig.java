/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.model;

import br.com.chamado.dao.DaoGenerico;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class EmailConfig {

    private final String host ;
    private final int porta ;
    private final String usuario ;
    private final String senha ;
    private final String msgFrom ;
    private final boolean ssl ;
    private final boolean tls ;
    private static EmailConfig instancia;
    private final DaoGenerico dao;
    
    private EmailConfig()
    {
         dao = new DaoGenerico();
	 EmailConfig confDao = (EmailConfig) dao.carregarUm(1,EmailConfig.class);
	 this.host = confDao.getHost();
	 this.porta = confDao.getPorta();
	 this.senha = confDao.getSenha();
	 this.ssl = confDao.isSsl();
	 this.tls = confDao.isTls();
	 this.usuario = confDao.getUsuario();
	 this.msgFrom = confDao.getMsgFrom();
    }
    public static EmailConfig getInstancia()
    {
        if(instancia == null)
	{
	   instancia = new EmailConfig();
	}
	return instancia;
    }
    public String getHost() {
	return host;
    }
  
    public int getPorta() {
	return porta;
    }
    public String getUsuario() {
	return usuario;
    }

   

    public String getSenha() {
	return senha;
    }

   
    public String getMsgFrom() {
	return msgFrom;
    }


    public boolean isSsl() {
	return ssl;
    }

    
    public boolean isTls() {
	return tls;
    }
}
