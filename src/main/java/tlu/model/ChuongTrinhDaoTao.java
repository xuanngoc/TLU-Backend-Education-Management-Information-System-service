package tlu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ChuongTrinhDaoTao {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long maChuongTrinhDaoTao;
	
	@ManyToOne
	private NganhHoc nganhHoc;
	
	@ManyToOne
	private NamHoc namHoc;
	
	@OneToMany(mappedBy = "chuongTrinhDaoTao")
	private List<HocPhanThuocChuongTrinhDaoTao> hocChuongTrinhDaoTao;

	
	public ChuongTrinhDaoTao() {
		super();
	}
	
	public ChuongTrinhDaoTao(NganhHoc nganhHoc, NamHoc namHoc) {
		super();
		this.nganhHoc = nganhHoc;
		this.namHoc = namHoc;
	}



	public long getMaChuongTrinhDaoTao() {
		return maChuongTrinhDaoTao;
	}

	public void setMaChuongTrinhDaoTao(long maChuongTrinhDaoTao) {
		this.maChuongTrinhDaoTao = maChuongTrinhDaoTao;
	}

	public NganhHoc getNganhHoc() {
		return nganhHoc;
	}

	public void setNganhHoc(NganhHoc nganhHoc) {
		this.nganhHoc = nganhHoc;
	}

	public NamHoc getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(NamHoc namHoc) {
		this.namHoc = namHoc;
	}

	public List<HocPhanThuocChuongTrinhDaoTao> getHocChuongTrinhDaoTao() {
		return hocChuongTrinhDaoTao;
	}

	public void setHocChuongTrinhDaoTao(List<HocPhanThuocChuongTrinhDaoTao> hocChuongTrinhDaoTao) {
		this.hocChuongTrinhDaoTao = hocChuongTrinhDaoTao;
	}
	
}
