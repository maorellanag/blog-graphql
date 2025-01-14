package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.example.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
