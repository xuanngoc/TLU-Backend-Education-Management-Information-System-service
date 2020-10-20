package tlu.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "BO_MON")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="maBoMon", scope=BoMon.class)
public class BoMon {
	
	@Id
	@Column(name = "MA_BO_MON", length = 10)
	private String maBoMon;
	
	@Column(name = "TEN_BO_MON", length = 30)
	private String tenBoMon;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TRUONG_BO_MON")
	private GiaoVien truongBoMon;
	
	@OneToMany(mappedBy = "thuocBoMon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<GiaoVien> danhSachGiaoVien;

	
	

	public BoMon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoMon(String maBoMon, String tenBoMon, GiaoVien truongBoMon, Collection<GiaoVien> danhSachGiaoVien) {
		super();
		this.maBoMon = maBoMon;
		this.tenBoMon = tenBoMon;
		this.truongBoMon = truongBoMon;
		this.danhSachGiaoVien = danhSachGiaoVien;
	}

	public String getMaBoMon() {
		return maBoMon;
	}

	public void setMaBoMon(String maBoMon) {
		this.maBoMon = maBoMon;
	}

	public String getTenBoMon() {
		return tenBoMon;
	}

	public void setTenBoMon(String tenBoMon) {
		this.tenBoMon = tenBoMon;
	}

	public GiaoVien getTruongBoMon() {
		return truongBoMon;
	}

	public void setTruongBoMon(GiaoVien truongBoMon) {
		this.truongBoMon = truongBoMon;
	}

	public Collection<GiaoVien> getDanhSachGiaoVien() {
		return danhSachGiaoVien;
	}

	public void setDanhSachGiaoVien(Collection<GiaoVien> danhSachGiaoVien) {
		this.danhSachGiaoVien = danhSachGiaoVien;
	}
	
}
