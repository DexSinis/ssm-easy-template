package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.News;
import com.github.ichenkaihua.service.NewsService;
import com.github.ichenkaihua.utils.URIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import tk.mybatis.mapper.entity.Example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("newss")
@RestController
public class NewsController {
    private Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    NewsService newsService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity getNewsBYId(@PathVariable int id){
        News news = newsService.getNewsById(id);
        if(news==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(news);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity addNews(@RequestBody News news)  {

        News countNews = new News();
        news.setName(news.getName());
        //如果存在，返回错误码
        if (newsService.isExist(countNews)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        newsService.addNews(news);
        return ResponseEntity.created(URIUtils.createURI("newss/{id}",news.getId())).body(news);

    }


    @RequestMapping(value = "",method =RequestMethod.GET )
    public ResponseEntity newss(){
        List<News> newss =newsService.getNewss(null);
        return new ResponseEntity(newss, HttpStatus.OK);
    }



    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){
        newsService.deleteById(id);
    }

    @RequestMapping
    public void update(@RequestBody News news){
        newsService.update(news);
    }











}
