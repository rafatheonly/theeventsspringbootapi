CREATE TABLE usuario (
  id BIGINT(1) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  rg VARCHAR(10) NOT NULL,
  email VARCHAR(45) NOT NULL,
  senha VARCHAR(150) NOT NULL,
  foto VARCHAR(60) NULL,
  perfil VARCHAR(60) NOT NULL,
  ativo TINYINT(1) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipoevento (
  id BIGINT(1) NOT NULL,
  descricao_tipo_evento VARCHAR(45) NOT NULL,
  usuario_id BIGINT(1) NOT NULL,
  PRIMARY KEY (id, usuario_id), 
    FOREIGN KEY (usuario_id) REFERENCES usuario(id))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE evento (
  id BIGINT(1) NOT NULL,
  usuario_id BIGINT(1) NOT NULL,
  tipoevento_id BIGINT(1) NOT NULL,
  titulo VARCHAR(45) NOT NULL,
  data_criacao VARCHAR(20) NOT NULL,
  descricao VARCHAR(45) NOT NULL,
  local VARCHAR(45) NOT NULL,
  foto VARCHAR(60) NULL,
  ativo TINYINT(1) NOT NULL,
  PRIMARY KEY (id, usuario_id, tipoevento_id), 
    FOREIGN KEY (usuario_id) REFERENCES usuario(id), 
    FOREIGN KEY (tipoevento_id) REFERENCES tipoevento(id))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE convidado (
  id BIGINT(1) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  rg VARCHAR(10) NULL,
  evento_id BIGINT(1) NOT NULL,
  usuario_id BIGINT(1) NOT NULL,
  PRIMARY KEY (id, evento_id, usuario_id),  
    FOREIGN KEY (evento_id) REFERENCES evento(id), 
    FOREIGN KEY (usuario_id) REFERENCES usuario(id))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE comentario (
  id BIGINT(1) NOT NULL,
  usuario_id BIGINT(1) NOT NULL,
  evento_id BIGINT(1) NOT NULL,
  data_comentario VARCHAR(45) NOT NULL,
  comentario VARCHAR(200) NOT NULL,
  ativo TINYINT(1) NOT NULL,
  PRIMARY KEY (id, usuario_id, evento_id),  
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),  
    FOREIGN KEY (evento_id) REFERENCES evento(id))
ENGINE = InnoDB DEFAULT CHARSET=utf8;