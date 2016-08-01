package com.tf.usermanagement.service;

import java.util.List;

import com.tf.usermanagement.dto.CustomerCatalogCountDto;
import com.tf.usermanagement.dto.DivisionAssignmentDto;
import com.tf.usermanagement.dto.GroupCatalogCountDto;
import com.tf.usermanagement.dto.GroupCustomerCountDto;
import com.tf.usermanagement.dto.UsersDto;

public interface DivisionMgmtService {
	public List<UsersDto> checkFlow();
	
	public List<GroupCustomerCountDto> getCustomerCountForGroupsByOrganization(long userId);
	public List<GroupCatalogCountDto> getCatalogCountForGroupsByOrganization(long userId);
	public List<CustomerCatalogCountDto> getCustomerAndCatalogCount(long userId);
	
	/*public List<DivisionAssignmentDto> getCustomerCountForGroupsByOrganization(long userId);
	public List<DivisionAssignmentDto> getCatalogCountForGroupsByOrganization(long userId);
	public List<DivisionAssignmentDto> getCustomerAndCatalogCount(long userId);*/
	
	
	
	public List<DivisionAssignmentDto> getAllDivisionAssignment(long userId);
}
