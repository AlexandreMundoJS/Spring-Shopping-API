package com.user_api.user_api.model;

import java.time.LocalDateTime;

import com.user_api.user_api.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String cpf;
	private String address;
	private String email;
	private String phone;
	private LocalDateTime createdDate;
	
	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setAddress(userDTO.getAddress());
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setCreatedDate(userDTO.getCreatedDate());
		return user;
	}
}
