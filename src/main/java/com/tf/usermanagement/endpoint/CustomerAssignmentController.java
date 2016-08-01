package com.tf.usermanagement.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spaneos.dtssp.output.DataTablesOutput;
import com.tf.usermanagement.report.CustomerAssignmentReport;

@RestController
public class CustomerAssignmentController {
    
    @Autowired
    private CustomerAssignmentReport customerAssignmentReport;
    
    @RequestMapping(value="/customerAssignmentReport",method=RequestMethod.GET)
    public DataTablesOutput empReport(CustomerAssignmentReport.CustomerAssignputDtInput inputDt){
	System.out.println("inputDt "+inputDt);
    		DataTablesOutput obj = customerAssignmentReport.fetchData(inputDt);
    	return obj;
    }

}
