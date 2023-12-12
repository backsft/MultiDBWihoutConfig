package com.MultiDBWithoutConfig.Postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class ChatUser {
	@Id	
	private String nickName;
	private String fullName;
	private Status status;

	

}
