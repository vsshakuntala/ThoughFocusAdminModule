/**
 * 
 */

var rolesassignment = angular.module(
		'tfadmin.usermanagementmodule.rolesassignment', []);

rolesassignment
		.config([
				'$stateProvider',
				'$urlRouterProvider',
				function($stateProvider, $urlRouterProvider) {
					$stateProvider
							.state(
									'usermgmt.rolesassignment',
									{
										url : '/rolesassignment',
										templateUrl : 'app/partial/usermanagement/roleassignment/roleassignment.html',
										controller : 'RolesAssignmentController'
									});
				} ]);

rolesassignment.controller('RolesAssignmentController', [
		'$scope',
		'$state',
		function($scope, $state) {
			$scope.moveItem = function(item, from, to) {

				console.log('Move item   Item: ' + item + ' From:: ' + from
						+ ' To:: ' + to);
				// Here from is returned as blank and to as undefined

				var idx = from.indexOf(item);
				if (idx != -1) {
					from.splice(idx, 1);
					to.push(item);
				}
			};
			$scope.moveAll = function(from, to) {

				console.log('Move all  From:: ' + from + ' To:: ' + to);
				// Here from is returned as blank and to as undefined

				angular.forEach(from, function(item) {
					to.push(item);
				});
				from.length = 0;
			};
			$scope.backToUserList = function() {
				$state.go('usermgmt.user.viewuser');
			}
			$scope.backToDivision = function() {
				$state.go('usermgmt.divisionassignment');
			}

			$scope.selectedclients = [];

			$scope.availableclients = [ {
				id : 1,
				name : 'Role1'
			}, {
				id : 2,
				name : 'Role2'
			}, {
				id : 4,
				name : 'Role3'
			}, {
				id : 5,
				name : 'Role4'
			}, {
				id : 6,
				name : 'Role5'
			}, {
				id : 3,
				name : 'Role6'
			} ];

		} ]);
