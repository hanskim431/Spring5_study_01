package spring.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;import org.springframework.objenesis.instantiator.util.DefineClassHelper;

import spring.domain.MemoVO;

public class MemoDaoTest {
	ApplicationContext ctx;
	private MemoDao memoDao;
	
	@Before
	public void setUp() { // 각 테스트마다 독립적임
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		memoDao = ctx.getBean(MemoDao.class);
	}
	
	@After
	public void tearUp() {
		((GenericXmlApplicationContext)ctx).close();
	}
	
	@Test
	public void testSelectAll() {
		List<MemoVO> memoList = memoDao.selectAll();
		System.out.println(memoList);
		
		assertNotNull(memoList); // 게시글이 존재함을 테스트
		assertEquals(3, memoList.size()); // 게시글 3개임
	}

	@Test
	public void testSelectById() {
		MemoVO findMemo = memoDao.selectById(1L);
		assertNotNull(findMemo); // 게시글이 존재함을 테스트
		System.out.println(findMemo);
		
		findMemo = memoDao.selectById(100L);
		assertNull(findMemo); // 게시글이 없음을 테스트
		
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testSelectById2() {
		MemoVO findMemo = memoDao.selectById(100L);
		assertNull(findMemo.getId()); // 없는 값의 ID 를 조회하면 NullPointerException 이 발생함
	}
	
	@Test
	public void testInsert() {
		memoDao.insert(new MemoVO(null, "memo4", "writer4", "444", new Date()));
		MemoVO findMemo = memoDao.selectById(4L);
		assertNotNull(findMemo); // 없는 값의 ID 를 조회하면 NullPointerException 이 발생함
		System.out.println(findMemo);
	}
	
	@Test
	public void testUpdate() {
		MemoVO findMemo = memoDao.selectById(1L);

		findMemo.setContent("수정1");
		findMemo.setPassword("0000");
		memoDao.update(findMemo);
		
		findMemo = memoDao.selectById(1L);
		System.out.println(findMemo);
	}

}
