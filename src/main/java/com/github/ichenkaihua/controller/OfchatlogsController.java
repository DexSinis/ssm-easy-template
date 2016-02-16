package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.Ofchatlogs;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.OfchatlogsService;
import com.github.ichenkaihua.utils.URIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("ofchatlogss")
@RestController
public class OfchatlogsController {
    private Logger logger = LoggerFactory.getLogger(OfchatlogsController.class);

    @Autowired
    OfchatlogsService ofchatlogsService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity getOfchatlogsBYId(@PathVariable int id){
        Ofchatlogs ofchatlogs = ofchatlogsService.getOfchatlogsById(id);
        if(ofchatlogs==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ofchatlogs);
    }

    @RequestMapping(value = "ofchatlogssBySelf/{id}",method = RequestMethod.GET)
    public ResponseEntity getUserBYId(@PathVariable String id){
        id = "dexsinis";
        List<Ofchatlogs> ofchatlogss =ofchatlogsService.getOfchatlogssBySelf(id);
        return new ResponseEntity(ofchatlogss, HttpStatus.OK);
    }

    @RequestMapping(value = "recentMsgArray",method = RequestMethod.POST)
    public ResponseEntity processSubmit(@ModelAttribute("ofchatlogs") Ofchatlogs pojo) {
        String id = "dexsinis";
        System.out.println("-----------------------"+pojo.getReceiver()+"+++++++++++++++++");
        List<Ofchatlogs> ofchatlogss =ofchatlogsService.getOfchatlogssBySelf(id);
        Map map = new HashMap();
        map.put("recentMsgArray",ofchatlogss);
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity addOfchatlogs(@RequestBody Ofchatlogs ofchatlogs)  {

        Ofchatlogs countOfchatlogs = new Ofchatlogs();
        ofchatlogs.setMessageid(ofchatlogs.getMessageid());
                //seofchatlogsname(ofchatlogs.geofchatlogsname());
        //如果存在，返回错误码
        if (ofchatlogsService.isExist(countOfchatlogs)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        ofchatlogsService.addOfchatlogs(ofchatlogs);
        return ResponseEntity.created(URIUtils.createURI("ofchatlogss/{id}",ofchatlogs.getMessageid())).body(ofchatlogs);

    }


    @RequestMapping(value = "",method =RequestMethod.GET )
    public ResponseEntity ofchatlogss(){
        List<Ofchatlogs> ofchatlogss =ofchatlogsService.getOfchatlogss(null);
        return new ResponseEntity(ofchatlogss, HttpStatus.OK);
    }



    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){
        ofchatlogsService.deleteById(id);
    }

    @RequestMapping
    public void update(@RequestBody Ofchatlogs ofchatlogs){
        ofchatlogsService.update(ofchatlogs);
    }











}
