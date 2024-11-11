package com.user_api.user_api.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.user_api.user_api.dto.UserDTO;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

	public static List<UserDTO> users = new ArrayList<UserDTO>();

	@PostConstruct
	public void initalizeList() {
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Alexandre");
		userDTO.setCpf("11111111111");
		userDTO.setAddress("11111111111");
		userDTO.setEmail("alegarske@yahoo.com.br");
		userDTO.setPhone("111111111111");
		userDTO.setCreatedDate(LocalDateTime.now());

		UserDTO userDTO2 = new UserDTO();
		userDTO2.setName("Alexandre2");
		userDTO2.setCpf("11111111112");
		userDTO2.setAddress("11111111111");
		userDTO2.setEmail("alegarske@yahoo.com.br");
		userDTO2.setPhone("111111111111");
		userDTO2.setCreatedDate(LocalDateTime.now());

		UserDTO userDTO3 = new UserDTO();
		userDTO3.setName("Alexandre3");
		userDTO3.setCpf("11111111113");
		userDTO3.setAddress("11111111111");
		userDTO3.setEmail("alegarske@yahoo.com.br");
		userDTO3.setPhone("111111111111");
		userDTO3.setCreatedDate(LocalDateTime.now());

		users.add(userDTO);
		users.add(userDTO2);
		users.add(userDTO3);
	}

	@GetMapping("")
	public List<UserDTO> getMessage() {
		return users;
	}

	@GetMapping("/{cpf}")
	public UserDTO getMessageByCpf(@PathVariable String cpf) {
		return users.stream().filter(userDTO -> userDTO.getCpf().equals(cpf)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO insertUser(@RequestBody @Valid UserDTO userDTO) {
		userDTO.setCreatedDate(LocalDateTime.now());
		users.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean removeUser(@PathVariable String cpf) {
		return users.removeIf(userDTO -> userDTO.getCpf().equals(cpf));
	}
}
