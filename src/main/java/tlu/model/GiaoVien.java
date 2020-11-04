package tlu.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "GIAO_VIEN")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="maGiaoVien", scope=GiaoVien.class)
public class GiaoVien implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MA_GIAO_VIEN", length = 10,  nullable = true)
	private String maGiaoVien;
	
	@ManyToOne
	@JoinColumn(name = "MA_BO_MON", nullable = true)
	private BoMon thuocBoMon;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", nullable = true)
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
