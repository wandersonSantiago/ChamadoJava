/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.util;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class ServicoEmail implements Runnable {
    
    
    private static boolean status = false;
    private static ServicoEmail instancia;
    private static Thread threadServico;
    
    private ServicoEmail()
    {
      
    }
    private static void criaInstancia()
    {
       if(instancia == null)
       {
           instancia = new ServicoEmail();
       }
      
    }
    
    @Override
    public void run() {
       
     new Runnable() {
         @Override
         public void run() {
           
         }
     };
        
        
    }
   
    public void servico()
    {
    
    }
    public static void iniciar()
    {
        criaInstancia();
        threadServico = new Thread(instancia);
        threadServico.start();
    }
    public void parar()
    {
        threadServico.interrupt();
        instancia = null;
    }

    
}
