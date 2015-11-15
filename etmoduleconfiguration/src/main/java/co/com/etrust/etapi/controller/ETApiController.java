package co.com.etrust.etapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.etrust.etapi.request.ETReviewDTO;
import co.com.etrust.etapi.request.ETReviewFiltersDTO;
import co.com.etrust.etapi.response.dto.ETApiResponseDTO;
import co.com.etrust.etapi.response.dto.ETApiResponseStatus;
import co.com.etrust.etapi.service.postsale.IPostsaleService;
import co.com.etrust.etapi.service.presale.IPresaleService;
import co.com.etrust.etapi.service.report.IReportService;

@Controller
public class ETApiController {

	@Autowired
	private IPostsaleService postSaleService;
	
	@Autowired
	private IPresaleService presaleService;
	
	@Autowired
	private IReportService reportService;

	
	@RequestMapping(value = "/etapi/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object test() {

		return "Hola";

	}

	@RequestMapping(value = "/etapi/presale/getFunctionalities", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getPresaleFunctionalities(@RequestParam (value="serviceName",required=false)final String serviceName) {

		try{
		return new ETApiResponseDTO(presaleService.getFunctionalities(serviceName), "Ok",
				ETApiResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
	
	@RequestMapping(value = "/etapi/presale/productreview/add", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
	public @ResponseBody Object addProductReview(@RequestBody final ETReviewDTO review) {

		try{
		return new ETApiResponseDTO(presaleService.addProductReview(review), "Ok",
				ETApiResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/etapi/presale/productreview/getReview", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getProductReview(@RequestParam final Integer productId) {

		ETReviewFiltersDTO filters = new ETReviewFiltersDTO();
		filters.setProductId(productId);
		
		try{
		return new ETApiResponseDTO(presaleService.getProductReview(filters), "Ok",
				ETApiResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
	
	@RequestMapping(value = "/etapi/reports/getReportByModuleId", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getReportByModuleId(@RequestParam final Integer moduleId) {

		try{
			return new ETApiResponseDTO(reportService.getReportByModuleId(moduleId), "Ok",
					ETApiResponseStatus.SUCCESS);
			}catch(Exception e){
			e.printStackTrace();
			return new ETApiResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETApiResponseStatus.ERROR);
		}
	}
	
}
