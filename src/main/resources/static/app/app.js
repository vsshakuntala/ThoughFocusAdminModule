/**
 * 
 */
var app = angular.module('tfadmin',['ui.router','tfadmin.usermanagementmodule','tfadmin.loginmodule','tfadmin.appconstantsmodule']);

app.run(['$rootScope','$state','APPCONSTANTS',function($rootScope,$state, APPCONSTANTS){
	$rootScope.APPCONSTANTS  = APPCONSTANTS;
	
	$rootScope.myclass='hold-transition skin-blue sidebar-mini sidebar-collapse fixed';
	
}]);


app.config(['$urlRouterProvider',function($urlRouterProvider){
	$urlRouterProvider.otherwise('/login');
}]);