package co.com.etrust.etapi.dao.presale;

import java.util.List;

import co.com.etrust.etapi.request.ETReviewDTO;
import co.com.etrust.etapi.request.ETReviewFiltersDTO;
import co.com.etrust.etapi.request.ETReviewRateDTO;

public interface IPresaleDAO {

	public boolean addProductReview(ETReviewDTO review);

	public List<ETReviewDTO> getProductReview(ETReviewFiltersDTO filters);

	public Boolean getProductReview(ETReviewRateDTO rate);

}
