package tlu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tlu.model.User;
import tlu.repository.UserRepository;


@SpringBootApplication
public class EducationManagementSystemApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EducationManagementSystemApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
			} 
		};
    }
	
	 @Override 
	 public void run(String... args) throws Exception {
		 User user = new User( 1L, "daotao", "1234", "Bui Xuan Ngoc", "daotao@thanglong.edu.vn", "0999222333", "DAOTAO", false);
		 user.setPassword(passwordEncoder.encode(user.getPassword())); 
		 Optional<User> tmpUser = userRepository.findById(user.getUserId()); 
		 if	 (!tmpUser.isPresent()) {
			 userRepository.save(user); 
		 }
	 }
	
	
}
