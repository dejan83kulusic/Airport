package com.dejan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dejan.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findAll();
    Role findByRolename(String name);
}
