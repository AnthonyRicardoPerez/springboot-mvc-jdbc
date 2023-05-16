package com.springboot.service.impl;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.springboot.models.Post;
import com.springboot.service.PostService;

@Service("ServiceDecorado")
@Scope(value= ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostServiceDecoratorImpl implements PostService {
	private final Log log= LogFactory.getLog(getClass());
	@Autowired
	private PostServiceImplements postServiceImpl;
	
	@Autowired
	private PostServiceImplDos postServiceImplementsDos;

	@Override
	public List<Post> validation(List<Post> posts)throws NullPointerException {
		log.debug(posts);
	    posts = postServiceImpl.validation(posts);
	    posts = postServiceImplementsDos.validation(posts);
	 
		for(Post post : posts) {
			if(post.getDescripcion() == null) {
				log.info("La Descripcion es nula");
			}
			if(post.getFecha() == null) {
				log.info("La fecha es nula");;
			}
		}
		return posts;
	}

	
}
