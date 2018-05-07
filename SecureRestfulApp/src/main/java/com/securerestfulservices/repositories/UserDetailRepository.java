package com.securerestfulservices.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.securerestfulservices.security.domains.UserDetail;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {
	@Query(nativeQuery = true, value = "select * from user_detail where user_authentication_id=:username")
	UserDetail findByUsername(@Param("username") String username);
}
