package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payload.PostDto;
import com.example.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
     
	@Autowired
	private PostService postService;
	
	//http://localhost:8080/api/post
	@PostMapping
	public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto){
		 PostDto savePost = postService.savePost(postDto);
		return new ResponseEntity<PostDto>(savePost,HttpStatus.CREATED);
	}
	
	//http://localhost:8080/api/post
	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPost(){
		List<PostDto> dtos= postService.getAllPost();
		return ResponseEntity.ok(dtos);
	}
	
	
	//http://localhost:8080/api/post/1
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> fingPostById(@PathVariable("id") long id){
		return new ResponseEntity<>(postService.findPostById(id),HttpStatus.OK);	
	}
	
	//http://localhost:8080/api/post/1
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> postUpdateById(@RequestBody PostDto postDto,@PathVariable("id") long id){
		PostDto postUpdateById = postService.postUpdateById(postDto,id);
		return new ResponseEntity<PostDto>(postUpdateById,HttpStatus.OK);
	}
	
	//http://localhost:8080/api/post/1
	@DeleteMapping("/{id}")
	public String deletePostById(@PathVariable("id")long id) {
		postService.deletePostById(id);
		return ("Post is deleted successfully");
	}
}
