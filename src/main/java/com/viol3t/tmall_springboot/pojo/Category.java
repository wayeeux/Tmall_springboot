package com.viol3t.tmall_springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


/**
 * 前后端分离
 * @Entity 表示这是一个实体类
 * @Table(name = "category") 表示对应的表名是 category
 * @JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
 *   前后端数据交互用的是 json 格式 Category 对象就会被转换为 json 数据
 *   使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate
 *   jpa 工作过程中，创造代理类来继承 Category
 *   并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性
 *   所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;

    @Transient
    List<Product> products;
    @Transient
    List<List<Product>> productsByRow;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
