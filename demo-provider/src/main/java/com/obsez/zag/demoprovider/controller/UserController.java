package com.obsez.zag.demoprovider.controller;

import com.obsez.zag.demoprovider.domain.User;
import com.obsez.zag.demoprovider.repository.UserRepository;
import com.obsez.zag.demoprovider.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * @author laoye
 *
 * @api {get} /user/:id Request User information
 * @apiName GetUser
 * @apiGroup User
 *
 * @apiParam {Number} id Users unique ID.
 *
 * @apiSuccess {String} firstname Firstname of the User.
 * @apiSuccess {String} lastname  Lastname of the User.
 */
@RestController
@Lazy
@RefreshScope
@RequestMapping(value="/user")
//@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BaseService baseService;


    /**
     * @api {get} /user/:id Request User information
     * @apiName GetUser
     * @apiGroup User
     *
     * @apiParam {Number} id Users unique ID.
     *
     * @apiSuccess {User} entity of the User.
     *
     *
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     *
     * @param id
     * @return user信息
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     *
     * 类似的注解还有@PostMapping等等
     */
    //@ApiOperation(value="获取用户信息", notes="传入 userId 参数")
    //@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", format = "int64")
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    //@GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.getOne(id);
    }

    /**
     * 本地服务实例的信息

     * @api {get} /user/instance-info Request User information
     * @apiName showInfo
     * @apiGroup User
     *
     * @apiSuccess {ServiceInstance} entity of Service Instance.
     *
     * @return
     */
    //@ApiOperation(value="获取依赖服务的当前实例信息", notes="识别掩盖在集群之下的真实服务实例的信息概要")
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        //ServiceInstance localServiceInstance = this.discoveryClient.getInstances();
        //return localServiceInstance;

        if (logger.isDebugEnabled()) {
            discoveryClient.getServices().forEach(id -> {
                discoveryClient.getInstances(id).forEach(instance -> {
                    logger.info("/instance-info, host: {}, service_id: {}", instance.getHost(), instance.getServiceId());
                });
            });
        }

        ServiceInstance si = baseService.getThisInstanceInfo();
        logger.info("ServiceInstance got: {}", si.getClass().getCanonicalName());
        return si;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

}
