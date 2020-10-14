package tlu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "THU_VIEN")
public class ThuVien {
	
	@Id
	@Column(name = "MA_THU_VIEN")
	private int maThuVien;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	
	public ThuVien() {
		super();
	}

	public ThuVien(int maThuVien, User user) {
		super();
		this.maThuVien = maThuVien;
		this.user = user;
	}

	public int getMaThuVien() {
		return maThuVien;
	}

	public void setMaThuVien(int maThuVien) {
		this.maThuVien = maThuVien;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
