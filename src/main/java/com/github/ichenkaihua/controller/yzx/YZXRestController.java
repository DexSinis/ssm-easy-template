package com.github.ichenkaihua.controller.yzx;


import com.github.ichenkaihua.model.TAccount;
import com.github.ichenkaihua.service.TAccountService;
import com.github.ichenkaihua.utils.URIUtils;
import com.ucpaas.restDemo.client.AbsRestClient;
import com.ucpaas.restDemo.client.JsonReqClient;
import com.ucpaas.restDemo.client.XmlReqClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

@RequestMapping("yzxRest")
@RestController
public class YZXRestController {
    private Logger logger = LoggerFactory.getLogger(com.github.ichenkaihua.controller.TAccountController.class);

    @Autowired
    TAccountService tAccountService;

    private String accountSid = "603edaecfd04e9382a8f9fe6ca637429";
    private String authToken  = "2014-06-30";
//    private String appId = "1da4b5910f08414d8bcba56aa90caa9b";
//    private String clientName,
//    private String chargeType,
//    private String charge,
//    private String mobile


    private String yzxAccountSid = "603edaecfd04e9382a8f9fe6ca637429";
    private String yzxSoftVersion = "2014-06-30";
    private String yzxAppToken = "145e5298b7e59a192153870d1185ac6e";
    private String yzxAppId = "1da4b5910f08414d8bcba56aa90caa9b";

    SimpleDateFormat df = new SimpleDateFormat("YYYYMMDDHHmmss");//设置日期格式
//    System.out.println(df.format(new Date()));
    private String dateStr = df.format(new Date()) ;//moment().format('YYYYMMDDHHmmss');

    public String getAccountSid() {
        return accountSid;
    }
    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
    public String getAuthToken() {
        return authToken;
    }
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
    static AbsRestClient InstantiationRestAPI(boolean enable) {
        if(enable) {
            return new JsonReqClient();
        } else {
            return new XmlReqClient();
        }
    }



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


    @RequestMapping(value = "/createClient",method =RequestMethod.GET )
    public ResponseEntity createClient(boolean json, String accountSid, String authToken, String appId, String clientName
            , String chargeType, String charge, String mobile){
        try {
            String result=InstantiationRestAPI(json).createClient(accountSid, authToken, appId, clientName, chargeType, charge,mobile);
            System.out.println("Response content is: " + result);
            return new ResponseEntity(result,HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

}
