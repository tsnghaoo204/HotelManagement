package model;

public class DanhGiaNV {
	private int maDG;
	private String danhGia;
	private String ghiChu;
	private String maNV;
	
	public DanhGiaNV(String maNV, int maDG, String danhGia, String ghiChu) {
		super();
		this.maDG = maDG;
		this.danhGia = danhGia;
		this.ghiChu = ghiChu;
		this.maNV = maNV;
	}

	public DanhGiaNV(String danhGia, String ghiChu, String maNV) {
		this.danhGia = danhGia;
		this.ghiChu = ghiChu;
		this.maNV = maNV;
	}
	
	public DanhGiaNV(String maNV) {
		this.danhGia = "Trống";
		this.ghiChu = "Trống";
		this.maNV = maNV;
	}
	
	public int getMaDG() {
		return maDG;
	}

	public void setMaDG(int maDG) {
		this.maDG = maDG;
	}

	public String getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	@Override
	public String toString() {
		return "DanhGiaNV [maDG=" + maDG + ", danhGia=" + danhGia + ", ghiChu=" + ghiChu + ", maNV=" + maNV + "]";
	}
	
}
