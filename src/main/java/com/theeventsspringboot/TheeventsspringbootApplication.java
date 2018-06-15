package com.theeventsspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.theeventsspringboot.entitys.Usuario;
import com.theeventsspringboot.enums.PerfilEnum;
import com.theeventsspringboot.repositorys.UsuarioRepository;

@SpringBootApplication
public class TheeventsspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheeventsspringbootApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            initUsers(usuarioRepository, passwordEncoder);
        };

    }
    
	private void initUsers(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        Usuario admin = new Usuario();
        admin.setEmail("rafaelcalearo@theevents.com");
        admin.setSenha(passwordEncoder.encode("123456"));
        admin.setPerfil(PerfilEnum.ROLE_ADMIN);

        Usuario find = usuarioRepository.findByEmail("rafaelcalearo@theevents.com");
        if (find == null) {
            usuarioRepository.save(admin);
        }
    }
}
