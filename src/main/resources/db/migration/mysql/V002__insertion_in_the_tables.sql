INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
<<<<<<< HEAD
VALUES (1, "Rafael Calearo", "1091507911", "rafaelcalearo@theevents.com", "123456", "-", "ROLE_ADMIN", "0");
INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
VALUES (2, "Michel Luz", "1068475704", "michelluz@theevents.com", "54321", "-", "ROLE_ADMIN", "0");
INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
VALUES (3, "Silvio Santos", "1000000105", "silvinho.santos@theevents.com", "silviorico", "-", "ROLE_COMUM", "0");
=======
VALUES (2, "Rafael Calearo", "1091507911", "rafacalearo@theevents.com", '{bcrypt}$2a$10$8Pc1KGsm3tR1x9vHpolQLuk8iGaNUzvNoubnt1mA7x4OPabXipaOW', "-", "ROLE_ADMIN", "0");
INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
VALUES (3, "Michel Luz", "1068475704", "michelluz@theevents.com", "54321", "-", "ROLE_ADMIN", "0");
INSERT INTO usuario (id, nome, rg, email, senha, foto, perfil, ativo) 
VALUES (4, "Silvio Santos", "1000000105", "silvinho.santos@theevents.com", "silviorico", "-", "ROLE_COMUM", "0");
>>>>>>> 61153997994e1131773f76251e912a630b976161

INSERT INTO tipoevento (id, descricao_tipo_evento, usuario_id) VALUES (1, "Festa Junina", 2);
INSERT INTO tipoevento (id, descricao_tipo_evento, usuario_id) VALUES (2, "Festa Country", 2);

INSERT INTO evento (id, usuario_id, tipoevento_id, titulo, data_criacao, descricao, local, foto, ativo) 
VALUES (1, 2, 1, "Array do Gugu", "30 mar 2019", "Bla, Bla, Bla, e pipoca.", "Teatro Guarani", "-", "0");
INSERT INTO evento (id, usuario_id, tipoevento_id, titulo, data_criacao, descricao, local, foto, ativo) 
VALUES (2, 2, 2, "Barreto in Fest", "30 nov 2018", "Bla, Bla, Bla, e vaca.", "AV. Bento Gonçalves", "-", "0");