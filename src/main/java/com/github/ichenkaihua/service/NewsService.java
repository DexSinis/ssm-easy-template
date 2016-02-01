package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.NewsMapper;
import com.github.ichenkaihua.model.News;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class NewsService  {

    @Autowired
    NewsMapper newsMapper;



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){
        newsMapper.deleteByPrimaryKey(id);
    }


    public News getNewsById(int id){
        return newsMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(News news){
        return  newsMapper.selectCount(news)>0;
    }


    public void addNews(News news){
        newsMapper.insert(news);
    }


    public List<News> getNewss(News news){
        if (news == null) {
            return newsMapper.selectAll();
        }

        return newsMapper.select(news);
    }


    public void deleteById(int id){
        newsMapper.deleteByPrimaryKey(id);

    }

    public void update(News news){
        newsMapper.updateByPrimaryKey(news);
    }


}
