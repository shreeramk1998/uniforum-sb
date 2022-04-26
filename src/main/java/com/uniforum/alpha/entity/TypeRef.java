package com.uniforum.alpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TYPE_REF", schema = "TYF_CONFIG")
@ToString
public class TypeRef {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "TYPE_REF_NUM")
	private Long typeRefNum;
	
	@Column(name = "DESC")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "TYPE_GROUP_NUM")
	@JsonBackReference
	private TypeGroupRef typeGroupRef;
	
}
