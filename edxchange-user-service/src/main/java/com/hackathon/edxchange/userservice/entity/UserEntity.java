package com.hackathon.edxchange.userservice.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="user_name")
	private String userName;

	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;

	@Column(name="team_name")
	private String teamName;

	@Column(name="rating")
	private Integer rating;

	@Column(name="experience")
	private Double experience;

	@Column(name="followers")
	private Long followers;

	@Lob
	@Column(name="about", length = 65000)
	private String about;

	@Column(name="profile_image")
	private String profileImage;

	@Column(name="skills")
	private String skills;


}