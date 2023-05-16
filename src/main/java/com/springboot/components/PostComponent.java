package com.springboot.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.springboot.models.Post;

@Component("com.springboot.components.postComponent")
@Scope(value= ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponent {

	public List<Post> getPost(){
		ArrayList<Post> post= new ArrayList<>();
		post.add(new Post(1, "Desarrollo web es un termino que defie la creacion de sitios web  para internet o una intranet,", new Date(),"Desarrollo Web"));
		post.add(new Post(2, "Desarrollo web es un termino que defie la creacion de sitios web  para internet o una intranet,", new Date(),"Desarrollo Web"));
		post.add(new Post(3, "Desarrollo web es un termino que defie la creacion de sitios web  para internet o una intranet,", new Date(),"Desarrollo Web"));
		post.add(new Post(4, "Desarrollo web es un termino que defie la creacion de sitios web  para internet o una intranet,", new Date(),"Desarrollo Web"));

		return post;
	}
}
