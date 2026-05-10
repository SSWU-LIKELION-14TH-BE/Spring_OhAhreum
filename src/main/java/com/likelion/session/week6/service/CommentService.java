package com.likelion.session.week6.service;

import com.likelion.session.week6.dto.CommentDTO;
import com.likelion.session.week6.entity.Board;
import com.likelion.session.week6.entity.Comment;
import com.likelion.session.week6.repository.BoardRepository;
import com.likelion.session.week6.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Optional<Comment> getComment(Long commentId) {
        return commentRepository.findById(commentId);
    }


    public void postComment(CommentDTO commentDTO) {

        Board board = boardRepository.findById(commentDTO.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        Comment comment = Comment.builder()
                .content(commentDTO.getContent())
                .writer(commentDTO.getWriter())
                .board(board)
                .build();

        commentRepository.save(comment);
    }


    @Transactional
    public void putComment(CommentDTO commentDTO) {

        Board board = boardRepository.findById(commentDTO.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        Comment comment = Comment.builder()
                .commentId(commentDTO.getCommentId())
                .content(commentDTO.getContent())
                .writer(commentDTO.getWriter())
                .commentDate(LocalDate.now())
                .board(board)
                .build();

        commentRepository.save(comment);
    }


    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}