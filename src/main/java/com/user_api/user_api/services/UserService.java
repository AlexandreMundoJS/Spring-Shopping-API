package com.user_api.user_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.user_api.user_api.dtos.UserDTO;
import com.user_api.user_api.models.User;
import com.user_api.user_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public List<UserDTO> getAll() {
		List<User> users = userRepository.findAll();
		return users.stream().map(UserDTO::convert).collect(Collectors.toList());
	}
}