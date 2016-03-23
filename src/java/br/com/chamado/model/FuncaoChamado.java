/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.model;

import br.com.chamado.dao.DaoChamadoc;
import br.com.chamado.dao.DaoDescricao;
import br.com.chamado.dao.DaoMensagem;
import java.util.Date;

/**
 *
 * @author eduardo
 */
public class FuncaoChamado {

    private final Usuario usuarioDaSessao = SessionContext.getInstance().getUsuarioLogado();
    private final DaoChamadoc daoChamado = new DaoChamadoc();
    private final DaoDescricao daoDescricao = new DaoDescricao();
    private final DaoMensagem daoMensagem = new DaoMensagem();
    private final EnviaEmail mail = EnviaEmail.getInstancia();

    public void abrir(Chamadoc chamadoc, Mensagem mensagem) {

        Date dataAbertura = new Date();
        chamadoc.setData(dataAbertura);
        chamadoc.setUnidade(usuarioDaSessao.getUnidade());
        chamadoc.setCodfuncsolic(usuarioDaSessao);

        Descricao status = daoDescricao.carregarStatus(8);

        chamadoc.setStatus(status);

        daoChamado.salvar(chamadoc);

        mensagem.setNumeChamado(chamadoc.getId());
        mensagem.setData(dataAbertura);
        mensagem.setCodfuncautor(usuarioDaSessao);
        daoMensagem.salvar(mensagem);
        
        mail.setAssunto("Novo chamado por: " + usuarioDaSessao.getNome());
        mail.setMsg(mensagem.getTexto());
        mail.enviar();
        
        chamadoc.limpar();
        mensagem.limpar();

       

    }

    public void abrirChamadoImpressora(Chamadoc chamadoc, Mensagem mensagem) {

        Date dataAbertura = new Date();
        chamadoc.setData(dataAbertura);
        chamadoc.setUnidade(usuarioDaSessao.getUnidade());
        chamadoc.setCodfuncsolic(usuarioDaSessao);
        Descricao status = daoDescricao.carregarStatus(8);

        chamadoc.setStatus(status);
        Descricao tipo = daoDescricao.setarTipoChamado(14);

        chamadoc.setTipoChamado(tipo);

        daoChamado.salvar(chamadoc);

        mensagem.setNumeChamado(chamadoc.getId());
        mensagem.setData(dataAbertura);
        mensagem.setCodfuncautor(usuarioDaSessao);
        daoMensagem.salvar(mensagem);
        
        mail.setAssunto("Novo chamado por: " + usuarioDaSessao.getNome());
        mail.setMsg(mensagem.getTexto());
        mail.enviar();
        
        chamadoc.limpar();
        mensagem.limpar();

    }

    public void fechar(Chamadoc chamadoc) {

        Descricao status = daoDescricao.carregarStatus(9);
        chamadoc.setStatus(status);
        Date dataDoFechamento = new Date();
        chamadoc.setDatafechamento(dataDoFechamento);
        daoChamado.alterar(chamadoc);
    }

    public Chamadoc reabrirChamado(Chamadoc chamadoc) {
        Descricao status = daoDescricao.carregarStatus(11);
        chamadoc.setStatus(status);
        daoChamado.alterar(chamadoc);
        return chamadoc;
    }

    public void atenderChamada(Chamadoc chamadoc) {
        Descricao status = daoDescricao.carregarStatus(10);
        chamadoc.setStatus(status);
        daoChamado.alterar(chamadoc);
    }
}
