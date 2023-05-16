package Beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.springboot.models.Conexion;
import com.springboot.models.Usuario;

@Component 
public class CreandoConexion {
	
	@Bean(name = "beanUsuario")
	public Usuario getUsuario(){
		return new Usuario();
	}
	
	
	@Bean(name = "beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setDb("mysql");
		conexion.setUrl("localhost");
		return conexion;
	}
	
	
	 @Bean
	    public DataSource mysqlDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/blog");
	        dataSource.setUsername("anthony");
	        dataSource.setPassword("root1234");

	        return dataSource;
	    }
}
