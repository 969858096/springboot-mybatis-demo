package com.lsp.springbootmybatisdemo.entity;

import lombok.Data;

import java.util.HashMap;

// 角色信息表
@Data
public class Role {
	private Integer id;
	private String roleName;
	private String roleDesc;
}
