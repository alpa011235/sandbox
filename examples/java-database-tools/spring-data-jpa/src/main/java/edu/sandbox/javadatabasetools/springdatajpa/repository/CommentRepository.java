package edu.sandbox.javadatabasetools.springdatajpa.repository;

import edu.sandbox.javadatabasetools.springdatajpa.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
