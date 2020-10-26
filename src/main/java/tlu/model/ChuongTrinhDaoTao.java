package tlu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ChuongTrinhDaoTao {

	@Id
	@GeneratedValue
	private long maChuongTrinhDaoTao;
	
	@ManyToOne
	private NganhHoc nganhHoc;
	
	@ManyToOne
	private NamHoc namHoc;
	
	@OneToMany(mappedBy = "chuongTrinhDaoTao")
	private Set<HocPhanThuocChuongTrinhDaoTao> hocChuongTrinhDaoTao = new HashSet<HocPhanThuocChuongTrinhDaoTao>();

	
	public ChuongTrinhDaoTao() {
		super();
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

	public Set<HocPhanThuocChuongTrinhDaoTao> getHocChuongTrinhDaoTao() {
		return hocChuongTrinhDaoTao;
	}

	public void setHocChuongTrinhDaoTao(Set<HocPhanThuocChuongTrinhDaoTao> hocChuongTrinhDaoTao) {
		this.hocChuongTrinhDaoTao = hocChuongTrinhDaoTao;
	}
	
}
