package com.uniforum.alpha.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER", schema = "TYF_USER")
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NUM")
	private Long userNum;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ID", unique = true)
	private String id;

	@Column(name = "PASSWORD")
	@JsonIgnore
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE", schema = "TYF_USER", joinColumns = @JoinColumn(name = "USER_NUM"), inverseJoinColumns = @JoinColumn(name = "ROLE_NUM"))
	private List<Role> roleList;

}
