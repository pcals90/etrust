package co.com.etrust.etmoduleconfiguration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ETModuleConfigurationController {


@RequestMapping(value = "/moduleconf/test", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody
Object test(){
	
	return "Hola";
	
}

	
}
