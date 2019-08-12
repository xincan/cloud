package cn.com.cloud.common.data.page;

import java.util.Map;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: myBatis分页处理类
 */
public class MybatisPage {

    public static int page = 0;
    public static int limit = 10;
    /**
     * 计算分页
     * @param map
     * @return
     */
    public static int[] getPageSize(Map<String, Object> map){
        if(map.containsKey("page") && map.containsKey("limit")){
            int p = Integer.parseInt(map.get("page").toString());
            int s = Integer.parseInt(map.get("limit").toString());
            MybatisPage.page = p;
            MybatisPage.limit = s;
        }
        return new int[]{MybatisPage.page, MybatisPage.limit};
    }

    /**
     * 计算分页
     * @param page
     * @param size
     * @return
     */
    public static int[] getPageSize(int page, int size){
        if(size>0){
            MybatisPage.page = (page-1)*size;
            MybatisPage.limit = size;
        }
        return new int[]{MybatisPage.page, MybatisPage.limit};
    }
    
    //添加主类为打包用
    public static void main(String[] args) {
		
	}
}
