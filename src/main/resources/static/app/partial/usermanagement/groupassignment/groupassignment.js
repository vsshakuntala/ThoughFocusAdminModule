/**
 * 
 */

var groupassignment = angular.module('tfadmin.usermanagementmodule.groupassignment',[]);

groupassignment.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	$stateProvider.state('usermgmt.groupassignment',{
		url:'/groupassignment',
		templateUrl : 'app/partial/usermanagement/groupassignment/groupassignment.html',
		controller: 'GroupAssignmentController'
	});
}]);

groupassignment.controller('GroupAssignmentController',['$scope','$state',function($scope, $state){
	
	$scope.moveItem = function(item, from, to) {

        console.log('Move item   Item: '+item+' From:: '+from+' To:: '+to);
        //Here from is returned as blank and to as undefined

        var idx=from.indexOf(item);
        if (idx != -1) {
            from.splice(idx, 1);
            to.push(item);      
        }
    };
    $scope.moveAll = function(from, to) {

        console.log('Move all  From:: '+from+' To:: '+to);
        //Here from is returned as blank and to as undefined

        angular.forEach(from, function(item) {
            to.push(item);
        });
        from.length = 0;
    };                

    $scope.selectedclients = [];     
    
    $scope.backToDivision = function() {
		$state.go('usermgmt.divisionassignment');
	}
    
    $scope.backToUserList=function(){
    	$state.go('usermgmt.user.viewuser');
    }

    $scope.availableclients = [
      {
        id: 1, 
        name: 'group1'
      }, 
      {
        id: 2, 
        name: 'group2'
      },{
          id: 4, 
          name: 'group3'
        },
        {
            id: 5, 
            name: 'group4'
          },
          {
              id: 6, 
              name: 'group5'
            },
      {
        id: 3,
        name: 'group6'
      }
    ];
	
	
	
}]);

