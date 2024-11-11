package com.user_api.user_api.dto;

import java.time.LocalDateTime;

import com.user_api.user_api.model.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotNull(message = "Cpf is mandatory")
	@NotBlank(message = "Cpf is mandatory")
	private String cpf;
	private String address;
	
	@NotNull(message = "Email is mandatory")
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	private String phone;
	private LocalDateTime createdDate;
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(user.getName());
		userDTO.setAddress(user.getAddress());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhone(user.getPhone());
		userDTO.setCreatedDate(user.getCreatedDate());
		return userDTO;
	}
}
