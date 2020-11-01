package tlu.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HocPhanThuocChuongTrinhDaoTaoID implements Serializable {

	
	private static final long serialVersionUID = 8165221362762243236L;

	private long maChuongTrinhDaoTao;
	private String maMonHoc;
	
	public HocPhanThuocChuongTrinhDaoTaoID() {
		super();
	}

	public HocPhanThuocChuongTrinhDaoTaoID(long maChuongTrinhDaoTao, String maMonHoc) {
		super();
		this.maChuongTrinhDaoTao = maChuongTrinhDaoTao;
		this.maMonHoc = maMonHoc;
	}

	public long getMaChuongTrinhDaoTao() {
		return maChuongTrinhDaoTao;
	}

	public void setMaChuongTrinhDaoTao(long maChuongTrinhDaoTao) {
		this.maChuongTrinhDaoTao = maChuongTrinhDaoTao;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	
}
