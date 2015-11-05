package co.com.etrust.etapi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.etrust.etapi.response.dto.ETApiResponseDTO;
import co.com.etrust.etapi.response.dto.ETApiResponseStatus;
import co.com.etrust.etapi.service.etpostsale.IPostsaleService;
import co.com.etrust.etapi.service.etpresale.IPresaleService;
import co.com.etrust.etmoduleadministration.service.IModuleService;
import co.com.etrust.etmoduleconfiguration.response.dto.ETConfigurationResponseDTO;
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
	
}
