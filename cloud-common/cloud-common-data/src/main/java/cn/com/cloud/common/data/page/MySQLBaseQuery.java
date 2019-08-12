package cn.com.cloud.common.data.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MySQLBaseQuery
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: myBatis分页查询处理类
 */
@Data
public class MySQLBaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name="page",value="当前页数", dataType = "Integer")
    private Integer page = 0;

    @ApiModelProperty(name="limit",value="每页条数", dataType = "Integer")
    private Integer limit = 10;

    /**
     * 排序的字段名称
     */
    @ApiModelProperty(name="sortName",value="排序字段名称", dataType = "String")
    private String sortName;

    /**
     * 排序规则，默认DESC
     */
    @ApiModelProperty(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", dataType = "String")
    private String sortOrder;

    /**
     * 开始时间
     */
    @ApiModelProperty(name="startTime",value="开始时间", dataType = "Date")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(name="endTime",value="结束时间", dataType = "Date")
    private Date endTime;

    public MySQLBaseQuery() {
        super();
    }

    public MySQLBaseQuery(Integer page, Integer limit, String sortName, String sortOrder, Date startTime, Date endTime) {
        this.page = page;
        this.limit = limit;
        this.sortName = sortName;
        this.sortOrder = sortOrder;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
