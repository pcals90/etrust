package co.com.etrust.etapi.request;

public class ETReviewFiltersDTO {

	private Integer productId;
	private Integer saleId;
	private Integer customerId;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "ETReviewFiltersDTO [productId=" + productId + ", saleId=" + saleId + ", customerId=" + customerId + "]";
	}
	
		
	
}
