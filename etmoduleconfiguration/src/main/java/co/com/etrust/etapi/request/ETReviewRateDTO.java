package co.com.etrust.etapi.request;

public class ETReviewRateDTO {

	private int reviewId;
	private int rate;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "ETReviewRateDTO [reviewId=" + reviewId + ", rate=" + rate + "]";
	}
	
	
	
}
