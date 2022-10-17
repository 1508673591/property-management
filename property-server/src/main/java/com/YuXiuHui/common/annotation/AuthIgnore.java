package com.YuXiuHui.common.annotation;

import java.lang.annotation.*;

/**
 * api接口，忽略Token验证
 * @author GDUFSlqm
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {

}
