package cn.com.cloud.app.demo.classroom.entity;


import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value = "Classroom",description = "班级信息实体类") // swagger生成文档类
@Data                       // 快捷生成Getter,Setter,equals,hashCode,toString函数
@NoArgsConstructor          // 快捷生成无参构造函数
@AllArgsConstructor         // 快捷生成全参构造函数
@Table(name = "st_class")   // 指定该类映射数据库表名
public class Classroom {
    @Id // 必须：ID唯一标识
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 动态生成UUID策略
    @Column(name = "id", length = 64)                   // 对应数据库表中的字段
    private String id;

    @Column(name = "classname",length = 100)
    private String classname;

    @Column(name = "grade",length = 100)
    private String grade;

    @Column(name = "population",length = 3)
    private Integer population;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")        // 利用阿里巴巴JSON对数据库时间类型字段进行转换
    @Column(name = "create_time")
    private Date createTime;
}
