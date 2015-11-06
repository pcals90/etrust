package co.com.etrust.etapi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.etrust.etapi.request.ETReviewDTO;
import co.com.etrust.etapi.request.ETReviewFiltersDTO;
import co.com.etrust.etapi.request.ETReviewRateDTO;
import co.com.etrust.etapi.response.dto.ETApiResponseDTO;
import co.com.etrust.etapi.response.dto.ETApiResponseStatus;
import co.com.etrust.etapi.service.postsale.IPostsaleService;
import co.com.etrust.etapi.service.presale.IPresaleService;
import javassist.bytecode.stackmap.TypeData.ClassName;

@Controller
public class ETApiController {

	@Autowired
	private IPostsaleService postSaleService;
	
	@Autowired
	private IPresaleService presaleService;

	
private static final Logger log = Logger.getLogger( ClassName.class.getName() );
	
	@RequestMapping(value = "/etapi/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object test() {

		return "Hola";

	}

	@RequestMapping(value = "/etapi/presale/getFunctionalities", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getPresaleFunctionalities(@RequestParam final String serviceName) {

		try{
		return new ETApiResponseDTO(presaleService.getFunctionalities(serviceName), "Ok",
				ETApiResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
	
	@RequestMapping(value = "/etapi/presale/productreview/add", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object addProductReview(@RequestParam final ETReviewDTO review) {

		try{
		return new ETApiResponseDTO(presaleService.addProductReview(review), "Ok",
				ETApiResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/etapi/presale/productreview/get", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getProductReview(@RequestParam final ETReviewFiltersDTO filters) {

		try{
		return new ETApiResponseDTO(presaleService.getProductReview(filters), "Ok",
				ETApiResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
	
	@RequestMapping(value = "/etapi/presale/productreview/rate", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getProductReview(@RequestParam final ETReviewRateDTO rate) {

		try{
		return new ETApiResponseDTO(presaleService.rateReview(rate), "Ok",
				ETApiResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
}
