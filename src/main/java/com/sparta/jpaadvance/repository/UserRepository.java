package com.sparta.jpaadvance.repository;

import com.sparta.jpaadvance.entity.*;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Long> {

}