package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.TAccount;
import com.github.ichenkaihua.service.TAccountService;
import com.github.ichenkaihua.utils.URIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tAccounts")
@RestController
public class TAccountController {
    private Logger logger = LoggerFactory.getLogger(TAccountController.class);

    @Autowired
    TAccountService tAccountService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity getTAccountBYId(@PathVariable int id){
        TAccount tAccount = tAccountService.getTAccountById(id);
        if(tAccount==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tAccount);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity addTAccount(@RequestBody TAccount tAccount)  {

        TAccount countTAccount = new TAccount();
        tAccount.setAccountname(tAccount.getAccountname());
        //如果存在，返回错误码
        if (tAccountService.isExist(countTAccount)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        tAccountService.addTAccount(tAccount);
        return ResponseEntity.created(URIUtils.createURI("tAccounts/{id}",tAccount.getId())).body(tAccount);

    }


    @RequestMapping(value = "",method =RequestMethod.GET )
    public ResponseEntity tAccounts(){
        List<TAccount> tAccounts =tAccountService.getTAccounts(null);
        return new ResponseEntity(tAccounts, HttpStatus.OK);
    }



    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){
        tAccountService.deleteById(id);
    }

    @RequestMapping
    public void update(@RequestBody TAccount tAccount){
        tAccountService.update(tAccount);
    }











}
