package com.tf.usermanagement.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tf.usermanagement.dao.DivisionMgmtDao;
import com.tf.usermanagement.dto.CustomerCatalogCountDto;
import com.tf.usermanagement.dto.DivisionAssignmentDto;
import com.tf.usermanagement.dto.GroupCatalogCountDto;
import com.tf.usermanagement.dto.GroupCustomerCountDto;
import com.tf.usermanagement.dto.UsersDto;
import com.tf.usermanagement.service.DivisionMgmtService;

@Service
public class DivisionMgmtServiceImpl implements DivisionMgmtService {

	@Autowired
	private DivisionMgmtDao divisionMgmtDao;

	/**
	 * this is a temporary method
	 */
	@Override
	public List<UsersDto> checkFlow() {
		System.out.println("control came to service");
		return divisionMgmtDao.checkFlow();

	}
	
	@Override
	public List<GroupCustomerCountDto> getCustomerCountForGroupsByOrganization(long userId) {
		return divisionMgmtDao.getCustomerCountForGroupsByOrganization(userId);
	}

	@Override
	public List<GroupCatalogCountDto> getCatalogCountForGroupsByOrganization(long userId) {
		return divisionMgmtDao.getCatalogCountForGroupsByOrganization(userId);
	}

	@Override
	public List<CustomerCatalogCountDto> getCustomerAndCatalogCount(long userId) {
		return divisionMgmtDao.getCustomerAndCatalogCount(userId);
	}
	
	@Override
	public List<DivisionAssignmentDto> getAllDivisionAssignment(long userId) {
		
	//get the customer count based on groups	
	List<GroupCustomerCountDto> groupCustomerCountList=getCustomerCountForGroupsByOrganization(userId);
	//get the catalog count based on groups
	List<GroupCatalogCountDto> groupCatalogCountList=getCatalogCountForGroupsByOrganization(userId);
	//get the customer and catalog count based on individual assignments
	List<CustomerCatalogCountDto> customerCatalogCountList=getCustomerAndCatalogCount(userId);
	
	
		List<DivisionAssignmentDto> divisionAssignmentList=new ArrayList<>();
		
		/*//get the customer count based on groups	
		divisionAssignmentList=getCustomerCountForGroupsByOrganization(userId);
		//get the catalog count based on groups
		divisionAssignmentList=getCatalogCountForGroupsByOrganization(userId);
		//get the customer and catalog count based on individual assignments
		divisionAssignmentList=getCustomerAndCatalogCount(userId);*/
	
		
		
		
		
	
	System.out.println("sizes:"+groupCustomerCountList.size()+" "+groupCatalogCountList.size()+" "+customerCatalogCountList.size());
	
	if( (groupCustomerCountList.size()==groupCatalogCountList.size())&&
		(groupCatalogCountList.size()==customerCatalogCountList.size()) ){
		
		
		
		
		
		
		
		
		for(int i=0;i<groupCustomerCountList.size();i++){
			//Name, group count and group-customer count
			DivisionAssignmentDto assignmentDto=new DivisionAssignmentDto();
			assignmentDto.setOrganizationId(groupCustomerCountList.get(i).getOrganizationId());
			assignmentDto.setOrganizationName(groupCustomerCountList.get(i).getOrganizationName());
			assignmentDto.setGroupsCount(groupCustomerCountList.get(i).getGroupCount());
			assignmentDto.setCustomerGroupCount(groupCustomerCountList.get(i).getGroupCustomerCount());
			
			assignmentDto.setCatalogGroupCount(groupCatalogCountList.get(i).getGroupCatalogCount());
			
			if(customerCatalogCountList.get(i).getStatus()==1){
				assignmentDto.setStatus("Approved");	
			}else{
				assignmentDto.setStatus("Pending");
			}
			
			assignmentDto.setCustomerCount(customerCatalogCountList.get(i).getCustomersCount());
			assignmentDto.setCatalogCount(customerCatalogCountList.get(i).getCatalogsCount());
			
			divisionAssignmentList.add(assignmentDto);
		}
		
		/*for(int j=0;j<groupCatalogCountList.size();j++){
			//group-catalog count
			
			assignmentDto.setCatalogGroupCount(groupCatalogCountList.get(j).getGroupCatalogCount());
			divisionAssignmentList.add(j,assignmentDto);
		}
		
		for(int k=0;k<customerCatalogCountList.size();k++){
			//customer and catalog count
			
			assignmentDto.setCustomerCount(customerCatalogCountList.get(k).getCustomersCount());
			assignmentDto.setCatalogCount(customerCatalogCountList.get(k).getCatalogsCount());
			divisionAssignmentList.add(k,assignmentDto);
		}*/

		}
	
	
	return divisionAssignmentList;
	
}
	
}
