package tlu.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class HocPhanThuocChuongTrinhDaoTao {

	@EmbeddedId
	private HocPhanThuocChuongTrinhDaoTaoID hocPhanThuocChuongTrinhDaoTaoID = new HocPhanThuocChuongTrinhDaoTaoID();
	
	@ManyToOne
	@MapsId("monHocId")
	private MonHoc monHoc;
	
	@ManyToOne
	@MapsId("chuongTrinhDaoTaoID")
	private ChuongTrinhDaoTao chuongTrinhDaoTao;
	
	private String loaiChuongTrinh;

	
	public HocPhanThuocChuongTrinhDaoTao() {
		super();
	}

	public HocPhanThuocChuongTrinhDaoTao(HocPhanThuocChuongTrinhDaoTaoID hocPhanThuocChuongTrinhDaoTaoID, MonHoc monHoc,
			ChuongTrinhDaoTao chuongTrinhDaoTao, String loaiChuongTrinh) {
		super();
		this.hocPhanThuocChuongTrinhDaoTaoID = hocPhanThuocChuongTrinhDaoTaoID;
		this.monHoc = monHoc;
		this.chuongTrinhDaoTao = chuongTrinhDaoTao;
		this.loaiChuongTrinh = loaiChuongTrinh;
	}

	public HocPhanThuocChuongTrinhDaoTaoID getHocPhanThuocChuongTrinhDaoTaoID() {
		return hocPhanThuocChuongTrinhDaoTaoID;
	}

	public void setHocPhanThuocChuongTrinhDaoTaoID(HocPhanThuocChuongTrinhDaoTaoID hocPhanThuocChuongTrinhDaoTaoID) {
		this.hocPhanThuocChuongTrinhDaoTaoID = hocPhanThuocChuongTrinhDaoTaoID;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public ChuongTrinhDaoTao getChuongTrinhDaoTao() {
		return chuongTrinhDaoTao;
	}

	public void setChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) {
		this.chuongTrinhDaoTao = chuongTrinhDaoTao;
	}

	public String getLoaiChuongTrinh() {
		return loaiChuongTrinh;
	}

	public void setLoaiChuongTrinh(String loaiChuongTrinh) {
		this.loaiChuongTrinh = loaiChuongTrinh;
	}
	
	
}
