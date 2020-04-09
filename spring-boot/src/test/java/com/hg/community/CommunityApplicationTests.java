package com.hg.community;

import com.hg.community.dao.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class CommunityApplicationTests {

	@Autowired
	CommentMapper commentMapper;

	@Test
	void contextLoads() {


		System.out.println(commentMapper.selectAllByPostIds(new ArrayList<>(){{
			add(1);
			add(2);
		}}));

	}

}
