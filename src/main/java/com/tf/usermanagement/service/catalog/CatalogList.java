package com.tf.usermanagement.service.catalog;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spaneos.dtssp.AbstractDataTableReport;
import com.spaneos.dtssp.QueryFilterAndParams;
import com.spaneos.dtssp.QueryFilterAndParamsImpl;
import com.spaneos.dtssp.QueryTemplate;
import com.spaneos.dtssp.QueryTemplateBuilder;
import com.spaneos.dtssp.input.DataTablesInput;
/**
 * 
 * @author Shalini
 *
 */

//@Component
public class CatalogList extends AbstractDataTableReport{

	@Override
	protected QueryTemplate attachQueryTemplate() {
		
		QueryTemplate qt = new QueryTemplateBuilder()
				.fetchColumns("c.SerialNo as SerialNo", "c.Model as Model", 
						"c.Customername as CustomerName", "c.CatalogRef as CatalogRef","c.active as Active")
				.from("Catalog c")
				.build();

		return qt;
	}

	@Override
	protected Map<String, String> mapDataTableColNameToDBCol() {
		
		Map<String, String> colMap = new HashMap<>();
		colMap.put("SerialNo", "c.SerialNo");
		colMap.put("Model", "c.Model");
		colMap.put("CustomerName", "c.CustomerName");
		colMap.put("CatalogRef", "c.catalogRef");
		colMap.put("active", "c.Active");

		return colMap;
	}
	
	
	public static class CatalogListDtInput extends DataTablesInput{
		
		private Long serialNo;
		private String model;
		private String customerName;
		private String catalogReference;
		private boolean active;
		

		@Override
		public QueryFilterAndParams toFilterParams() {
			
			QueryFilterAndParams params = new QueryFilterAndParamsImpl();
			
			if(serialNo != null){
				params.addFilterParamValues("", "SerialNo", serialNo);
			}
			if(model != null){
				params.addFilterParamValues("", "model" , model);
			}
			if(customerName != null){
				params.addFilterParamValues("", "customerName", customerName);
			}
			if(catalogReference != null){
				params.addFilterParamValues("", "catalogReference", catalogReference);
			}
				
			params.addFilterParamValues("", "active", active);
			
			return params;
		}
		
		public Long getSerialNo() {
			return serialNo;
		}
		public void setSerialNo(Long serialNo) {
			this.serialNo = serialNo;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCatalogReference() {
			return catalogReference;
		}
		public void setCatalogReference(String catalogReference) {
			this.catalogReference = catalogReference;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}

		@Override
		public String toString() {
			return "CatalogListDtInput [serialNo=" + serialNo + ", model=" + model + ", customerName=" + customerName
					+ ", catalogReference=" + catalogReference + ", active=" + active + "]";
		}
		
	}

}
