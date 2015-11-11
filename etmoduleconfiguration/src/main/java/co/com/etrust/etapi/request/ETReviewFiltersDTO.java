package co.com.etrust.etapi.request;

public class ETReviewFiltersDTO {

	private int productId;
	private int saleId;
	private int customerId;
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getSaleId() {
		return saleId;
	}


	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public String toString() {
		return "ETReviewFiltersDTO [productId=" + productId + ", saleId=" + saleId + ", customerId=" + customerId + "]";
	}
	
		
	
}
