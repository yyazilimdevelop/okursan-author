package com.okursan.author.repositories;

import com.okursan.author.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    boolean existsByUsername(String username);

}
