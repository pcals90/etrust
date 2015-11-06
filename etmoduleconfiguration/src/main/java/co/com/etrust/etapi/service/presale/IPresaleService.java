package co.com.etrust.etapi.service.presale;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;

import co.com.etrust.etapi.request.ETReviewDTO;
import co.com.etrust.etapi.request.ETReviewFiltersDTO;
import co.com.etrust.etapi.request.ETReviewRateDTO;
import co.com.etrust.etapi.response.dto.ETApiModuleDTO;

public interface IPresaleService {
	
	public List<ETApiModuleDTO> getFunctionalities(String serviceName)throws ConfigurationException, IOException;

	public Boolean addProductReview(ETReviewDTO review)throws ConfigurationException, IOException;

	public List<ETReviewDTO> getProductReview(ETReviewFiltersDTO filters)throws ConfigurationException, IOException;

	public Boolean rateReview(ETReviewRateDTO rate)throws ConfigurationException, IOException;

}
