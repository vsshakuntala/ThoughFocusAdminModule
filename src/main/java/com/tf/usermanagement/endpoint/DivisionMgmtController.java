package com.tf.usermanagement.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tf.usermanagement.dto.DivisionAssignmentDto;
import com.tf.usermanagement.dto.UsersDto;
import com.tf.usermanagement.service.DivisionMgmtService;

/**
 * 
 * @author Manideep
 * 
 * This is a division assignment controller which contains the API's related
 * to division assignment of a selected user my admin,
 * 
 * In general user is assigned to multiple divisions and in each Divisions/Organizations he is 
 * assigned to multiple Customers,Machines,Roles,Groups
 */

@RestController
@RequestMapping("/divisionAssignment")
public class DivisionMgmtController {
	
	@Autowired
	private DivisionMgmtService divisionMgmtService;
	
	
	//getters and setters
	public DivisionMgmtService getDivisionMgmtService() {
		return divisionMgmtService;
	}

	public void setDivisionMgmtService(DivisionMgmtService divisionMgmtService) {
		this.divisionMgmtService = divisionMgmtService;
	}
	
	
	/*
	 * start of web service methods
	 */
	@RequestMapping(value={"/testDivision"})
	public List<UsersDto> testDivisionAssignmentController(){
		
	List<UsersDto> list= divisionMgmtService.checkFlow();	
	System.out.println("CHECKKKKKKK "+list.size());
	return list;
	
	}
	
	
	
	/**
	 * this is end point where we can get all the customer assigned group wise to an organization
	 * 
	 */
	@RequestMapping(value="/getDivisionAssignments/{userId}",method = RequestMethod.GET)
	private List<DivisionAssignmentDto> getCustomerCountBasedOnGroups(@PathVariable long userId){
		return divisionMgmtService.getAllDivisionAssignment(userId);
	}
	

}
