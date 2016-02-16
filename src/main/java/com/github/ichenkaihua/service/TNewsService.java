package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.TNewsMapper;
import com.github.ichenkaihua.model.TNews;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class TNewsService {

    @Autowired
    TNewsMapper tNewsMapper;



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){
        tNewsMapper.deleteByPrimaryKey(id);
    }


    public TNews getTNewsById(int id){
        return tNewsMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(TNews tNews){
        return  tNewsMapper.selectCount(tNews)>0;
    }


    public void addTNews(TNews tNews){
        tNewsMapper.insert(tNews);
    }


    public List<TNews> getTNewss(TNews tNews){
        if (tNews == null) {
            return tNewsMapper.selectAll();
        }

        return tNewsMapper.select(tNews);
    }


    public void deleteById(int id){
        tNewsMapper.deleteByPrimaryKey(id);

    }

    public void update(TNews tNews){
        tNewsMapper.updateByPrimaryKey(tNews);
    }


}
