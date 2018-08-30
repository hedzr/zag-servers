package com.obsez.zag.democonsumer.user.controller;

import com.obsez.zag.democonsumer.user.entity.User;
import com.obsez.zag.democonsumer.user.service.RibbonService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping(value="/ribbon")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @ApiOperation(value="获取用户信息", notes="传入 userId 参数")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", format = "int64")
    //})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成")
            //        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            //        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            //        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            //        @ApiResponse(code = 500, message = "服务器不能完成请求")
    })
    @GetMapping("/{userId}")
    public User findById(@PathVariable Long userId) {
        return this.ribbonService.findById(userId);
    }

    @ApiOperation(value="获取依赖服务的当前实例信息", notes="识别掩盖在集群之下的真实服务实例的信息概要")
    @GetMapping("/server-info")
    public ServiceInstance getServerInfo() {
        return this.ribbonService.getServerInfo();
    }

    @ApiOperation(value="获取依赖服务的当前实例信息(APIGW)", notes="借助APIGW识别掩盖在集群之下的真实服务实例的信息概要")
    @GetMapping("/instance-info")
    public ServiceInstance getServerInfoByGW() {
        return this.ribbonService.getServerInfoByGW();
    }
}
