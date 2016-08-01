/**
 * 
 */

var viewuser = angular.module('tfadmin.usermanagementmodule.user.viewuser',['datatables']);

viewuser.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	$stateProvider.state('usermgmt.user.viewuser',{
		url:'/viewuser',
		templateUrl : 'app/partial/usermanagement/user/viewuser/viewuser.html',
		controller: 'ViewUserController'
	});
}]);

viewuser.controller('ViewUserController',['$scope','$state',function($scope, $state){
	
	$scope.divisions=[{id:1,name:'div1'},{id:2,name:'div2'},{id:3,name:'div3'},{id:4,name:'div4'},{id:5,name:'div5'}];
	$scope.status=[{id:1,name:'Pending'},{id:2,name:'Approved'},{id:3,name:'Deleted'}];
	$scope.roles=[{id:1,name:'Admin'},{id:2,name:'Super Admin'},{id:3,name:'Internal admin'}]

	$scope.getdiv = function(div){
	alert(angular.toJson(div));
	};


	$scope.getroles = function(roles) {
	alert(angular.toJson(roles));
	};

	$scope.getstatus = function(status) {
	alert(angular.toJson(status));
	};

	$scope.toggle = function() {
		console.log('in toggle view user');
	    $scope.isVisible = !$scope.isVisible;
	    console.log('isVisible :'+$scope.isVisible);
	};
	// Default the blocks to be visible.
	$scope.isVisible = false;
	
	$scope.create = function(){			
		 $state.go('usermgmt.user.createuser');
    }
	
	$scope.userList = [
	                   {
	                	   "userName" : "Avinash@gmail.com",
	                	   "firstName" : "Avinash",
	                	   "lastName" : "Dongre",
	                	   "email" : "Avinash@gmail.com",
	                	   "registeredDate" : "15/03/1993",
	                	   "mobile" : 8280248939,
	                	   "comapny" : "Company 1",
	                	   "status" : "Approved",
	                	   "approvedCount" : "3",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Angelica@gmail.com",
	                	   "firstName" : "Angelica",
	                	   "lastName" : "Ramos",
	                	   "email" : "Angelica@gmail.com",
	                	   "registeredDate" : "06/03/1994",
	                	   "mobile" : 7338134250,
	                	   "comapny" : "Company 2",
	                	   "status" : "Pending",
	                	   "approvedCount" : "4",
	                	   "pendingCount" : "1",
	                	   "isDeleted" : false  
	                   },
	                   {
	                	   "userName" : "Ashton@gmail.com",
	                	   "firstName" : "Ashton ",
	                	   "lastName" : "Cox",
	                	   "email" : "Ashton@gmail.com",
	                	   "registeredDate" : "11/06/1988",
	                	   "mobile" : 2589631470,
	                	   "comapny" : "Company 3",
	                	   "status" : "Approved",
	                	   "approvedCount" : "2",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Bradley@gmail.com",
	                	   "firstName" : "Bradley ",
	                	   "lastName" : "Greer",
	                	   "email" : "Bradley@gmail.com",
	                	   "registeredDate" : "09/07/2009",
	                	   "mobile" : 7205435275,
	                	   "comapny" : "Company 4",
	                	   "status" : "Approved",
	                	   "approvedCount" : "6",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Brenden@gmail.com",
	                	   "firstName" : "Brenden ",
	                	   "lastName" : "Wagner",
	                	   "email" : "Brenden@gmail.com",
	                	   "registeredDate" : "03/05/2005",
	                	   "mobile" : 1452369858,
	                	   "comapny" : "Company 5",
	                	   "status" : "Pending",
	                	   "approvedCount" : "5",
	                	   "pendingCount" : "3",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Brielle@gmail.com",
	                	   "firstName" : "Brielle ",
	                	   "lastName" : "Williamson",
	                	   "email" : "Brielle@gmail.com",
	                	   "registeredDate" : "11/09/1997",
	                	   "mobile" : 9087653257,
	                	   "comapny" : "Company 6",
	                	   "status" : "Pending",
	                	   "approvedCount" : "1",
	                	   "pendingCount" : "3",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Bruno@gmail.com",
	                	   "firstName" : "Bruno ",
	                	   "lastName" : "Nash",
	                	   "email" : "Bruno@gmail.com",
	                	   "registeredDate" : "17/08/1995",
	                	   "mobile" : 4589632574,
	                	   "comapny" : "Company 7",
	                	   "status" : "Deleted",
	                	   "approvedCount" : "0",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : true
	                   },
	                   {
	                	   "userName" : "Caesar@gmail.com",
	                	   "firstName" : "Caesar ",
	                	   "lastName" : "Vance",
	                	   "email" : "Caesar@gmail.com",
	                	   "registeredDate" : "19/04/2008",
	                	   "mobile" : 0236514789,
	                	   "comapny" : "Company 8",
	                	   "status" : "Approved",
	                	   "approvedCount" : "3",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Cara@gmail.com",
	                	   "firstName" : "Cara ",
	                	   "lastName" : "Stevens",
	                	   "email" : "Cara@gmail.com",
	                	   "registeredDate" : "12/12/2009",
	                	   "mobile" : 1596325874,
	                	   "comapny" : "Company 9",
	                	   "status" : "Deleted",
	                	   "approvedCount" : "0",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : true
	                   },
	                   {
	                	   "userName" : "Cedric@gmail.com",
	                	   "firstName" : "Cedric ",
	                	   "lastName" : "Kelly",
	                	   "email" : "Cedric@gmail.com",
	                	   "registeredDate" : "15/08/2003",
	                	   "mobile" : 7541258963,
	                	   "comapny" : "Company 10",
	                	   "status" : "Approved",
	                	   "approvedCount" : "7",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Charde@gmail.com",
	                	   "firstName" : "Charde ",
	                	   "lastName" : "Marshall",
	                	   "email" : "Charde@gmail.com",
	                	   "registeredDate" : "04/05/2001",
	                	   "mobile" : 3791456280,
	                	   "comapny" : "Company 11",
	                	   "status" : "Approved",
	                	   "approvedCount" : "6",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Colleen@gmail.com",
	                	   "firstName" : "Colleen",
	                	   "lastName" : "Hurst",
	                	   "email" : "Colleen@gmail.com",
	                	   "registeredDate" : "23/08/1996",
	                	   "mobile" : 1226589740,
	                	   "comapny" : "Company 12",
	                	   "status" : "Deleted",
	                	   "approvedCount" : "0",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : true
	                   },
	                   {
	                	   "userName" : "Dai@gmail.com",
	                	   "firstName" : "Dai",
	                	   "lastName" : "Rios",
	                	   "email" : "Dai@gmail.com",
	                	   "registeredDate" : "07/10/1999",
	                	   "mobile" : 3647586972,
	                	   "comapny" : "Company 13",
	                	   "status" : "Pending",
	                	   "approvedCount" : "2",
	                	   "pendingCount" : "1",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Donna@gmail.com",
	                	   "firstName" : "Donna",
	                	   "lastName" : "Snider",
	                	   "email" : "Donna@gmail.com",
	                	   "registeredDate" : "08/11/2000",
	                	   "mobile" : 6456372345,
	                	   "comapny" : "Company 14",
	                	   "status" : "Approved",
	                	   "approvedCount" : "6",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   },
	                   {
	                	   "userName" : "Doris@gmail.com",
	                	   "firstName" : "Doris",
	                	   "lastName" : "Wilder",
	                	   "email" : "Doris@gmail.com",
	                	   "registeredDate" : "14/02/2006",
	                	   "mobile" : 2345678765,
	                	   "comapny" : "Company 15",
	                	   "status" : "Approved",
	                	   "approvedCount" : "3",
	                	   "pendingCount" : "0",
	                	   "isDeleted" : false
	                   }
	                   ]
	
	$scope.checkIsDeleted = function(user){
		if(user.isDeleted === true){
			return true;
		}else{
			return false;
		}
	};
	
	$scope.checkApprovedStatus = function(user){
		if(user.status === 'Approved'){
			return true;
		}else{
			return false;
		}
	};
	
	$scope.checkPendingStatus = function(user){
		if(user.status === 'Pending'){
			return true;
		}else{
			return false;
		}
	};
	
	$scope.checkDeletedStatus = function(user){
		if(user.status === 'Deleted'){
			return true;
		}else{
			return false;
		}
	};
	
}]);

