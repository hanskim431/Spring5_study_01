package spring.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dao.MemoDao;
import spring.domain.MemoVO;
import spring.domain.dto.MemoDTO;
import spring.exception.MemoNotFoundException;
import spring.exception.NotMatchingPasswordException;

public class MemoServiceTest {

	ApplicationContext ctx;
	private MemoService memoService;
	private MemoDao memoDao;
	
	@Before
	public void setUp() {
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		memoService = ctx.getBean(MemoService.class);
		memoDao = ctx.getBean(MemoDao.class);
	}
	
	@After
	public void tearUp() {
		((GenericXmlApplicationContext)ctx).close();
	}
	
	@Test
	@Ignore
	public void testInsert() {
		System.out.println("testInsert :");
		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setContent("memo111");
		memoDTO.setWirter("admin");
		memoDTO.setPassword("1111");
		memoDTO.setConfirmPassword("1111");
		memoService.register(memoDTO);
		
		MemoVO findVO = memoDao.selectById(4L);
		System.out.println(findVO);
	}
	
	@Test (expected = NotMatchingPasswordException.class)
	@Ignore
	public void testInsert2() {
		System.out.println("testInsert2 :");
		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setContent("memo111");
		memoDTO.setWirter("admin");
		memoDTO.setPassword("1111");
		memoDTO.setConfirmPassword("111121");
		memoService.register(memoDTO);
	}
	
	@Test
	public void testModify() {
		System.out.println("testInsert3 :");
		
		MemoDTO dto = new MemoDTO();
		dto.setContent("¼öÁ¤ 1¹ø");
		memoService.modify(1L, "1111", dto);
		
		MemoVO findVo = memoDao.selectById(1L);
		assertEquals(dto.getContent(), findVo.getContent());
		System.out.println(findVo);
	}
	
	
}
