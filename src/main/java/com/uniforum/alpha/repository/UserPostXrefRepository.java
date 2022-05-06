package com.uniforum.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniforum.alpha.entity.UserPostXref;
import com.uniforum.alpha.entity.UserPostXrefPk;

public interface UserPostXrefRepository extends JpaRepository<UserPostXref, UserPostXrefPk> {

}
