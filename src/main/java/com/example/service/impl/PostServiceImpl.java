package com.example.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Post;
import com.example.payload.PostDto;
import com.example.repository.PostRepository;
import com.example.service.PostService;
import com.example.service.exception.ResourceNotAvailable;
import com.example.service.exception.ResourceNotFoundException;
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;
	
	@Override
	public PostDto savePost(PostDto postDto) {
		Post mapToEntity = mapToEntity(postDto);
		Post save = postRepo.save(mapToEntity);
		return mapToDto(save);
	}
       Post mapToEntity(PostDto postDto) {
    	   Post post = new Post();
    	   post.setTitle(postDto.getTitle());
    	   post.setDescription(postDto.getDescription());
    	   post.setContent(postDto.getContent());
    	   return post;
       }
       
       public PostDto mapToDto(Post post) {
    	   PostDto dto = new PostDto();
    	   dto.setId(post.getId());
    	   dto.setTitle(post.getTitle());
    	   dto.setDescription(post.getDescription());
    	   dto.setContent(post.getContent());
    	   return dto;
       }
	@Override
	public List<PostDto> getAllPost() {
		List<Post> findAll = postRepo.findAll();
		if(!findAll.isEmpty()) {
		List<PostDto> collect = findAll.stream().map(post->mapToDto(post)).collect(Collectors.toList());
		return collect;
		}else {
			throw new ResourceNotAvailable("No posts Found !");	
		}
	}
	@Override
	public PostDto findPostById(long id) {
		Post post = postRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Post","id",id)
				);
		return mapToDto(post);
	}
	@Override
	public PostDto postUpdateById(PostDto postDto, long id) {
		Post post = postRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Post","id",id)
			
		);
		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		Post save = postRepo.save(post);
		return mapToDto(save);
	}
	@Override
	public void deletePostById(long id) {
		Post post = postRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Post","id",id)
				);
		postRepo.deleteById(id);
	}
	
	
	
}
