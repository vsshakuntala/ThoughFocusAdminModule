/**
 * 
 */

var customerassignment = angular.module('tfadmin.usermanagementmodule.customerassignment',['datatables']);

customerassignment.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	$stateProvider.state('usermgmt.customerassignment',{
		url:'/customerassignment',
		templateUrl : 'app/partial/usermanagement/customerassignment/customerassignment.html',
		controller: 'CustomerAssignmentController'
	});
}]);

customerassignment.controller('CustomerAssignmentController',['$scope','$state','DTOptionsBuilder','DTColumnBuilder',function($scope, $state,DTOptionsBuilder, DTColumnBuilder){
	
	$scope.toggle = function() {
        $scope.isVisible = ! $scope.isVisible;
    };
    // Default the blocks to be visible.
    $scope.isVisible = true;    
    
    $scope.assignall = function(){
    	
    	BootstrapDialog.confirm({ title: 'Assigne All',
            message: 'Are you sure you want to assign all customer to user?', callback: function(result){
            	if(result) {
                    alert('Assigned All');
                }else {
                    alert('Fail');
                }
            }});    	
    	 
    };    

    $scope.backToDivision = function() {
		$state.go('usermgmt.divisionassignment');
	}
    
	$scope.removeall = function() {
		
		BootstrapDialog.confirm({ title: 'Remove All',
            message: 'Are you sure you want to remove all customer from user?', callback: function(result){
            	if(result) {
                    alert('Removed All');
                }else {
                    alert('Fail');
                }
            }});	

		
	};

	$scope.backToUserList=function(){
    	$state.go('usermgmt.user.viewuser');
    }

	$scope.assign = function() {
		
		BootstrapDialog.confirm({ title: 'Assign',
            message: 'Are you sure you want to assign selected customer to user?', callback: function(result){
            	if(result) {
                    alert('Assigned');
                }else {
                    alert('Fail');
                }
            }});	

		
	};

	$scope.remove = function() {
		
		BootstrapDialog.confirm({ title: 'Remove',
            message: 'Are you sure you want to remove selected customer from user?', callback: function(result){
            	if(result) {
                    alert('Removed');
                }else {
                    alert('Fail');
                }
            }});		
	};
	
	$scope.downloadresult = function() {

		BootstrapDialog.confirm({ title: 'Download',
            message: 'Are you sure you want to download?', callback: function(result){
            	if(result) {
                    alert('Downloaded');
                }else {
                    alert('Fail');
                }
            }});
	};	
	   
		
    	vm = this;
        showtable();
        $scope.searchByParams = function (customer) {
            showtable(customer.customername,customer.customernum, customer.billtonum, customer.addressone, customer.city, customer.state,
            		customer.postal, customer.status);
            alert(angular.toJson(customer));
        };
    	
        function showtable(custName,custNumber,billToNumber,addressOne,city,state,postal,status) {        	
    
        	
            vm.dtOptions = DTOptionsBuilder.newOptions()
                    .withOption('ajax', {
                        url: 'customerAssignmentReport',
                        type: 'GET',                       
                       
                        data: {
                        	'name': custName,
                                                
                        }
                    })
                    .withDataProp('data')
                    .withOption('processing', true)
                    .withOption('serverSide', true)
                    .withOption("bDestory", true)
                    .withPaginationType('full_numbers')
                    .withOption('bFilter', true);

            vm.dtColumns = [                             
            	 
                {
                    'mData': 'name',
                    'sTitle': 'Name',
                    'name': 'name'
                }];
        }
    	

	
}]);