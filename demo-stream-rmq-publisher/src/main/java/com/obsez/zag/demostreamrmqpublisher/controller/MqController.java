package com.obsez.zag.demostreamrmqpublisher.controller;

import com.obsez.zag.demostreamrmqpublisher.service.MqService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
@RefreshScope
@RequestMapping(value="/mq")
//@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class MqController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MqService mqService;

    @ApiOperation(value="发送文字信息(简单接口)", notes="传入 message 参数")
    @ApiImplicitParam(name = "msg", value = "文字内容", required = true, dataType = "String")
    @RequestMapping(method = RequestMethod.GET, path = "/send/{msg}", produces = "application/json")
    //@GetMapping("/{id}")
    public void sendMsg(@PathVariable String msg) {
        this.mqService.send(msg);
    }

    @ApiOperation(value="发送文字信息2(简单接口)", notes="传入 message 参数")
    @ApiImplicitParam(name = "msg", value = "文字内容", required = true, dataType = "String")
    @RequestMapping(method = RequestMethod.GET, path = "/many/{msg}", produces = "application/json")
    //@GetMapping("/{id}")
    public void sendMsg2(@PathVariable String msg) {
        this.mqService.sendMany(msg);
    }

    @ApiOperation(value="发送文字信息2(简单接口)", notes="传入 message 参数")
    @ApiImplicitParam(name = "msg", value = "文字内容", required = true, dataType = "String")
    @RequestMapping(method = RequestMethod.GET, path = "/many-many/{msg}", produces = "application/json")
    //@GetMapping("/{id}")
    public void sendMsg22(@PathVariable String msg) {
        this.mqService.sendManyToMany(msg);
    }


    @ApiOperation(value="发送文字信息2(简单接口)", notes="传入 message 参数")
    @ApiImplicitParam(name = "msg", value = "文字内容", required = true, dataType = "String")
    @RequestMapping(method = RequestMethod.GET, path = "/broadcast/{msg}", produces = "application/json")
    //@GetMapping("/{id}")
    public void sendMsgBBB(@PathVariable String msg) {
        this.mqService.sendBroadcast(msg);
    }



}
