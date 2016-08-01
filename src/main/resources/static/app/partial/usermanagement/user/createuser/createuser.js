/**
 * 
 */

var createuser = angular.module('tfadmin.usermanagementmodule.user.createuser',[]);

createuser.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	$stateProvider.state('usermgmt.user.createuser',{
		url:'/createuser',
		templateUrl : 'app/partial/usermanagement/user/createuser/createuser.html',
		controller: 'CreateUserController'
	});
}]);

createuser.controller('CreateUserController',['$scope','$state',function($scope, $state){
	
	$scope.goToUserList = function(){
		
		$state.go('usermgmt.user.viewuser')
	}
	
	
	$scope.submitRegdForm = function(user){
		
		console.log('object', user);
		$scope.user='';
		
		
		$scope.createUserForm.$setPristine();
		$scope.createUserForm.$setUntouched();
		alert("The user "+user.fName+" "+user.mName+" "+user.lName+" is added successfully.");
		
		$state.go('usermgmt.user.viewuser');
		
	}
	$(function() {
		console.log("in phn2");
		$("#mobile").intlTelInput({
			separateDialCode : true,
			utilsScript : "app-content/js/utils.js",
			preferredCountries : [ "in", "us" ]
		});
	});
	
		
	
}]);

