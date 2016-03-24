/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.model;

import br.com.chamado.dao.DaoEmailConfig;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author CRC-TICWAN
 */
public class EnviaEmail {

    private static EmailConfig config;
    private static EnviaEmail instancia = null;

    private String emailDe;
    private String assunto;
    private String msg;

    private EnviaEmail() {
    }

    public static EnviaEmail getInstancia() {

        if (instancia == null) {
            instancia = new EnviaEmail();

            config = (EmailConfig) new DaoEmailConfig().carregarUm(1, EmailConfig.class);
        }
        return instancia;
    }

    public void setEmailDe(String emailDe) {
        this.emailDe = emailDe;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public synchronized void enviar() {
        SimpleEmail email = new SimpleEmail();
        try {
            email.setDebug(true);
            email.setHostName(config.getHost());
            email.setAuthentication(config.getUsuario(), config.getSenha());
            email.setSslSmtpPort(String.valueOf(config.getPorta()));
            email.setStartTLSEnabled(true);
           // email.setStartTLSRequired(true);
            email.setSSLOnConnect(true);
            email.addTo("wanderson_renato86@hotmail.com");
            email.setSubject(assunto);
            email.setFrom(config.getUsuario(), config.getMsgFrom());
            email.setMsg(msg);
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

}
