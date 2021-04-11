package com.hackathon.edexchange.edexchangeuserservice.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	@Column(name="about", length = 30000)
	private String about;

	@Column(name="profile_image")
	private String profileImage;

	@Column(name="skills")
	private String skills;


}