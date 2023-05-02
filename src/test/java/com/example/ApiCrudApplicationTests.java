package com.example;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.payload.PostDto;
import com.example.service.impl.PostServiceImpl;

@SpringBootTest
class ApiCrudApplicationTests {
	
      @Autowired
      private PostServiceImpl postService;
	
	@Test
	void contextLoads() {
		
	}
	
	
	@Test
	void getAllPost() {
		List<PostDto> allPost = postService.getAllPost();
		assertThat(allPost);
	}

}
