package com.tf.usermanagement.dao;

import java.util.List;

import com.tf.usermanagement.dto.CustomerCatalogCountDto;
import com.tf.usermanagement.dto.DivisionAssignmentDto;
import com.tf.usermanagement.dto.GroupCatalogCountDto;
import com.tf.usermanagement.dto.GroupCustomerCountDto;
import com.tf.usermanagement.dto.UsersDto;

public interface DivisionMgmtDao {

	public List<UsersDto> checkFlow();

	public List<GroupCustomerCountDto> getCustomerCountForGroupsByOrganization(long userId);
	public List<GroupCatalogCountDto> getCatalogCountForGroupsByOrganization(long userId);
	public List<CustomerCatalogCountDto> getCustomerAndCatalogCount(long userId);
	
	
	/*public List<DivisionAssignmentDto> getCustomerCountForGroupsByOrganization(long userId);
	public List<DivisionAssignmentDto> getCatalogCountForGroupsByOrganization(long userId);
	public List<DivisionAssignmentDto> getCustomerAndCatalogCount(long userId);*/
}
