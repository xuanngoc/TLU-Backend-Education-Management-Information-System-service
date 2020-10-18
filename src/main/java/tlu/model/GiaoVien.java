package tlu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "GIAO_VIEN")
public class GiaoVien {
	
	@Id
	@Column(name = "MA_GIAO_VIEN", length = 10)
	private String maGiaoVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MA_BO_MON")
	private BoMon thuocBoMon;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	
	public GiaoVien() {
		super();
	}
	
	public GiaoVien(String maGiaoVien, BoMon thuocBoMon, User user) {
		super();
		this.maGiaoVien = maGiaoVien;
		this.thuocBoMon = thuocBoMon;
		this.user = user;
	}


	public String getMaGiaoVien() {
		return maGiaoVien;
	}

	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public BoMon getThuocBoMon() {
		return thuocBoMon;
	}

	public void setThuocBoMon(BoMon thuocBoMon) {
		this.thuocBoMon = thuocBoMon;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
