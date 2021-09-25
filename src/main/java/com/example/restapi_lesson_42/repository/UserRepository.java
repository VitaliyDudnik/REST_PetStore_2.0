package com.example.restapi_lesson_42.repository;
import com.example.restapi_lesson_42.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

     User getUserByUsername(String username);

     @Modifying
     @Query("update User u set u.username = :username where u.id = :id")
     void updateUserByUsername(@Param("id") long id, @Param("username") String username);


}
