package com.securerestfulservices.repositories;
import org.springframework.data.repository.CrudRepository;
import com.securerestfulservices.security.domains.Role;

// @Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	// Role findByRole(String role);
}
