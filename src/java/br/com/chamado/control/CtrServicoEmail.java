/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.control;

import br.com.chamado.util.ServicoEmail;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eduardo
 */
@ManagedBean(name = "servicoEmail")
public class CtrServicoEmail {
    
    private ServicoEmail servico ;
    
    public String  iniciar()
    {
       servico.iniciar();
        return "index";
    }
    public String para()
    {
        servico.parar();
        return "index";
    }
    
            
            }
