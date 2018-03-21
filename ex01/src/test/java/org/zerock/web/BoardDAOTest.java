package org.zerock.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
//	@Test
//	public void testCreate() throws Exception{
//		
//		BoardVO board= new BoardVO();
//		board.setTitle("새로운글");
//		board.setContent("새로운내용");
//		board.setWriter("user111");
//		dao.create(board);
//	}
//
//	@Test
//	public void testRead()throws Exception{
//		logger.info(dao.read(1).toString());
//	}
//	
//	@Test
//	public void testUpdate() throws Exception{
//		
//		BoardVO board = new BoardVO();
//		board.setBno(1);
//		board.setTitle("수정");
//		board.setContent("수정된내용");
//		System.out.println(board);
//		dao.update(board);
//	}
//	
//	@Test
//	public void testDelete()throws Exception{
//		dao.delete(1);
//	}
//	
	@Test
	public void testListPage()throws Exception{
		int page = 3;
		
		List<BoardVO> list = dao.listpage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
	}
	
	@Test
	public void testListCriteria() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPagerNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
		
	}
}
