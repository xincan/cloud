package cn.com.cloud.common.data.universal;

import com.alibaba.fastjson.JSON;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: ResultCode
 * Author:   JiangXincan
 * Date:     2018-12-19 16:30:00
 * Description: 所有model重写toString方法
 */
public class BaseModel {

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+":"+JSON.toJSONString(this)+"\n";
    }
}
