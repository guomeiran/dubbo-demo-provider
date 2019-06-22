package com.gmr.dubbo.provider.remote.facade;


import com.gmr.dubbo.provider.remote.dto.DemoDto;
import com.gmr.dubbo.provider.remote.dto.Response;

/**
 * Banner 后台接口服务
 *
 * @author guomeiran
 * @since 2019/4/1 15:47
 */
public interface DemoFacade {

    Response<String> sayHello(DemoDto demoDto);
}
