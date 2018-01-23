package com.jk.dao;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tree record);

    int insertSelective(Tree record);

    Tree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);

    List<Tree> queryParentList(@Param("id") int i);
}