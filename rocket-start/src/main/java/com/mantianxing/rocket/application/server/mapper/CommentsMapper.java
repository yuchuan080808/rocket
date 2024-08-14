package com.mantianxing.rocket.application.server.mapper;

import com.mantianxing.rocket.application.server.dataObject.CommentsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsMapper {

    List<CommentsDO> query(CommentsDO query);
}
