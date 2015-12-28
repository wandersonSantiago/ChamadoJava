/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.util;

import br.com.chamado.dao.DaoEmail;
import br.com.chamado.model.Email;
import java.util.List;
import javax.faces.bean.ManagedBean;



/**
 *
 * @author Eduardo de Godoy Ferrari
 */

public class ServicoEmail  {
    
    
    private static boolean status = false;
    private static ServicoEmail instancia;
    private static Thread threadServico;
    private static DaoEmail acessoHibernate;
    private static EnviaEmail envia;
    private static int tempost = 1000;
   
    private ServicoEmail()
    {
      
    }
    private static void criaInstancia()
    {
       if(envia == null )
       {
           envia = EnviaEmail.getInstancia();
          
       }
        if(envia.testaEnvio())
        { 
          if(instancia == null)
          {
           acessoHibernate = new DaoEmail();
           instancia = new ServicoEmail();
         }
       }
      
    }
  
    private static void servico()
    {
        while(true)
        {
        List<Email> listEmail = acessoHibernate.listaEmail();
       
            try {
                Thread.sleep(tempost);
               
                for(Email emails : listEmail)
                {
                    envia.setAssunto(emails.getAssunto());
                    envia.setEmailDe(emails.getDestinatario());
                    envia.setMsg(emails.getTexto());
                    envia.enviar();
                    if(envia.getStatus())
                    {
                       emails.setEnviado(envia.getStatus());
                       acessoHibernate.alterar(emails);
                       listEmail.remove(emails);
                    }
                   
                    
                }
               
            } catch (InterruptedException ex) {
              System.out.println(ex.getClass());
            }
            
        }
        
        
    }
    public static void iniciar()
    {
           
        criaInstancia();
        
        threadServico = new Thread(new Runnable() {
          @Override
          public void run() {
             servico();
          }
      });
        status = true;
        threadServico.start();
        
    }
    public static void parar()
    {
        if(threadServico != null )
        {
        threadServico.interrupt();
        instancia = null;
        status = false;
        acessoHibernate = null;
        }
    }

    
}
