package tlu.payload;


public class BoMonRequest {
	private String maBoMon;
	
	private String tenBoMon;
	
	private String truongBoMon;

	public BoMonRequest() {
		super();
	}

	public BoMonRequest(String maBoMon, String tenBoMon, String truongBoMon) {
		super();
		this.maBoMon = maBoMon;
		this.tenBoMon = tenBoMon;
		this.truongBoMon = truongBoMon;
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

	public String getTruongBoMon() {
		return truongBoMon;
	}

	public void setTruongBoMon(String truongBoMon) {
		this.truongBoMon = truongBoMon;
	}
	
	
}
