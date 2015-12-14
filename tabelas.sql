CREATE TABLE chamadoc
(
   numchamado serial PRIMARY KEY NOT NULL,
   unidade INTEGER NOT NULL 
   REFERENCES unidade(codunidade),
   data DATE NOT NULL,
   status INTEGER NOT NULL DEFAULT(0) CONSTRAINT
   chk_status CHECK(status >= 0 AND status <= 3),
   prioridade INTEGER NOT NULL DEFAULT(0) CONSTRAINT
   chk_prioridade CHECK(prioridade >= 0 AND prioridade <=3),
   codfuncsolic INTEGER NOT NULL,
   codfuncatend INTEGER,
   titulo VARCHAR(30) NOT NULL,
   dataprevisao DATE,
   datafechamento DATE 
);


CREATE TABLE mensagem
(
   nummensagem serial PRIMARY KEY NOT NULL,
   numchamado  INTEGER NOT NULL 
   REFERENCES chamadoc(numchamado),
   data DATE ,
   codfuncautor INTEGER NOT NULL
   REFERENCES usuario(codusuario), 
   nomearquivo VARCHAR(10),
   arquivo OID,
   texto TEXT NOT NULL
);

//foi adicionado o campo nome altera na classe
CREATE TABLE usuario(

  codusuario serial PRIMARY KEY NOT NULL,
  unidade INTEGER NOT NULL 
  REFERENCES unidade(codunidade),
  nome VARCHAR(30) NOT NULL ,
  usuario VARCHAR(30) NOT NULL CONSTRAINT
  unqusuario UNIQUE,
  senha VARCHAR(256) NOT NULL,
  email VARCHAR(50) NOT NULL,
  tipousuario INTEGER NOT NULL CONSTRAINT
  chk_tipousuario CHECK(tipousuario >= 0 AND tipousuario <=2),
  grupo INTEGER NOT NULL REFERENCES grupo(codgrupo)
);

CREATE TABLE unidade(
   
    codunidade serial PRIMARY KEY NOT NULL, 
    descricao VARCHAR(30) NOT NULL,
    razaosocial VARCHAR(30) NOT NULL,
    endereco VARCHAR(30) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
    cidade VARCHAR(30) NOT NULL    
);

CREATE TABLE grupo(

  codgrupo serial PRIMARY KEY NOT NULL,
  nomegrupo VARCHAR(30) NOT NULL);

CREATE TABLE pagina(
   
   codpagina serial PRIMARY KEY NOT NULL,
   nomepagina VARCHAR(30) NOT NULL);

CREATE TABLE grupopagina(
   
     codgrupopagina serial PRIMARY KEY NOT NULL,
     codgrupo INTEGER NOT NULL REFERENCES grupo(codgrupo),
     codpaigna INTEGER NOT NULL REFERENCES pagina(codpagina)); 
     
CREATE TABLE confemail(
 
  codemail serial PRIMARY KEY NOT NULL,
  host VARCHAR(30) NOT NULL,
  usuarioemail VARCHAR(30) NOT NULL ,
  senhaemail VARCHAR(30) NOT NULL,
  porta INTEGER NOT NULL,
  ssl  BOOLEAN,  
  tls  BOOLEAN,
  msgfrom VARCHAR(10));
  
