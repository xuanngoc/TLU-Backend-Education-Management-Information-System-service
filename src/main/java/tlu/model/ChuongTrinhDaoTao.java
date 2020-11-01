package tlu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="maChuongTrinhDaoTao", scope=ChuongTrinhDaoTao.class)
public class ChuongTrinhDaoTao {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long maChuongTrinhDaoTao;
	
	@ManyToOne
	private NganhHoc nganhHoc;
	
	@ManyToOne
	private NamHoc namHoc;
	
	@OneToMany(mappedBy = "chuongTrinhDaoTao")
	private List<HocPhanThuocChuongTrinhDaoTao> hocPhanThuocChuongTrinhDaoTaos;

	
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
		return hocPhanThuocChuongTrinhDaoTaos;
	}

	public void setHocChuongTrinhDaoTao(List<HocPhanThuocChuongTrinhDaoTao> hocChuongTrinhDaoTao) {
		this.hocPhanThuocChuongTrinhDaoTaos = hocChuongTrinhDaoTao;
	}
	
}
