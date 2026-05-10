package com.likelion.session.week6.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDTO {

    private Long commentId;

    private String content;

    private String writer;

    private Date commentDate;

    // 게시글
    private Long boardId;
}