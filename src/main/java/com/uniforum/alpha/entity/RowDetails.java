package com.uniforum.alpha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class RowDetails {

	@CreationTimestamp
	@Column(name = "row_add_stp")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "IST")
	private Date rowAddStamp;
	
	@UpdateTimestamp
	@Column(name = "row_update_stp")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "IST")
	private Date rowUpdateStamp;
}
