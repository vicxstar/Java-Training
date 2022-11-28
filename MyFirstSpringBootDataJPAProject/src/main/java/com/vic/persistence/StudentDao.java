package com.vic.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vic.entity.Student;

/**
 *
 * @author vic
 * date: 25/11/2022
 * purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER)
 *
 */
//'@Repository' indicates that this class is a 'repository' that can store and retrieve a collection of objects:
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
}
