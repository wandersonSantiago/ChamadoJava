/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.util;

import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Email;
import br.com.chamado.model.EmailConfig;
import br.com.chamado.model.Grupo;
import br.com.chamado.model.GrupoPagina;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Setor;
import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author wandersonSantiago
 */
public class HibernateConfiguracao {

    private static SessionFactory sessionFactory;

    public Session openSession() {

        if (sessionFactory == null) {

            criaSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public void criaSessionFactory() {
        Configuration configuracao = new Configuration();
        configuracao.addAnnotatedClass(Chamadoc.class);
        configuracao.addAnnotatedClass(Grupo.class);
       // configuracao.addAnnotatedClass(GrupoPagina.class);
        configuracao.addAnnotatedClass(Mensagem.class);
      //  configuracao.addAnnotatedClass(Pagina.class);
        configuracao.addAnnotatedClass(Unidade.class);
        configuracao.addAnnotatedClass(Usuario.class);
        configuracao.addAnnotatedClass(EmailConfig.class);
        configuracao.addAnnotatedClass(Setor.class);
        configuracao.addAnnotatedClass(Email.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
        sessionFactory = configuracao.buildSessionFactory(serviceRegistry);
    }
}
