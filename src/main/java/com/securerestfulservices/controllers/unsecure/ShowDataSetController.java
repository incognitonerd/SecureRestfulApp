package com.securerestfulservices.controllers.unsecure;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.securerestfulservices.dto.entities.tables.AvailableEndpoint;
import com.securerestfulservices.dto.entities.tables.Comment;
import com.securerestfulservices.dto.entities.tables.Follow;
import com.securerestfulservices.dto.entities.tables.Like;
import com.securerestfulservices.dto.entities.tables.Photo;
import com.securerestfulservices.dto.entities.tables.PhotoTag;
import com.securerestfulservices.dto.entities.tables.Project;
import com.securerestfulservices.dto.entities.tables.Table;
import com.securerestfulservices.dto.entities.tables.TableStat;
import com.securerestfulservices.dto.entities.tables.Tag;
import com.securerestfulservices.dto.entities.tables.User;
import com.securerestfulservices.dto.responses.AbstractResponseDto;
import com.securerestfulservices.repositories.ShowDataSetRepository;
import com.securerestfulservices.utils.ResponseUtil;

@RestController
@RequestMapping(value = "/unsecure/showdataset")
public class ShowDataSetController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShowDataSetController.class);
	@Autowired
	private ShowDataSetRepository dataSet;
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAvailableEndpoints
	@RequestMapping(value = "/getAvailableEndpoints", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAvailableEndpoints(){
		List<AvailableEndpoint> results = dataSet.getAvailableEndpoints();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAvailableEndpoints", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAvailableEndpoints() throws Exception{ List<AvailableEndpoint> results =
	 * dataSet.getAvailableEndpoints(); if(results != null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllComments
	@RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllComments(){
		List<Comment> results = dataSet.getAllComments();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllComments", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllComments() throws Exception{ List<Comment> results = dataSet.getAllComments(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllFollows
	@RequestMapping(value = "/getAllFollows", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllFollows(){
		List<Follow> results = dataSet.getAllFollows();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllFollows", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllFollows() throws Exception{ List<Follow> follows = dataSet.getAllFollows(); if(follows != null){
	 * LOGGER.info("follows size - " + follows.size()); return follows; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllLikes
	@RequestMapping(value = "/getAllLikes", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllLikes(){
		List<Like> results = dataSet.getAllLikes();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllLikes", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllLikes() throws Exception{ List<Like> results = dataSet.getAllLikes(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllPhotos
	@RequestMapping(value = "/getAllPhotos", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllPhotos(){
		List<Photo> results = dataSet.getAllPhotos();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllPhotos", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllPhotos() throws Exception{ List<Photo> results = dataSet.getAllPhotos(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllPhotoTags
	@RequestMapping(value = "/getAllPhotoTags", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllPhotoTags(){
		List<PhotoTag> results = dataSet.getAllPhotoTags();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllPhotoTags", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllPhotoTags() throws Exception{ List<PhotoTag> results = dataSet.getAllPhotoTags(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllTables
	@RequestMapping(value = "/getAllTables", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllTables(){
		List<Table> results = dataSet.getAllTables();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllTables", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllTables() throws Exception{ List<Table> results = dataSet.getAllTables(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllTableStats
	@RequestMapping(value = "/getAllTableStats", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllTableStats(){
		List<TableStat> results = dataSet.getAllTableStats();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllTableStats", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllTableStats() throws Exception{ List<TableStat> results = dataSet.getAllTableStats(); if(results !=
	 * null){ LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllTags
	@RequestMapping(value = "/getAllTags", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllTags(){
		List<Tag> results = dataSet.getAllTags();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllTags", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllTags() throws Exception{ List<Tag> results = dataSet.getAllTags(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllUsers
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getAllUsers(){
		List<User> results = dataSet.getAllUsers();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getAllUsers() throws Exception{ List<User> results = dataSet.getAllUsers(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
	
	// http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getProjects
	@RequestMapping(value = "/getProjects", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> getProjects(){
		List<Project> results = dataSet.getAllProjects();
		return ResponseUtil.success().body(results).send(HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/getProjects", method = RequestMethod.GET, produces = "application/json; charset=UTF-8") public Object getProjects() throws Exception{ List<Project> results = dataSet.getAllProjects(); if(results != null){
	 * LOGGER.info("results size - " + results.size()); return results; } else{ return null; } }
	 */
}