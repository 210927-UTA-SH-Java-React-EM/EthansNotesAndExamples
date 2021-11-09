package com.example.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RestController
@RequestMapping("/rest")
@NoArgsConstructor
public class RestTemplateController {
	
	@GetMapping("/get")
	public ResponseEntity<String> restTemplateGet(){
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		ResponseEntity<String> res = rest.getForEntity(url, String.class);
		return res;
	}
	
	@PostMapping("/exchange")
	public GenericPost restTemplateExchange(@RequestBody GenericPost p) {
		
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpEntity<GenericPost> request = new HttpEntity<GenericPost>(p);
		return rest.exchange(url, HttpMethod.POST, request, GenericPost.class).getBody();
	}
	
	@PostMapping("/post")
	public GenericPost restTemplatePost(@RequestBody GenericPost p) {
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		HttpEntity<GenericPost> request = new HttpEntity<GenericPost>(p);
		return rest.postForObject(url, request, GenericPost.class);
	}
	
	
	
}

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class GenericPost{
	
	private int id;
	private String title;
	private String body;
	private int userId;
	
}