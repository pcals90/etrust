package co.com.etrust.etmoduleconfiguration.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.etrust.etmoduleconfiguration.response.dto.ETConfigurationResponseDTO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETRelationMetaData;
import co.com.etrust.etmoduleconfiguration.response.dto.ETResponseStatus;
import co.com.etrust.etmoduleconfiguration.service.ETInitialConfigurationService;
import javassist.bytecode.stackmap.TypeData.ClassName;

@Controller
public class ETConfigurationController {

	@Autowired
	private ETInitialConfigurationService initialConfService;

	private static final Logger log = Logger.getLogger( ClassName.class.getName() );
	
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	
	@RequestMapping(value = "/initialconf/getCurrentModules", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getCurrentModules() {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.getCurrentModules(), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/initialconf/activateModule", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object activateModule(@RequestParam final Integer moduleId) {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.activateModule(moduleId), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/initialconf/deactivateModule", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object deactivateModule(@RequestParam final Integer moduleId) {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.deactivateModule(moduleId), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/initialconf/getActiveModules", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getActiveModules() {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.getActiveModules(), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/initialconf/getAllTables", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getAllTables() {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.getAllTables(), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	
	@RequestMapping(value = "/initialconf/getColumnInformationByTableName", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getColumnInformationByTableName(@RequestParam final String tableName) {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.getColumnInformationByTableName(tableName), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/initialconf/getFunctionalitiesByModuleId", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getFunctionalitiesByModuleId(@RequestParam final Integer moduleId) {

		
		try{
		return new ETConfigurationResponseDTO(initialConfService.getFunctionalitiesByModuleId(moduleId), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}
	
	@RequestMapping(value = "/initialconf/saveConfiguration", headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.POST,consumes="application/json", produces = "application/json")
	public @ResponseBody Object saveConfiguration(@RequestBody final ETRelationMetaData metadata) {

		try{
		return new ETConfigurationResponseDTO(initialConfService.saveConfiguration(metadata), "Ok",
				ETResponseStatus.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return new ETConfigurationResponseDTO(null, "FAIL :: "+e.getMessage(),
					ETResponseStatus.ERROR);
		}
	}

}
