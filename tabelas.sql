CREATE TABLE chamadoc
(
   id serial PRIMARY KEY NOT NULL,
   unidade INTEGER NOT NULL 
   REFERENCES unidade(id),
   data TIMESTAMP NOT NULL,
   status INTEGER NOT NULL ,
   prioridade INTEGER NOT NULL DEFAULT(1) CONSTRAINT 
   chk_prioridade CHECK(prioridade >= 0 AND prioridade <=3),
   categoria INTEGER NOT NULL,    
   codfuncsolic INTEGER NOT NULL,
   codfuncatend INTEGER,
   titulo VARCHAR(30) NOT NULL,
   dataprevisao TIMESTAMP,
   datafechamento TIMESTAMP);

CREATE TABLE mensagem
(
   id serial PRIMARY KEY NOT NULL,
   numchamado  INTEGER NOT NULL 
   REFERENCES chamadoc(id),
   data TIMESTAMP ,
   codfuncautor INTEGER NOT NULL
   REFERENCES usuario(id), 
   nomearquivo VARCHAR(10),
   arquivo OID,
   texto TEXT NOT NULL
);


CREATE TABLE usuario(

  id serial PRIMARY KEY NOT NULL,
  unidade INTEGER NOT NULL 
  REFERENCES unidade(id),
  nome VARCHAR(30) NOT NULL ,
  usuario VARCHAR(30) NOT NULL CONSTRAINT
  uniqueusuario UNIQUE,
  senha VARCHAR(256) NOT NULL,
  email VARCHAR(50) NOT NULL,
  setor INTEGER NOT NULL);

CREATE TABLE unidade(
   
    id serial PRIMARY KEY NOT NULL, 
    nome VARCHAR(30) NOT NULL,
    razaosocial VARCHAR(30) ,
    endereco VARCHAR(30) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    mneumonico VARCHAR(30) NOT NULL,
    fonediretor VARCHAR(30) NOT NULL,
    fonepabx VARCHAR(30) NOT NULL
);

CREATE TABLE pagina(
   
   id serial PRIMARY KEY NOT NULL,
   descricao  VARCHAR(30) NOT NULL,
   nomepagina VARCHAR(30) NOT NULL);

CREATE TABLE permissao(
   
     id serial PRIMARY KEY NOT NULL,
     codusuario INTEGER NOT NULL REFERENCES usuario(id),
     codpagina INTEGER NOT NULL REFERENCES pagina(id)); 
     
CREATE TABLE confemail(
 
  id serial PRIMARY KEY NOT NULL,
  host VARCHAR(30) NOT NULL,
  usuarioemail VARCHAR(30) NOT NULL ,
  senhaemail VARCHAR(30) NOT NULL,
  porta INTEGER NOT NULL,
  ssl  BOOLEAN DEFAULT(false) NOT NULL,  
  tls  BOOLEAN DEFAULT(false) NOT NULL,
  msgfrom VARCHAR(10) NOT NULL);
  
CREATE TABLE setor(
   
   id serial PRIMARY KEY NOT NULL,
   nome VARCHAR(30) NOT NULL,
   ramal VARCHAR(30) NOT NULL);
   
CREATE TABLE email(
   
   id serial PRIMARY KEY NOT NULL,
   data TIMESTAMP NOT NULL,
   enviado BOOLEAN DEFAULT(false) NOT NULL,
   assunto VARCHAR(60) NOT NULL,
   texto TEXT NOT NULL,
   destinatario VARCHAR(30) NOT NULL,
   dataenvio  TIMESTAMP);
   
CREATE TABLE urgencia(
    id serial PRIMARY KEY NOT NULL,
    nome VARCHAR(30) NOT NULL,
    habilitado BOOLEAN NOT NULL DEFAULT(false));
    
CREATE TABLE status (
      
      id serial PRIMARY KEY NOT NULL,
      nome VARCHAR(30) NOT NULL,
      habilitado BOOLEAN NOT NULL DEFAULT(false));
      

CREATE TABLE justificativa(
      id serial PRIMARY KEY NOT NULL,
      nome VARCHAR(30) NOT NULL,
      validostatus INTEGER NOT NULL,
      habilitado BOOLEAN NOT NULL DEFAULT(false));
 
      
CREATE TABLE descricao(
 id serial PRIMARY KEY NOT NULL,
 descricao VARCHAR(30) NOT NULL,
 tipo INTEGER NOT NULL);
