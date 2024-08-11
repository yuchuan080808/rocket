package com.mantianxing.rocket.application.server.dataObject;

import lombok.Data;

import java.util.Date;

@Data
public class CommentsDO {
    /**
     * ID
     */
    private Long commentId;

    private Long commentPostId;

    private String commentAuthor;

    private String commentAuthorEmail;

    private String commentAuthorUrl;

    private String commentAuthorIp;

    private Date commentDate;

    private Date commentDateGmt;

    private String commentContent;

    private Long commentKarma;

    private String commentApproved;

    private String commentAgent;

    private String commentType;

    private Long commentParent;

    private Long userId;
}
