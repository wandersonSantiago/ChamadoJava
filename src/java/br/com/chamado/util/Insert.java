package br.com.chamado.util;

import br.com.chamado.dao.DaoGenerico;
import br.com.chamado.model.Pagina;
import br.com.chamado.model.Permissao;
import br.com.chamado.model.Setor;
import br.com.chamado.model.Unidade;
import br.com.chamado.model.Usuario;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public class Insert {

    private final DaoGenerico acessoHibernate;
    private Setor setor;
    private Unidade unidade;
    private Usuario usuario;
    private Pagina pagina;
    private Permissao permissao;

    public Insert() {
        
        acessoHibernate = new DaoGenerico();
    }

    public void gerar() {
        if (acessoHibernate.veriricar("usuario", "root", Usuario.class)) {

            criarSetor();
            criarUnidade();
            criarUsuario();
            criarPagina();
            criarPermissao();
        }

    }
    private void criarSetor() {
        setor = new Setor("Tecnologia da informacao",999);
        acessoHibernate.salvar(setor);
    }

    private void criarUnidade() {
        unidade = new Unidade();
        unidade.setBairro("Seu Bairro");
        unidade.setCidade("Sua Cidade");
        unidade.setEndereco("Seu Endereco");
        unidade.setFoneDiretor("0000000000");
        unidade.setFonePabx("0000000000");
        unidade.setMneumonico("informacao");
        unidade.setNome("Seu nome");
        
        acessoHibernate.salvar(unidade);
    }

    private void criarUsuario() {
        usuario = new Usuario(unidade,"Root","root","root1989","root@seuemail.com.br",setor);
        usuario.criptografar();  
        acessoHibernate.salvar(usuario);
    }
    private void criarPagina(){
        pagina = new Pagina();
        pagina.setDescricao("root");
        pagina.setNomepagina("root");
        acessoHibernate.salvar(pagina);
    }
    private void criarPermissao(){
        permissao = new Permissao();
        permissao.setUsuario(usuario);
        permissao.setPagina(pagina);
        acessoHibernate.salvar(permissao);
        
    }

}
