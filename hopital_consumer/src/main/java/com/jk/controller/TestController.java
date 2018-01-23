package com.jk.controller;

import com.jk.model.Tree;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
      @Autowired
    private TestService testService;

      //查询树
    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        //查询父级
        List<Tree> parentList=testService.queryParentList(0);
        //查询子级
        List<Tree> allList=testService.queryAllList(parentList);

        return  allList;
    }
}
