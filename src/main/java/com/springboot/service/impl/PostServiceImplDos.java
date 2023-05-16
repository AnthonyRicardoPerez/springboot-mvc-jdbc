package com.springboot.service.impl;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.springboot.models.Post;
import com.springboot.service.PostService;
 
@Service("serviceDos")
public class PostServiceImplDos implements PostService {
	private final Log log= LogFactory.getLog(getClass());
	@Override
	public List<Post> validation(List<Post> posts) throws NullPointerException{
	log.info("Servicio Dos");
		for(Post post : posts) {
			if(post.getId() == 0) {
				log.info("El id es nulo");
			}
		}
		return posts;
	}

}
