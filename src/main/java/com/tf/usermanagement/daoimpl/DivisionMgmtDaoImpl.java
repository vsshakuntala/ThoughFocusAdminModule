package com.tf.usermanagement.daoimpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tf.usermanagement.dao.DivisionMgmtDao;
import com.tf.usermanagement.dto.CustomerCatalogCountDto;
import com.tf.usermanagement.dto.DivisionAssignmentDto;
import com.tf.usermanagement.dto.GroupCatalogCountDto;
import com.tf.usermanagement.dto.GroupCustomerCountDto;
import com.tf.usermanagement.dto.UsersDto;

@Repository
public class DivisionMgmtDaoImpl implements DivisionMgmtDao{
	
	private static final Logger LOGGER = Logger.getLogger(DivisionMgmtDaoImpl.class);
	
	private List<DivisionAssignmentDto> divisionAssignmentDtoList=new ArrayList<>();
	private DivisionAssignmentDto divisionDto=new DivisionAssignmentDto();
	
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * this is a temporary method
	 */
	@Override
		public List<UsersDto> checkFlow() {
			System.out.println("control came to DAO");
			Session session=null;
			List<UsersDto> usersDto=null;
			
			try{
					session=sessionFactory.openSession();
					System.out.println("after session creation");
					SQLQuery query = session.createSQLQuery("select USER_NAME from USERS").addScalar("USER_NAME", StandardBasicTypes.STRING);
					@SuppressWarnings("unchecked")
					List<String> objects = query.list();
					System.out.println("Check in dao"+objects.size());
				 
				 
				 if (!objects.isEmpty()) {
						usersDto = new ArrayList<>();
						for (String row : objects) {
							UsersDto user = new UsersDto();
							
							user.setUserName(row);
							
							usersDto.add(user);
						}
			}
			
			}catch(HibernateException exception){
				LOGGER.error("Exception in checkFlow " + exception.getMessage());
			}catch (Exception e) {
				LOGGER.error("Exception in checkFlow " + e.getMessage());
			}finally{
				
			}
			return usersDto;
			
			}



	/**
	 * this method is used to get the organization that
	 * user belongs to the user and also the group count and customer count
	 * belongs to each group
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GroupCustomerCountDto> getCustomerCountForGroupsByOrganization(long userId) {
		LOGGER.info("User id " + userId);
		Session session = null;
		SQLQuery query = null;
		List<GroupCustomerCountDto> groupCustomerCountList=new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			query=session.createSQLQuery("SELECT Org.ORGANIZATION_ID organizationId,Org.ORGANIZATION_NAME organizationName,Count(DISTINCT UsrGrp.GROUP_ID) groupCount,Count(DISTINCT GrpCust.CUSTOMER_ID) groupCustomerCount"
					+" FROM	USERS Usr"
					+" LEFT JOIN USER_ORG_MAP UsrOrgMap ON Usr.USER_ID = UsrOrgMap.USER_ID AND UsrOrgMap.ACTIVE = 1"
					+" INNER JOIN ORGANIZATION Org ON Org.ORGANIZATION_ID = UsrOrgMap.ORGANIZATION_ID"
					+" LEFT JOIN GROUPS Grp ON	Org.ORGANIZATION_ID = Grp.ORGANIZATION_ID AND Grp.ACTIVE = 1"
					+" LEFT JOIN USER_GROUP UsrGrp ON	Usr.USER_ID = UsrGrp.USER_ID AND Grp.GROUP_ID = UsrGrp.GROUP_ID AND	UsrGrp.ACTIVE = 1"
					+" LEFT  JOIN GROUP_CUSTOMER GrpCust ON UsrGrp.GROUP_ID = GrpCust.GROUP_ID AND GrpCust.ACTIVE = 1"
					+" WHERE Usr.USER_ID = :userId"
					+" Group By Usr.USER_ID, Usr.USER_NAME, Org.ORGANIZATION_ID,Org.ORGANIZATION_NAME"
					+" ORDER BY Usr.USER_ID, Org.ORGANIZATION_ID")
					.addScalar("organizationId", StandardBasicTypes.BIG_INTEGER)
					.addScalar("organizationName",StandardBasicTypes.STRING)
					.addScalar("groupCount", StandardBasicTypes.BIG_INTEGER)
					.addScalar("groupCustomerCount",StandardBasicTypes.BIG_INTEGER);
			
			query.setLong("userId", userId);
			
			List<Object[]> groupCustomerArray  = query.list();
			for (Object[] groupCustomer : groupCustomerArray) {
				
				
				/*divisionDto.setOrganizationId(((BigInteger)groupCustomer[0]).longValue());
				divisionDto.setOrganizationName((String)groupCustomer[1]);
				divisionDto.setGroupsCount(((BigInteger)groupCustomer[2]).longValue());
				divisionDto.setCustomerGroupCount(((BigInteger)groupCustomer[3]).longValue());
				divisionAssignmentDtoList.add(divisionDto);*/
				
				GroupCustomerCountDto groupCustomerDto=new GroupCustomerCountDto();
				groupCustomerDto.setOrganizationId(((BigInteger)groupCustomer[0]).longValue());
				groupCustomerDto.setOrganizationName((String)groupCustomer[1]);
				groupCustomerDto.setGroupCount(((BigInteger)groupCustomer[2]).longValue());
				groupCustomerDto.setGroupCustomerCount(((BigInteger)groupCustomer[3]).longValue());
				groupCustomerCountList.add(groupCustomerDto);						
			}
		}catch(HibernateException e){
			LOGGER.error("Exception in getCustomerCountByOrganization " + e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			LOGGER.error("Exception in getCustomerCountByOrganization " + e.getMessage());
			e.printStackTrace();
		}
		return groupCustomerCountList;
	}

	
	/**
	 * this method is used to get the catalog count based on the groups for 
	 * the selected user for respective organizations he belongs to
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupCatalogCountDto> getCatalogCountForGroupsByOrganization(long userId) {
		LOGGER.info("User id " + userId);
		Session session = null;
		SQLQuery query = null;
		List<GroupCatalogCountDto> groupCatalogCountList=new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			query=session.createSQLQuery("SELECT Org.ORGANIZATION_ID organizationId,Count(DISTINCT GrpCat.CATALOG_ID) groupCatalogCount"
					+" FROM	USERS Usr"
					+" LEFT JOIN USER_ORG_MAP UsrOrgMap ON	Usr.USER_ID = UsrOrgMap.USER_ID AND	UsrOrgMap.ACTIVE = 1"
					+" INNER JOIN ORGANIZATION Org ON	Org.ORGANIZATION_ID = UsrOrgMap.ORGANIZATION_ID"
					+" LEFT JOIN GROUPS Grp ON	Org.ORGANIZATION_ID = Grp.ORGANIZATION_ID AND	Grp.ACTIVE = 1"
					+" LEFT JOIN USER_GROUP UsrGrp ON Usr.USER_ID = UsrGrp.USER_ID AND Grp.GROUP_ID = UsrGrp.GROUP_ID AND UsrGrp.ACTIVE = 1"
					+" LEFT JOIN GROUP_CATALOG GrpCat ON	UsrGrp.GROUP_ID = GrpCat.GROUP_ID AND	GrpCat.ACTIVE = 1"
					+" WHERE Usr.USER_ID = :userId"
					+" Group By Usr.USER_ID, Usr.USER_NAME, Org.ORGANIZATION_ID,Org.ORGANIZATION_NAME"
					+" ORDER BY Usr.USER_ID, Org.ORGANIZATION_ID")
					.addScalar("organizationId",StandardBasicTypes.BIG_INTEGER)
					.addScalar("groupCatalogCount",StandardBasicTypes.BIG_INTEGER);
			
			query.setLong("userId", userId);
			
			List<Object[]> groupCatalogArray  = query.list();
			for (Object[] groupCatalog : groupCatalogArray) {
				
				/*divisionDto.setCatalogGroupCount(((BigInteger)groupCatalog[1]).longValue());
				divisionAssignmentDtoList.add(divisionDto);*/
				
				GroupCatalogCountDto groupCatalogDto=new GroupCatalogCountDto();
				groupCatalogDto.setOrganizationId(((BigInteger)groupCatalog[0]).longValue());
				groupCatalogDto.setGroupCatalogCount(((BigInteger)groupCatalog[1]).longValue());	
				groupCatalogCountList.add(groupCatalogDto);
			}
			
			
			System.out.println("getCatalogCountList "+groupCatalogCountList.size());
			System.out.println("Data "+groupCatalogCountList.toString());
		}catch(HibernateException e){
			LOGGER.error("Exception in getCustomerCountByOrganization " + e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			LOGGER.error("Exception in getCustomerCountByOrganization " + e.getMessage());
			e.printStackTrace();
		}
		return groupCatalogCountList;
	}



	@Override
	public List<CustomerCatalogCountDto> getCustomerAndCatalogCount(long userId) {
		LOGGER.info("User id " + userId);
		Session session = null;
		SQLQuery query = null;
		List<CustomerCatalogCountDto> customerCatalogCountList=new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			query=session.createSQLQuery("select userOrgMap.ORGANIZATION_ID organizationId ,userOrgMap.APPROVAL_STATUS as status,count(DISTINCT userCust.CUSTOMER_ID) as customersCount,count(DISTINCT cat.CATALOG_ID) as catalogsCount"
					+" From USERS users"
					+" LEFT JOIN USER_ORG_MAP userOrgMap on  users.USER_ID = userOrgMap.USER_ID AND	userOrgMap.ACTIVE = 1"
					+" INNER JOIN ORGANIZATION org on org.ORGANIZATION_ID=userOrgMap.ORGANIZATION_ID"
					+" INNER JOIN CUSTOMER_ORGANIZATION_MAP custOrgMap on custOrgMap.ORGANIZATION_ID=org.ORGANIZATION_ID and custOrgMap.ACTIVE=1"
					+" LEFT JOIN USER_CUSTOMER userCust on  custOrgMap.CUSTOMER_ID=userCust.CUSTOMER_ID and userCust.ACTIVE=1 and userCust.USER_ID=users.USER_ID"
					+" LEFT JOIN CATALOG cat on cat.CUSTOMER_ID=userCust.CUSTOMER_ID"
					+" LEFT JOIN USER_CATALOG userCat on cat.CATALOG_ID=userCat.CATALOG_ID and userCat.ACTIVE=1 and UserCat.USER_ID=users.USER_ID"
					+" WHERE users.USER_ID = :userId"
					+" Group By users.USER_ID,org.ORGANIZATION_NAME,userOrgMap.ORGANIZATION_ID,userOrgMap.APPROVAL_STATUS"
					+" Order By users.USER_ID,org.ORGANIZATION_NAME")
					.addScalar("organizationId",StandardBasicTypes.BIG_INTEGER)
					.addScalar("organizationId",StandardBasicTypes.BIG_INTEGER)
					.addScalar("customersCount",StandardBasicTypes.BIG_INTEGER)
					.addScalar("catalogsCount",StandardBasicTypes.BIG_INTEGER);
			
			query.setLong("userId", userId);
			
			
			
			@SuppressWarnings("unchecked")
			List<Object[]> customerCatalogArray  = query.list();
			for (Object[] customerCatalog : customerCatalogArray) {
				
				/*divisionDto.setCustomerCount(((BigInteger)customerCatalog[1]).longValue());
				divisionDto.setCatalogCount(((BigInteger)customerCatalog[2]).longValue());
				divisionAssignmentDtoList.add(divisionDto);*/
				
				
				CustomerCatalogCountDto customerCatalogDto=new CustomerCatalogCountDto();
				customerCatalogDto.setOrganizationId(((BigInteger)customerCatalog[0]).longValue());
				customerCatalogDto.setStatus(((BigInteger)customerCatalog[1]).longValue());
				customerCatalogDto.setCustomersCount(((BigInteger)customerCatalog[2]).longValue());
				customerCatalogDto.setCatalogsCount(((BigInteger)customerCatalog[3]).longValue());
				
				customerCatalogCountList.add(customerCatalogDto);
			}
			
			System.out.println("getCustomerAndCatalogCount "+customerCatalogCountList.size());
			System.out.println("Data "+customerCatalogCountList.toString());
		}catch(HibernateException e){
			LOGGER.error("Exception in getCustomerAndCatalogCount " + e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			LOGGER.error("Exception in getCustomerAndCatalogCount " + e.getMessage());
			e.printStackTrace();
		}
		return customerCatalogCountList;
	}
}
