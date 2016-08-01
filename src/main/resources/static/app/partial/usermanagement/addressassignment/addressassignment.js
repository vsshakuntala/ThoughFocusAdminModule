/**
 * 
 */

var addressassignment = angular.module('tfadmin.usermanagementmodule.addressassignment',['ngMaterial', 'ngMessages']);

addressassignment.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	$stateProvider.state('usermgmt.addressassignment',{
		url:'/addressassignment',
		templateUrl : 'app/partial/usermanagement/addressassignment/addressassignment.html',
		controller: 'AddressAssignmentController'
	});
}]);

addressassignment.controller('AddressAssignmentController',['$scope','$state',function($scope, $state){
	
	$scope.backToUserList=function(){
    	$state.go('usermgmt.user.viewuser');
    }
	$scope.backToDivision = function() {
		$state.go('usermgmt.divisionassignment');
	}
}]);

