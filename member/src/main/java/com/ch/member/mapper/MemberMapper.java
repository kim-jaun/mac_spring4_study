package com.ch.member.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.member.model.Member;
import com.ch.member.model.MemberPhoto;
@Mapper
public interface MemberMapper {
	Member select(String id);
	int insert(Member member);
	int update(Member member);
	int delete(String id);
	void insertPhotos(List<MemberPhoto> photos);
	void insertMp(MemberPhoto mp);
	List<MemberPhoto> listPhoto(String id);

}