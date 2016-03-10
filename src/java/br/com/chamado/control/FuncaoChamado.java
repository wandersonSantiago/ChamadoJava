package br.com.chamado.control;

import br.com.chamado.dao.DaoDescricao;
import br.com.chamado.dao.DaoGenerico;
import br.com.chamado.model.Chamadoc;
import br.com.chamado.model.Descricao;
import br.com.chamado.model.Mensagem;
import br.com.chamado.model.SessionContext;
import br.com.chamado.model.Usuario;
import java.util.Date;

/**
 *
 * @author Eduardo Ferrari
 */
public class FuncaoChamado {

    private final Usuario usuarioDaSessao = SessionContext.getInstance().getUsuarioLogado();
    private static FuncaoChamado instance;
    private Chamadoc chamado;
    private Mensagem mensagem;
    private Descricao status;
    private DaoDescricao daoDescricao;
    private DaoGenerico daoGenerico;
    private final Date dataDoInsert = new Date();

    private FuncaoChamado() {
    }

    public static FuncaoChamado getInstance() {
        if (instance == null) {
            instance = new FuncaoChamado();
        }
        return instance;
    }

    public void abrirChamado() {

        chamado.setData(dataDoInsert);
        chamado.setUnidade(usuarioDaSessao.getUnidade());
        chamado.setCodfuncsolic(usuarioDaSessao);
        status = daoDescricao.carregarStatus(8);
        chamado.setStatus(status);
        daoGenerico.salvar(chamado);
        chamado.limpar();
        gravarMensagem();

    }

    private void gravarMensagem() {
        mensagem.setNumeChamado(chamado.getId());
        mensagem.setData(dataDoInsert);
        mensagem.setCodfuncautor(usuarioDaSessao);
        daoGenerico.salvar(mensagem);
        mensagem.limpar();
    }

    public void fecharChamado()
    {
    status = daoDescricao.carregarStatus(9);
    chamado.setStatus (status);
    Date dataDoFechamento = new Date();
    chamado.setDatafechamento (dataDoFechamento);
    daoDescricao.alterar (chamado);
   }

    public void reabrirChamado() {

        status = daoDescricao.carregarStatus(11);
        chamado.setStatus(status);
        daoGenerico.alterar(chamado);
    }

    public void atenderChamado() {

    }

    public void setChamado(Chamadoc chamado) {
        this.chamado = chamado;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }
}
