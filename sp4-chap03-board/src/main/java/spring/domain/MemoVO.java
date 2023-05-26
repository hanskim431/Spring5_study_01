package spring.domain;

import java.util.Date;

public class MemoVO {

	private Long id;
	private String content;
	private String wirter;
	private String password;
	private Date regDate;
	
	public MemoVO() {}

	@Override
	public String toString() {
		return "MemoVO [id=" + id + ", content=" + content + ", wirter=" + wirter + ", password=" + password
				+ ", regDate=" + regDate + "]";
	}
	
	public MemoVO(Long id, String content, String wirter, String password, Date regDate) {
		this.id = id;
		this.content = content;
		this.wirter = wirter;
		this.password = password;
		this.regDate = regDate;
	}

	public MemoVO(String content, String wirter, String password, Date regDate) {
		this.content = content;
		this.wirter = wirter;
		this.password = password;
		this.regDate = regDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWirter() {
		return wirter;
	}

	public void setWirter(String wirter) {
		this.wirter = wirter;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean isMatchingPassword(String password) {
		return this.password.equals(password);
	}
	
	
}
