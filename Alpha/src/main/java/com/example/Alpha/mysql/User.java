package com.example.Alpha.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idx;

	private String id;

	private String pw;

	@Builder
	public User(String id, String pw){
		this.id=id;
		this.pw=pw;
	}
	
	@Override
	public String toString(){
		return "Customer [idx = " + idx
		+ ", id = " + id
		+ ", pw = " + pw;
	}

}

