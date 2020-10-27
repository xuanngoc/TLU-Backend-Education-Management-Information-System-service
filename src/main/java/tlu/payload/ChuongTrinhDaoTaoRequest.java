package tlu.payload;

public class ChuongTrinhDaoTaoRequest {

	private String maNamHoc;
	private String maNganhHoc;
	
	
	public ChuongTrinhDaoTaoRequest() {
		super();
	}

	public ChuongTrinhDaoTaoRequest(String maNamHoc, String maNganhHoc) {
		super();
		this.maNamHoc = maNamHoc;
		this.maNganhHoc = maNganhHoc;
	}

	public String getMaNamHoc() {
		return maNamHoc;
	}
	
	public void setMaNamHoc(String maNamHoc) {
		this.maNamHoc = maNamHoc;
	}
	
	public String getMaNganhHoc() {
		return maNganhHoc;
	}
	
	public void setMaNganhHoc(String maNganhHoc) {
		this.maNganhHoc = maNganhHoc;
	}
	
	
}
