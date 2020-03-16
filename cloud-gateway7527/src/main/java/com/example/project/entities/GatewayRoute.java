package com.example.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: tanxx
 * @create: 2020-03-16 10:35
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GatewayRoute  implements Serializable {

    private Long id;

    private String serviceId;

    private String uri;

    private String predicates;

    private Integer filters;

    private Integer order;

    private String creatorId;

    private Date createDate;

    private String updateId;

    private Date updateDate;

    private String remarks;

    private Integer delFlag;

}
