package com.tf.usermanagement.report;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spaneos.dtssp.AbstractDataTableReport;
import com.spaneos.dtssp.QueryFilterAndParams;
import com.spaneos.dtssp.QueryFilterAndParamsImpl;
import com.spaneos.dtssp.QueryTemplate;
import com.spaneos.dtssp.QueryTemplateBuilder;
import com.spaneos.dtssp.input.DataTablesInput;

@Component
public class CustomerAssignmentReport extends AbstractDataTableReport{
    
    public static final String Name_FILTER = "nameFilter";

    @Override
    protected QueryTemplate attachQueryTemplate() {
	QueryTemplate queryTemplate = new QueryTemplateBuilder().fetchColumns("e.CUSTOMER_NAME as name")
		.from("customer e").addFilterExpressionWithKey(Name_FILTER, "e.CUSTOMER_NAME LIKE '%' :name '%'").build();
	return queryTemplate;
    }

    @Override
    protected Map<String, String> mapDataTableColNameToDBCol() {
	Map<String, String> map = new HashMap<>();
	map.put("name", "e.CUSTOMER_NAME");
	/*map.put("customerNumber", "e.ename");
	map.put("billToNumber", "e.job");
	map.put("addressOne", "e.sal");
	map.put("city", "e.sal");
	map.put("state", "e.sal");
	map.put("postal", "e.sal");*/
	return map;
    }
    
    public static class CustomerAssignputDtInput extends DataTablesInput{
	
	
	private String name;
	/*private String cNumber;
	private String cAddress;
	private String cCity;
	private String cState;
	private String cStatus;
	private String cPostal;
	private String cCountry;*/

	
	@Override
	public QueryFilterAndParams toFilterParams() {

		QueryFilterAndParams params = new QueryFilterAndParamsImpl();
		if (name != null) {
			params.addFilterParamValues(Name_FILTER, "name", name);
		}
		return params;
	
	}


	/**
	 * @return the cName
	 */
	public String getName() {
	    return name;
	}


	/**
	 * @param cName the cName to set
	 */
	public void setName(String name) {
	    this.name = name;
	}


	/**
	 * @return the cNumber
	 *//*
	public String getcNumber() {
	    return cNumber;
	}


	*//**
	 * @param cNumber the cNumber to set
	 *//*
	public void setcNumber(String cNumber) {
	    this.cNumber = cNumber;
	}


	*//**
	 * @return the cAddress
	 *//*
	public String getcAddress() {
	    return cAddress;
	}


	*//**
	 * @param cAddress the cAddress to set
	 *//*
	public void setcAddress(String cAddress) {
	    this.cAddress = cAddress;
	}


	*//**
	 * @return the cCity
	 *//*
	public String getcCity() {
	    return cCity;
	}


	*//**
	 * @param cCity the cCity to set
	 *//*
	public void setcCity(String cCity) {
	    this.cCity = cCity;
	}


	*//**
	 * @return the cState
	 *//*
	public String getcState() {
	    return cState;
	}


	*//**
	 * @param cState the cState to set
	 *//*
	public void setcState(String cState) {
	    this.cState = cState;
	}


	*//**
	 * @return the cStatus
	 *//*
	public String getcStatus() {
	    return cStatus;
	}


	*//**
	 * @param cStatus the cStatus to set
	 *//*
	public void setcStatus(String cStatus) {
	    this.cStatus = cStatus;
	}


	*//**
	 * @return the cPostal
	 *//*
	public String getcPostal() {
	    return cPostal;
	}


	*//**
	 * @param cPostal the cPostal to set
	 *//*
	public void setcPostal(String cPostal) {
	    this.cPostal = cPostal;
	}


	*//**
	 * @return the cCountry
	 *//*
	public String getcCountry() {
	    return cCountry;
	}


	*//**
	 * @param cCountry the cCountry to set
	 *//*
	public void setcCountry(String cCountry) {
	    this.cCountry = cCountry;
	}
	*/
	
    }

}
