package com.springboot.service.impl;


import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.springboot.models.Post;
import com.springboot.service.PostService;

@Service
public class PostServiceImplements implements PostService{

	private final Log log= LogFactory.getLog(getClass());
	
	@Override
	public List<Post> validation(List<Post> posts) throws NullPointerException{
		log.info("Servicio Uno");
		for(Post post : posts) {
			if(post.getTitulo()==null) {
				log.info("Debe de ingresar un titulo ");
			}
		}
		return posts;
	}

}
