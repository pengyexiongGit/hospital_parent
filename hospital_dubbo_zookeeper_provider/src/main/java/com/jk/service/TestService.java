package com.jk.service;

import com.jk.model.Tree;

import java.util.List;

public interface TestService {
    List<Tree> queryParentList(int i);

    List<Tree> queryAllList(List<Tree> parentList);
}
