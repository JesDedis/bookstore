package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Integer id;
    private String name;
    private String type;
    private Integer sitnum;
    private String cid;
    private Double price;
    private Integer number;
    private String picture;
}
