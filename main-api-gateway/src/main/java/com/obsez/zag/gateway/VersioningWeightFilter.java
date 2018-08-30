package com.obsez.zag.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

public class VersioningWeightFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ROUTE_TYPE;
    }

    /**
     * 在 RibbonRoutingFilter 之前进行路由判定，如有必要，则执行版本化的权重路由，否则留交
     * RibbonRoutingFilter 进行默认处理（默认为轮询算法）。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return RIBBON_ROUTING_FILTER_ORDER - 1;
    }

    /**
     * 后端为 微服务 时，应该由本Filter进行处理。
     * 微服务 /actuator/info 接口具有 info.git.version 时，则本 Filter 将接管路由算法。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getRouteHost() == null && ctx.get(SERVICE_ID_KEY) != null && ctx.sendZuulResponse())
            return true;
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(SERVICE_ID_KEY);
        Boolean retryable = (Boolean) ctx.get(RETRYABLE_KEY);
        Object loadBalancerKey = ctx.get(LOAD_BALANCER_KEY);
        String reqUriKey = (String) ctx.get(REQUEST_URI_KEY);
        String proxyKey = (String) ctx.get(PROXY_KEY);
        log.info(String.format("run() 1: serviceId=%s, retryable=%b, loadBalancerKey=%s, requestUriKey=%s, proxyKey=%s",
                serviceId, retryable, loadBalancerKey, reqUriKey, proxyKey));

        if (obsezConfig.getLb().containsKey(serviceId)) {
            Map<String, Integer> verWeights = obsezConfig.getLb().get(serviceId);
            log.info(String.format("  obsez.lb.%s:", serviceId));
            for (String v : verWeights.keySet()) {
                log.info(String.format("      %s -> %d", v, verWeights.get(v)));
            }

            // 实际上发现，通过 RibbonCommandContext 构造一个上下文，直接转交 RibbonCommand 去完成 LB 去了
            // 因此，直接对 Ribbon 部分进行拦截，而不是在这里做
        }

        return null;//nothing to do
    }

    private synchronized VW rvw(String serviceId, URL host) {
        if (!rvwMap.containsKey(serviceId)) {
            rvwMap.put(serviceId, new LinkedHashMap<>());
        }
        Map<URL, VW> vwm = rvwMap.get(serviceId);
        if (!vwm.containsKey(host)) {
            vwm.put(host, new VW());
        }
        return vwm.get(host);
    }

    private Map<String/*serviceId*/, Map<URL, VW>> rvwMap = new LinkedHashMap<>();

    @Autowired
    ObsezConfig obsezConfig;

    private static final Log log = LogFactory.getLog(VersioningWeightFilter.class);
}

class VW {
    //public URL host;
    public String version;
}
