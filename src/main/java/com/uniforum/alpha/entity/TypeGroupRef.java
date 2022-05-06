package com.uniforum.alpha.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TYPE_GROUP_REF", schema = "TYF_CONFIG")
@ToString
public class TypeGroupRef {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "TYPE_GROUP_NUM")
	@EqualsAndHashCode.Include
	private Long typeGroupNum;
	
	@Column(name = "DESC")
	private String description;
	
	@OneToMany(mappedBy = "typeGroupRef", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonManagedReference
	@ToString.Exclude
	private List<TypeRef> typeRefList;
}
