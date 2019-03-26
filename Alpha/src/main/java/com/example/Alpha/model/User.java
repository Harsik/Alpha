package com.example.Alpha.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.Alpha.model.audit.DateAudit;

import org.hibernate.annotations.NaturalId;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User extends DateAudit {

	private static final long serialVersionUID = 1L;  //default serial version id 자바가 불안해 해서 넣는다고 한다 써도 문제 없음
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //스프링 2.0이상 부터 GenerationType.AUTO에 문제가 있어 IDENTITY로 수정
	private long id;
	
	@NaturalId
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

	@NotBlank
	@Size(max = 100)
	private String password;
	
	@NotBlank
	@Size(max = 40)
	private String name;

	@NotBlank
	@Size(max = 15)
	private String username;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@Builder
	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	// @Override
	// public String toString(){
	// 	return "Customer [idx = " + idx
	// 	+ ", id = " + id
	// 	+ ", pw = " + password;
	// }

}

