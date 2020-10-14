package tlu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "SINH_VIEN")
public class SinhVien {
	
	@Id
	private int maSinhVien;
	
	@Column(name = "NIEN_KHOA")
	private String nienKhoa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	
	public SinhVien() {
		super();
	}
	
	public SinhVien(int maSinhVien, String nienKhoa, User user) {
		super();
		this.maSinhVien = maSinhVien;
		this.nienKhoa = nienKhoa;
		this.user = user;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
