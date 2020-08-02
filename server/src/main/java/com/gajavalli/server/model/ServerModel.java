package com.gajavalli.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerModel {
	
	@Id
	@GeneratedValue
    private int id;
	private @NonNull String username;
	private @NonNull String password;
	private @NonNull String url;

}
