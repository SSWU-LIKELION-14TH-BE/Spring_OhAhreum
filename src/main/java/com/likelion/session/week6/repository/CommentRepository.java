package com.likelion.session.week6.repository;

import com.likelion.session.week6.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByCommentId(Long commentId);

    void deleteByCommentId(Long commentId);
}