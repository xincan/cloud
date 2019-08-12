package cn.com.cloud.common.data.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright (C), 2018,北京同创永益科技发展有限公司
 * @ProjectName: hatech
 * @Package: cn.com.hatech.common.data.utils
 * @ClassName: SelectLlikeUtil
 * @Author: Xincan
 * @Description: ${description}
 * @Date: 2019/4/18 15:12
 * @Version: 1.0
 */
public class SelectLlikeUtil {


    /**
     * 模糊查询字符串处理
     * 如果第一位是百分号则转化成\%
     *
     * @Method
     * @Author Xincan
     * @Version  1.0
     * @Description
     * @Return
     * @Exception
     * @Date 2019/4/18 15:07
     */
    public static void executeLikeProperties(Map<String, Object> map, String ...property){
        if(property.length>0){
            Arrays.stream(property).forEach(item ->{
               Object obj = map.get(item);
               if(obj != null){
                   String value = obj.toString();
                   if(value.length() == 1 && value.startsWith("%")){
                       value = "\\%" + value.substring(1);
                   }
                   map.put(item, value);
               }
            });
        }
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "%");
        map.put("name1","%ae%sf");
        map.put("name2","ae%sf");
        map.put("name3",null);

        executeLikeProperties(map,"name","name1","name2","name3");

        System.out.println(map);

    }

}
