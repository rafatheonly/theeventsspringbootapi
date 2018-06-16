package com.theeventsspringbootapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.theeventsspringbootapi.entitys.Usuario;
import com.theeventsspringbootapi.enums.PerfilEnum;
import com.theeventsspringbootapi.repositorys.UsuarioRepository;

@SpringBootApplication
public class TheeventsspringbootapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheeventsspringbootapiApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            initUsers(usuarioRepository, passwordEncoder);
        };

    }
    
	private void initUsers(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        Usuario admin = new Usuario(); 
        admin.setId(1L);
        admin.setNome("Rafael Calearo");
        admin.setRg("1091507911");
        admin.setEmail("rafaelcalearo@theevents.com");
        admin.setSenha(passwordEncoder.encode("123456"));
        admin.setFoto("-");
        admin.setPerfil("ROLE_ADMIN");
        admin.setAtivo(true);

        Usuario find = usuarioRepository.findByEmail("rafaelcalearo@theevents.com");
        if (find == null) {        	
            usuarioRepository.save(admin);
        }
        
        System.out.print(admin.getSenha());
    }
	
	
}
