package com.example.service;

import java.util.List;

import com.example.payload.PostDto;

public interface PostService {
	public PostDto savePost(PostDto postDto);

	public List<PostDto> getAllPost();

	public PostDto findPostById(long id);
	public PostDto postUpdateById(PostDto postDto,long id);

	public void deletePostById(long id);

}
