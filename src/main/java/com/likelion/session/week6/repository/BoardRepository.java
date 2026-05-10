package com.likelion.session.week6.repository;

import com.likelion.session.week6.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByBoardId(Long boardId);

    //void save();

    void deleteByBoardId(Long boardId);
}
