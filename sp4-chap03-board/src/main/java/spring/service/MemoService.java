package spring.service;

import java.util.Date;

import spring.dao.MemoDao;
import spring.domain.MemoVO;
import spring.domain.dto.MemoDTO;
import spring.exception.MemoNotFoundException;
import spring.exception.NotMatchingPasswordException;

public class MemoService {

	private MemoDao memoDao;

	public MemoService(MemoDao memoDao) {
		this.memoDao = memoDao;
	}
	
	// Create
	public void register(MemoDTO memoDTO) {
		// 비밃번호 일치여부 확인
		if(!memoDTO.isPasswordMatching()) {
			throw new NotMatchingPasswordException("비밀번호와 비밀번호확인이 일치하지 않음");
		}
		
		MemoVO  vo = new MemoVO(memoDTO.getContent(), memoDTO.getWirter(), memoDTO.getPassword(), new Date());
		
		memoDao.insert(vo);
	}

	// Read
	
	
	// Update
	public void modify(Long id, String pwd, MemoDTO memoDTO) {
		// 게시글이 없는 경우 : 
		MemoVO selectVO = memoDao.selectById(id);
		if(selectVO==null) {
			throw new MemoNotFoundException("게시글이 존재하지 않습니다.");
		}
		
		// 게시글이 있는경우
			// 비밀번호가 일치하지 않을 경우 : NotMatchingPasswordException
		if(!selectVO.isMatchingPassword(pwd)) {
			throw new NotMatchingPasswordException("비밀번호가 맞지 않습니다.");
		}
		
			// 비밀번호가 일치할 경우 : 수정 처리
		selectVO.setContent(memoDTO.getContent());
		memoDao.update(selectVO);
	}
	
	// Delete
	public void delete(Long id) {
		
	}
	// List
}
