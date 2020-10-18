package tlu.model;

public class NamHoc {
	private long maNamHoc;
	private String tenNamHoc;
	
		
	public NamHoc() {
		super();
	}
	
	public NamHoc(long maNamHoc, String tenNamHoc) {
		super();
		this.maNamHoc = maNamHoc;
		this.tenNamHoc = tenNamHoc;
	}

	public long getMaNamHoc() {
		return maNamHoc;
	}
	
	public void setMaNamHoc(long maNamHoc) {
		this.maNamHoc = maNamHoc;
	}
	
	public String getTenNamHoc() {
		return tenNamHoc;
	}
	
	public void setTenNamHoc(String tenNamHoc) {
		this.tenNamHoc = tenNamHoc;
	}
	
	
	
	
}
