package com.gmr.dubbo.provider.service.facade.impl;

import com.gmr.dubbo.provider.common.annotation.Api;
import com.gmr.dubbo.provider.remote.dto.DemoDto;
import com.gmr.dubbo.provider.remote.dto.Response;
import com.gmr.dubbo.provider.remote.facade.DemoFacade;
import org.springframework.stereotype.Service;

@Service("demoFacade")
public class DemoFacadeImpl implements DemoFacade {

    @Api
    @Override
    public Response<String> sayHello(DemoDto dto) {
        Response<String> response = Response.success();
        response.setData("hello world !");
        return response;
    }
}
