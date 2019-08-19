package cn.com.cloud.app.demo.grade.entity;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@ApiModel(value = "Grade",description = "年级信息实体类") // swagger生成文档类
@Data                       // 快捷生成Getter,Setter,equals,hashCode,toString函数
@NoArgsConstructor          // 快捷生成无参构造函数
@AllArgsConstructor         // 快捷生成全参构造函数
@Table(name = "grade")   // 指定该类映射数据库表名
public class Grade {
    @Id // 必须：ID唯一标识
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 动态生成UUID策略
    @Column(name = "id", length = 64)                   // 对应数据库表中的字段
    private String id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "pid",length = 100)
    private String pid;

    private List<Grade> children;
}
