package com.ch.mysql.dto;
import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("board")
public class Board {
	private int boardIdx;
	private String title; 
	private String contents; 
	private int hitCnt; 
	private String creatorId; ;
	private Date createdDate;;
	private String deletedYn;
}