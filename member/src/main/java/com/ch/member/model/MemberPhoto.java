package com.ch.member.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("memberphoto")
public class MemberPhoto {
	private int num;
	private String id;
	private String fileName;
}