/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.util;

import br.com.chamado.dao.DaoChamadoc;
import br.com.chamado.dao.DaoGenerico;
import br.com.chamado.model.Chamadoc;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class VerificaChamado {
    
    private DaoGenerico daoGenerico;
    private List listaChamado;
    
    public VerificaChamado()
    {
        daoGenerico = new DaoGenerico();
    }
    private void verfica()
    {
         
	
	while(true)
	 {
	  Calendar cal = Calendar.getInstance();
          if(cal.get(Calendar.HOUR_OF_DAY) == 16 && cal.get(Calendar.MINUTE) == 0 ) {
    
          }
	 
	 }
	 
     
    }
    
    public void iniciar()
    {
	
    }
	
}
