//package com.uniforum.alpha.model;
//
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//
//import org.hibernate.annotations.Polymorphism;
//import org.hibernate.annotations.PolymorphismType;
//
//import com.uniforum.alpha.entity.Post;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Polymorphism(type = PolymorphismType.EXPLICIT)
//@DiscriminatorValue("null")
//public class PostModel extends Post {
//
//	@Column(name = "upvote_flg")
//	private Boolean upvoteFlag;
//}
