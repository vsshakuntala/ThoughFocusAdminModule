
/**
 *
 */

var divisionassignment = angular.module('tfadmin.usermanagementmodule.divisionassignment',[]);

divisionassignment.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
    $stateProvider.state('usermgmt.divisionassignment',{
        url:'/divisionassignment',
        templateUrl : 'app/partial/usermanagement/divisionassignment/divisionassignment.html',
        controller: 'DivisionAssignmentController'
    });
}]);

divisionassignment.controller('DivisionAssignmentController',['$scope','$state','$http',function($scope, $state,$http){

      $scope.notes=[
                    {
                    "note":"This user is not active for this division",
                    "date":"21/7/2016"
                    },
                    {
                    "note":"Need confirmation from finance team",
                    "date":"21/7/2016"
                    },
                    {
                    "note":"Need a confirmation from super admin",
                    "date":"21/7/2016"
                    }
                    ];
      $scope.userNote = {};



      $scope.submitNoteOfUser=function(userNote){
          $scope.userNotes.description = $scope.userNote;
          $scope.notes.push($scope.userNotes);
          console.log($scope.notes);

      }
      $scope.divisionList = [
{
    "status": "Approved",
    "organizationId": 1,
    "roleCount": 0,
    "customerCount": 1,
    "customerGroupCount": 19192,
    "defaultAddressCount": 1,
    "catalogCount": 0,
    "catalogGroupCount": 148,
    "groupsCount": 1,
    "organizationName": "ORGANIZATION-1"
  },
  {
    "status": "Pending",
    "organizationId": 2,
    "roleCount": 0,
    "customerCount": 1,
    "customerGroupCount": 0,
    "defaultAddressCount": 0,
    "catalogCount": 0,
    "catalogGroupCount": 0,
    "groupsCount": 0,
    "organizationName": "ORGANIZATION-2"
  },
  {
    "status": "Pending",
    "organizationId": 3,
    "roleCount": 0,
    "customerCount": 1,
    "customerGroupCount": 0,
    "defaultAddressCount": 0,
    "catalogCount": 0,
    "catalogGroupCount": 0,
    "groupsCount": 0,
    "organizationName": "ORGANIZATION-3"
  },
  {
    "status": "Pending",
    "organizationId": 4,
    "roleCount": 0,
    "customerCount": 1,
    "customerGroupCount": 126308,
    "defaultAddressCount": 1,
    "catalogCount": 0,
    "catalogGroupCount": 149,
    "groupsCount": 2,
    "organizationName": "ORGANIZATION-4"
  },
  {
    "status": "Pending",
    "organizationId": 5,
    "roleCount": 0,
    "customerCount": 1,
    "customerGroupCount": 0,
    "defaultAddressCount": 0,
    "catalogCount": 0,
    "catalogGroupCount": 0,
    "groupsCount": 0,
    "organizationName": "ORGANIZATION-5"
  }

      ];
 $scope.checkRoleResults=function(division){
     //role
     if(division.Role>0){
        return true;
     }else{
         return false;
     }
 };

 $scope.checkMachinesResults=function(division){
     //machines
     if((division.catalogCount+division.catalogGroupCount)>0){
        return true;
     }else{
         return false;
     }
 };

  $scope.checkCustomerResults=function(division){
     //customers
if((division.customerCount+division.customerGroupCount)>0){
        return true;
     }else{
         return false;
     }
 };
  $scope.checkDefaultAddressResults=function(division){
     //address
     if(division.defaultAddressCount>0){
        return true;
     }else{
         return false;
     }
 };
 $scope.checkGroupResults=function(division){
     //groups
     if(division.groupsCount>0){
        return true;
     }else{
         return false;
     }
 };

 $scope.checkApproveDivisionUI=function(division){
 console.log(division.customerCount+division.customerGroupCount);
     if((division.customerCount+division.customerGroupCount)>0 &&
             division.defaultAddressCount>0 && division.status=='Pending'){
         return true;
     }else{
         return false;
     }
 };

 $scope.checkAddDivisionUI=function(division){
     console.log(division.Role);
     if(division.roleCount < 1 && (division.customerCount+division.customerGroupCount) < 1 && division.defaultAddressCount < 1 && (division.catalogCount+ division.catalogGroupCount)< 1){

         return true;
     }else{
         return false;
     }

 };

 $scope.checkRemoveDivisionUI=function(division){

     if((division.customerCount+division.customerGroupCount) > 1
             && division.defaultAddressCount > 1 &&(division.catalogCount+ division.catalogGroupCount) > 1 && division.status=='Approved'){

         return false;
     }else{
         return true;
     }

 };

 $scope.checkDivisionStatus=function(division){
     if(division.status === 'Approved'){

         return true;
     }else{
         return false;
     }
 };

 /*
  * navigation to different modules based on user
  * selection
  */
 $scope.navigateToRoles=function(){
     $state.go('usermgmt.rolesassignment');
 };

$scope.navigateToMachines=function(){
    $state.go('usermgmt.machineassignment');
 };

$scope.navigateToCustomers=function(){
    $state.go('usermgmt.customerassignment');
 };
$scope.navigateToDefaultAddress=function(){
    $state.go('usermgmt.addressassignment');
 };
$scope.navigateToGroups=function(){
    $state.go('usermgmt.groupassignment');
 };
}]);

