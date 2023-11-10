package com.developez.Spring.boot.blog.API;

import com.developez.Spring.boot.blog.API.entity.Role;
import com.developez.Spring.boot.blog.API.repository.RoleRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Blog App REST APIs",
				description = "Spring Boot Blog App REST APIs Documentation",
				version = "v1.0.0",
				contact = @Contact(
						name = "Developez.com",
						email = "adienerlopez@gmail.com",
						url = "https://www.linkedin.com/in/adiener-lopez-934089236/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Blog App Source Code",
				url = "https://github.com/Pochyxi/JAVA_SPRING_BOOT_blog-API_SpringDoc.git"
		)
)
public class SpringBootBlogApiApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBlogApiApplication.class, args);
	}

	private final RoleRepository roleRepository;

	@Autowired
	public SpringBootBlogApiApplication( RoleRepository roleRepository ) {
		this.roleRepository = roleRepository;
	}

	@Override
	public void run( String... args ) throws Exception {
		Optional<Role> userRole = roleRepository.findByName( "ROLE_USER" );
		Optional<Role> userAdmin = roleRepository.findByName( "ROLE_ADMIN" );

		if ( userRole.isEmpty() || userAdmin.isEmpty() ) {
			Role adminRole = new Role();
			adminRole.setName( "ROLE_ADMIN" );
			roleRepository.save( adminRole );

			Role newUserRole = new Role();
			newUserRole.setName( "ROLE_USER" );
			roleRepository.save( newUserRole );

			System.out.println( "RUOLI CREATI CON SUCCESSO" );
		} else {
			System.out.println( "RUOLI GIA' ESISTENTI: NON ESEGUO" );
		}

	}
}
