package com.springboot.service;

import java.util.List;

import com.springboot.models.Post;

public interface PostService {

	public List<Post> validation(List<Post> posts)throws NullPointerException;
	
}
