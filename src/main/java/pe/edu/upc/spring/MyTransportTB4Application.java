package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MyTransportTB4Application {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyTransportTB4Application.class, args);
	}
	
	public void run(String...args) throws Exception{
		String password="admin";
		
		for(int i=0;i<2;i++) {
			String bcryptPassword= passwordEncoder.encode(password);
			System.out.print(bcryptPassword);
		}
	}
	
}
