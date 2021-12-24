package com.ch.member.model;
import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;
@Data
@Alias("member")
public class Member {
	private String id;
	private String email;
	private String password;
	private String name;
	private String fileName;
	private String del;
	private Date regdate;
	// upload용
	private MultipartFile file;
}