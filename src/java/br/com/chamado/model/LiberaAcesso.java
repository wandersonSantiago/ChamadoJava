/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.model;

import br.com.chamado.dao.DaoPermissao;
import br.com.chamado.dao.DaoUsuario;
import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author wandersonSantiago
 */
@ManagedBean(name = "liberaAcesso")
@SessionScoped

public class LiberaAcesso {

    public LiberaAcesso() {

    }

    public Boolean alterarPaginas() {
        return true;
    }

    public Boolean alterarSetor() {
        return true;
    }

    public Boolean alterarUnidade() {
        return true;
    }

    public Boolean alterarUsuario() {
        return true;
    }

    public Boolean cadastrarPaginas() {
        return true;
    }

    public Boolean cadastrarSetor() {
        return true;
    }

    public Boolean permissao() {
        return true;
    }

    public Boolean cadastrarUnidade() {
        return true;
    }

    public Boolean cadastrarUsuarios() {
        return true;
    }

    public Boolean chamadoAbertoCliente() {
        return true;
    }

    public Boolean chamadoClienteManutenção() {
        return true;
    }

    public Boolean chamadoClienteTi() {
        return true;
    }

    public Boolean configuracao() {
        return true;
    }

    public Boolean servicoEmail() {
        return true;
    }

    public Boolean foneUnidades() {
        return true;
    }

    public Boolean listaChamadoManutencao() {
        return true;
    }

    public Boolean listaChamadoTi() {
        return true;
    }

    public Boolean ramalSetor() {
        return true;
    }
}
