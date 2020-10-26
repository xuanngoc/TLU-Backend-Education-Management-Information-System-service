package tlu.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HocPhanThuocChuongTrinhDaoTaoID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8165221362762243236L;

	private long chuongTrinhDaoTaoID;
	private String monHocID;
	
	public HocPhanThuocChuongTrinhDaoTaoID() {
		super();
	}

	public HocPhanThuocChuongTrinhDaoTaoID(long chuongTrinhDaoTaoID, String monHocID) {
		super();
		this.chuongTrinhDaoTaoID = chuongTrinhDaoTaoID;
		this.monHocID = monHocID;
	}

	public long getChuongTrinhDaoTaoID() {
		return chuongTrinhDaoTaoID;
	}

	public void setChuongTrinhDaoTaoID(long chuongTrinhDaoTaoID) {
		this.chuongTrinhDaoTaoID = chuongTrinhDaoTaoID;
	}

	public String getMonHocID() {
		return monHocID;
	}

	public void setMonHocID(String monHocID) {
		this.monHocID = monHocID;
	}
	
}
