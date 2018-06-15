INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
VALUES (1, "Rafael Calearo", "1091507911", "rafaelcalearo@theevents.com", "123456", "-", 'ROLE_ADMIM', "0");
INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
VALUES (2, "Michel Luz", "1068475704", "michelluz@theevents.com", "54321", "-", 'ROLE_ADMIM', "0");
INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
VALUES (3, "Silvio Santos", "1000000105", "silvinho.santos@theevents.com", "silviorico", "-", 'ROLE_COMUM', "0");

INSERT INTO tipoevento (id, descricao_tipo_evento, usuario_id) VALUES (1, "Festa Junina", 1);
INSERT INTO tipoevento (id, descricao_tipo_evento, usuario_id) VALUES (2, "Festa Country", 2);

INSERT INTO evento (id, usuario_id, tipoevento_id, titulo, data_criacao, descricao, local, foto, ativo) 
VALUES (1, 1, 1, "Array do Gugu", "30 mar 2019", "Bla, Bla, Bla, e pipoca.", "Teatro Guarani", "-", "0");
INSERT INTO evento (id, usuario_id, tipoevento_id, titulo, data_criacao, descricao, local, foto, ativo) 
VALUES (2, 2, 2, "Barreto in Fest", "30 nov 2018", "Bla, Bla, Bla, e vaca.", "AV. Bento Gonçalves", "-", "0");