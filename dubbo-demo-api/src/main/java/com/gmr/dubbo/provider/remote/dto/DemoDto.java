package com.gmr.dubbo.provider.remote.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * @author guomeiran
 * @since 2019/4/3 15:14
 */
@Data
@Accessors(chain = true)
public class DemoDto implements Serializable {

    private static final long serialVersionUID = 2304183034337703733L;

    private Long id;

    private String name;
}
