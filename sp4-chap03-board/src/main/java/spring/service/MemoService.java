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
		// ��A��ȣ ��ġ���� Ȯ��
		if(!memoDTO.isPasswordMatching()) {
			throw new NotMatchingPasswordException("��й�ȣ�� ��й�ȣȮ���� ��ġ���� ����");
		}
		
		MemoVO  vo = new MemoVO(memoDTO.getContent(), memoDTO.getWirter(), memoDTO.getPassword(), new Date());
		
		memoDao.insert(vo);
	}

	// Read
	
	
	// Update
	public void modify(Long id, String pwd, MemoDTO memoDTO) {
		// �Խñ��� ���� ��� : 
		MemoVO selectVO = memoDao.selectById(id);
		if(selectVO==null) {
			throw new MemoNotFoundException("�Խñ��� �������� �ʽ��ϴ�.");
		}
		
		// �Խñ��� �ִ°��
			// ��й�ȣ�� ��ġ���� ���� ��� : NotMatchingPasswordException
		if(!selectVO.isMatchingPassword(pwd)) {
			throw new NotMatchingPasswordException("��й�ȣ�� ���� �ʽ��ϴ�.");
		}
		
			// ��й�ȣ�� ��ġ�� ��� : ���� ó��
		selectVO.setContent(memoDTO.getContent());
		memoDao.update(selectVO);
	}
	
	// Delete
	public void delete(Long id) {
		
	}
	// List
}
