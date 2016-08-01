package com.tf.usermanagement.dto;

public class DivisionAssignmentDto {

	private String status;
	private String OrganizationName;
	private long organizationId;
	private long roleCount;
	private long customerCount;
	private long customerGroupCount;
	private long defaultAddressCount;
	private long catalogCount;
	private long catalogGroupCount;
	private long groupsCount;
	
	
	
	//setters and getters
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrganizationName() {
		return OrganizationName;
	}
	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}
	public long getRoleCount() {
		return roleCount;
	}
	public void setRoleCount(long roleCount) {
		this.roleCount = roleCount;
	}
	public long getCustomerCount() {
		return customerCount;
	}
	public void setCustomerCount(long customerCount) {
		this.customerCount = customerCount;
	}
	public long getCustomerGroupCount() {
		return customerGroupCount;
	}
	public void setCustomerGroupCount(long customerGroupCount) {
		this.customerGroupCount = customerGroupCount;
	}
	public long getDefaultAddressCount() {
		return defaultAddressCount;
	}
	public void setDefaultAddressCount(long defaultAddressCount) {
		this.defaultAddressCount = defaultAddressCount;
	}
	public long getCatalogCount() {
		return catalogCount;
	}
	public void setCatalogCount(long catalogCount) {
		this.catalogCount = catalogCount;
	}
	public long getCatalogGroupCount() {
		return catalogGroupCount;
	}
	public void setCatalogGroupCount(long catalogGroupCount) {
		this.catalogGroupCount = catalogGroupCount;
	}
	public long getGroupsCount() {
		return groupsCount;
	}
	public void setGroupsCount(long groupsCount) {
		this.groupsCount = groupsCount;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	
	
	
	
}
