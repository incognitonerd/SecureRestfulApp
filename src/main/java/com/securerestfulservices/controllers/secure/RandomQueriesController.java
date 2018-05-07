package com.securerestfulservices.controllers.secure;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.securerestfulservices.dto.entities.randomqueries.AvgPhotosPerUserDTO;
import com.securerestfulservices.dto.entities.randomqueries.FiveMostPopHashtagsDTO;
import com.securerestfulservices.dto.entities.randomqueries.InactiveUsersDTO;
import com.securerestfulservices.dto.entities.randomqueries.MostPopPhotoDTO;
import com.securerestfulservices.dto.entities.randomqueries.TwoMostPopRegDatesDTO;
import com.securerestfulservices.dto.entities.randomqueries.UsersWhoMayBeBotsDTO;
import com.securerestfulservices.dto.responses.AbstractResponseDto;
import com.securerestfulservices.repositories.RandomQueriesRepository;
import com.securerestfulservices.utils.ResponseUtil;

@RestController
@RequestMapping(value = "/secure/randomqueries")
public class RandomQueriesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomQueriesController.class);
	@Autowired
	private RandomQueriesRepository dataSet;
	
	// http://localhost:8080/SecureRestfulApp/secure/randomqueries/getTwoMostPopRegDates
	@RequestMapping(value = "/getTwoMostPopRegDates", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getTwoMostPopRegDates(){
		List<TwoMostPopRegDatesDTO> results = dataSet.getTwoMostPopRegDates();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getTwoMostPopRegDates", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllComments() throws Exception{ List<TwoMostPopRegDatesDTO> results = dataSet.getTwoMostPopRegDates();
	 * if(results != null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/secure/randomqueries/getInactiveUsers
	@RequestMapping(value = "/getInactiveUsers", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getInactiveUsers(){
		List<InactiveUsersDTO> results = dataSet.getInactiveUsers();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getInactiveUsers", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getInactiveUsers() throws Exception{ List<InactiveUsersDTO> results = dataSet.getInactiveUsers(); if(results
	 * != null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/secure/randomqueries/getMostPopPhoto
	@RequestMapping(value = "/getMostPopPhoto", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getMostPopPhoto(){
		List<MostPopPhotoDTO> results = dataSet.getMostPopPhoto();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getMostPopPhoto", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getMostPopPhoto() throws Exception{ List<MostPopPhotoDTO> results = dataSet.getMostPopPhoto(); if(results !=
	 * null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/secure/randomqueries/getAvgPhotosPerUser
	@RequestMapping(value = "/getAvgPhotosPerUser", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAvgPhotosPerUser(){
		List<AvgPhotosPerUserDTO> results = dataSet.getAvgPhotosPerUser();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAvgPhotosPerUser", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAvgPhotosPerUser() throws Exception{ List<AvgPhotosPerUserDTO> results = dataSet.getAvgPhotosPerUser();
	 * if(results != null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/secure/randomqueries/getFiveMostPopHashtags
	@RequestMapping(value = "/getFiveMostPopHashtags", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getFiveMostPopHashtags(){
		List<FiveMostPopHashtagsDTO> results = dataSet.getFiveMostPopHashtags();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getFiveMostPopHashtags", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getFiveMostPopHashtags() throws Exception{ List<FiveMostPopHashtagsDTO> results =
	 * dataSet.getFiveMostPopHashtags(); if(results != null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/secure/randomqueries/getUsersWhoMayBeBots
	@RequestMapping(value = "/getUsersWhoMayBeBots", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getUsersWhoMayBeBots(){
		List<UsersWhoMayBeBotsDTO> results = dataSet.getUsersWhoMayBeBots();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getUsersWhoMayBeBots", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getUsersWhoMayBeBots() throws Exception{ List<UsersWhoMayBeBotsDTO> results =
	 * dataSet.getUsersWhoMayBeBots(); if(results != null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
}