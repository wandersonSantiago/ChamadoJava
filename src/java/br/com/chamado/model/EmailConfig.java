/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.model;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */

@ManagedBean(name = "confemail")
@SessionScoped
@Entity
@Table(name="confemail")
public class EmailConfig implements  Serializable{
    
    @Id 
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    @Column(name="host", unique=true, nullable=false)
    private  String servidor ;
    @Column(name="porta", nullable=false)
    private  int porta ;
    @Column(name="usuarioemail",  nullable=false)
    private  String usuario ;
    @Column(name="senhaemail",  nullable=false)
    private  String senha ;
    @Column(name="msgFrom", nullable=false)
    private  String msgFrom ;
    @Column(name="ssl", nullable=false)
    private  boolean ssl ;
    @Column(name="tls", nullable=false)
    private  boolean tls ;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    

    public String getServidor() {
	return servidor;
    }

    public void setServidor(String servidor) {
	this.servidor = servidor;
    }
    

    public int getPorta() {
	return porta;
    }

    public void setPorta(int porta) {
	this.porta = porta;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getMsgFrom() {
	return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
	this.msgFrom = msgFrom;
    }

    public boolean isSsl() {
	return ssl;
    }

    public void setSsl(boolean ssl) {
	this.ssl = ssl;
    }

    public boolean isTls() {
	return tls;
    }

    public void setTls(boolean tls) {
	this.tls = tls;
    }
   
     
}
