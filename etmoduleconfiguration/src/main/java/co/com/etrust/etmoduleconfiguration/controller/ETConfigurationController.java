package co.com.etrust.etmoduleconfiguration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.etrust.etmoduleconfiguration.response.dto.ETConfigurationResponseDTO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETResponseStatus;
import co.com.etrust.etmoduleconfiguration.service.ETInitialConfigurationService;

@Controller
public class ETConfigurationController {

	@Autowired
	private ETInitialConfigurationService initialConfService;

	@RequestMapping(value = "/initialconf/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object test() {

		return "Hola";

	}

	@RequestMapping(value = "/initialconf/testConnection", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object testConnection(@RequestParam final String host, @RequestParam final String port,@RequestParam final String dbName,
			@RequestParam final String user, @RequestParam final String password,
			@RequestParam final String dbProvider) {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.testConnection(host, port, dbName,user, password, dbProvider), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	
	@RequestMapping(value = "/initialconf/getExistingConfiguration", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getExistingConfiguration() {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.getExistingConfiguration(), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/initialconf/saveNewInitialConfiguration", headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.POST,consumes="application/json", produces = "application/json")
	public @ResponseBody Object saveNewInitialConfiguration(@RequestBody final ETExistingInitialConfDTO conf) {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.saveNewInitialConfiguration(conf), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}

}
