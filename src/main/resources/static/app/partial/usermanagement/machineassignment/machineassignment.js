/**
 * 
 */
var machineassignment = angular.module('tfadmin.usermanagementmodule.machineassignment',[]);

machineassignment.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	$stateProvider.state('usermgmt.machineassignment',{
		url:'/machineassignment',
		templateUrl : 'app/partial/usermanagement/machineassignment/machineassignment.html',
		controller: 'MachineAssignmentController'
	});
}]);

machineassignment.controller('MachineAssignmentController',
		['$scope','$state','DTOptionsBuilder',
		 function($scope, $state, DTOptionsBuilder){
	
			
			$scope.backToUserList=function(){
		    	$state.go('usermgmt.user.viewuser');
		    }		
			
	$scope.toggle = function() {
        $scope.isVisible = ! $scope.isVisible;
    };
    // Default the blocks to be visible.
    $scope.isVisible = false;
	
    $scope.backToDivision = function() {
		$state.go('usermgmt.divisionassignment');
	}
	
	$scope.divisionList = [
	                       {
	                           "serial" : "1",
	                           "Status" : "Approved",
	                           "model":"abc",
	                           "machineReference":"Heavy Duty Compressor",
	                           "customerName":"BFW",
	                           "group":"Group 1",
	                           "status":"Assigned",
	                          
	                       },
	                       {
	                           "serial" : "2",
	                           "Status" : "Pending",
	                           "model":"abc",
	                           "machineReference":"Heavy Duty Compressor",
	                           "customerName":"BFW",
	                           "group":"Group 2",
	                           "status":"Assigned",
	                          
	                       },
	                       {
	                           "serial" : "3",
	                           "Status" : "Un-Assigned",
	                           "model":"abc",
	                           "machineReference":"Heavy Duty Compressor",
	                           "customerName":"BFW",
	                           "group":" ",
	                           "status":" ",
	                         
	                       },
	                        {
	                           "serial" : "4",
	                           "Status" : "Pending",
	                           "model":"abc",
	                           "machineReference":"Heavy Duty Compressor",
	                           "customerName":"BFW",
	                           "group":" ",
	                           "status":" ",
	                           
	                       },
	                        {
	                           "serial" : "5",
	                           "Status" : "Pending",
	                           "model":"xyz",
	                           "machineReference":"Heavy Duty",
	                           "customerName":"ASD",
	                           "group":" ",
	                           "status":" ",
	                           
	                       },
	                        {
	                           "serial" : "6",
	                           "Status" : "Pending",
	                           "model":"abc",
	                           "machineReference":"Heavy Duty",
	                           "customerName":"ASD",
	                           "group":" ",
	                           "status":" ",
	                           
	                       }
	                   
	                   ];
	/*start of configuring dataTable*/
	$scope.dtOptions = DTOptionsBuilder.newOptions()
    .withPaginationType('full_numbers')
    .withOption('initComplete', function(){
    	$("#dataTable_length > label > select").css('width','100px');
    });
	/*end of configuring dataTable*/
	
}]);

