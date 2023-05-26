package spring.dao; // 23/05/26

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.domain.MemoVO;

public class MemoDao {

	private static Long nextId = 3L;
	
	private Map<Long, MemoVO> memoMap = new HashMap<>();
		
	public MemoDao() {
		MemoVO vo1 = new MemoVO(1L, "memo1", "writer1", "1111", new Date());
		MemoVO vo2 = new MemoVO(2L, "memo2", "writer2", "2222", new Date());
		MemoVO vo3 = new MemoVO(3L, "memo3", "writer3", "3333", new Date());
		
		memoMap.put(vo1.getId(), vo1);
		memoMap.put(vo2.getId(), vo2);
		memoMap.put(vo3.getId(), vo3);
		
	}
	// List
	public List<MemoVO> selectAll() {
//		Collection<MemoVO> values = memoMap.values();
//		return new ArrayList<MemoVO>(values);
		return new ArrayList<MemoVO>(memoMap.values());
	}
	
	// Create
	public void insert(MemoVO memo) {
		memo.setId(++nextId);
		memoMap.put(memo.getId(), memo); // memo.getId() = ++nextId 값은 같으나 오류의 가능성을 낮추기 위해
		
	}
	
	// Read
	public MemoVO selectById(Long id) {
		return memoMap.get(id);
	}
	
	// Update
	public void update(MemoVO memo) {
		memoMap.put(memo.getId(), memo); // memo.getId() = ++nextId 값은 같으나 오류의 가능성을 낮추기 위해
	}
	
	// Delete
	
}
