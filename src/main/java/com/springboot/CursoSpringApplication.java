package com.springboot;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springboot.components.PostComponent;
import com.springboot.models.Usuario;
import com.springboot.service.PostService;


@SpringBootApplication
public class CursoSpringApplication  implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Value("${cursospring.jdbc.import.ruta}")
	private String ruta;
	
	@Value("${cursospring.jdbc.import}")
	private String importar;

	
	public CursoSpringApplication() {
		
	}
	
    public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		if(importar.equalsIgnoreCase("true")) {
			
			Path path =Paths.get(ruta);
			Log log= LogFactory.getLog(getClass());
		
		try(
		BufferedReader bufferedReader = Files.newBufferedReader(path,Charset.forName("UTF-8"))){
			String line;
			while((line = bufferedReader.readLine()) !=null) {
			
			jdbc.execute(line);
				log.info(line);
			}
			
			}catch(IOException ex) {
				
			}
		log.info(jdbc.queryForObject("SELECT count(*) FROM blog.permiso;", Integer.class));
		}
		

		
	}
}
