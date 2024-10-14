package com.guilherme.matte.userdept.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.matte.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);

	List<User> findByDepartmentId(int dept);
}
