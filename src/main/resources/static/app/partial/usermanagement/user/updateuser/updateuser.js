/**
 * 
 */
var updateuser = angular.module('tfadmin.usermanagementmodule.user.updateuser',[]);

updateuser.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	$stateProvider.state('usermgmt.user.updateuser',{
		url:'/updateuser',
		templateUrl : 'app/partial/usermanagement/user/updateuser/updateuser.html',
		controller: 'UpdateUserController'
	});
}]);

updateuser.controller('UpdateUserController',['$scope','$state',function($scope, $state){
	
	$scope.goBackToDivision = function(){
		$state.go('usermgmt.divisionassignment')
	}
	$(function() {
		console.log("in phn2");
		$("#mobile").intlTelInput({
			separateDialCode : true,
			utilsScript : "app-content/js/utils.js",
		});
	});
	
}]);