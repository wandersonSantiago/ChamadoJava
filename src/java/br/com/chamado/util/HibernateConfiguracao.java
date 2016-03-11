package br.com.chamado.util;

import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Descricao;
import br.com.chamado.model.Email;
import br.com.chamado.model.EmailConfig;
import br.com.chamado.model.Impressora;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Permissao;
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
        configuracao.addAnnotatedClass(Usuario.class);
        configuracao.addAnnotatedClass(Pagina.class);
        configuracao.addAnnotatedClass(Permissao.class);
        configuracao.addAnnotatedClass(Mensagem.class);
        configuracao.addAnnotatedClass(Unidade.class);
        configuracao.addAnnotatedClass(EmailConfig.class);
        configuracao.addAnnotatedClass(Setor.class);
        configuracao.addAnnotatedClass(Email.class);
        configuracao.addAnnotatedClass(Descricao.class);
        configuracao.addAnnotatedClass(Impressora.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
        sessionFactory = configuracao.buildSessionFactory(serviceRegistry);
    }
}
