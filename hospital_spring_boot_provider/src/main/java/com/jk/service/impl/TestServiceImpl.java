package com.jk.service.impl;

import com.jk.dao.TestDao;
import com.jk.model.Tree;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List<Tree> queryParentList(int i) {
        return testDao.queryParentList(i);
    }

    @Override
    public List<Tree> queryAllList(List<Tree> list) {
        List<Tree> allList=new ArrayList<Tree>();

        if(list!=null&&list.size()!=0){
            for (int i = 0; i < list.size(); i++) {
                Tree  parentTree = list.get(i);
                List<Tree> queryChildList = testDao.queryParentList(parentTree.getId());
                if(queryChildList!=null&&queryChildList.size()!=0){
                    List<Tree> queryChildList2 = queryAllList(queryChildList);
                    parentTree.setNodes(queryChildList2);
                    allList.add(parentTree);
                }else{
                    allList.add(parentTree);
                }
            }
        }
        return allList;
    }
}
