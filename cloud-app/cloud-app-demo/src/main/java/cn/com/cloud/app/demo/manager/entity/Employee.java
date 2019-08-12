package cn.com.cloud.app.demo.manager.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 员工管理实体类
 */
@ApiModel(value = "Employee",description = "员工信息实体类") // swagger生成文档类
@Data                       // 快捷生成Getter,Setter,equals,hashCode,toString函数
@NoArgsConstructor          // 快捷生成无参构造函数
@AllArgsConstructor         // 快捷生成全参构造函数
@Table(name = "employee")   // 指定该类映射数据库表名
public class Employee {

    @Id // 必须：ID唯一标识
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 动态生成UUID策略
    @Column(name = "id", length = 64)                   // 对应数据库表中的字段
    private String id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "age",length = 3)
    private Integer age;

    @Column(name = "sex",length = 1)
    private  Integer sex;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")        // 利用阿里巴巴JSON对数据库时间类型字段进行转换
    @Column(name = "create_time")
    private Date createTime;


}
