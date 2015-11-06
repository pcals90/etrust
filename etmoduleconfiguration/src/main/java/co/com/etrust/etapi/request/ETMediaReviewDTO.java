package co.com.etrust.etapi.request;

public class ETMediaReviewDTO {

	private String mediaType;
	private byte [] file;
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "ETMediaReviewDTO [mediaType=" + mediaType + "]";
	}
	
	
	
}
