var gestoreFascicolo = angular.module('gestoreFascicolo', []).controller('fascicoloController', function ($scope,$http) {
	$scope.name = 'Prova';
	$scope.searchFascicolo={};
	$scope.getListaFascicolo = function() {

	    $http({
	        url: "/GestoreFascicolo/listaFascicolo.action",
	        data: $scope.searchFascicolo,
	        method: 'POST',
	        headers : {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'}
	    }).success(function(data){
	    	$scope.fascicoloList = data;
	    }).error(function(err){"ERR", console.log(err)})
	};
//	$scope.getListaFascicolo = function() {
//		$http.get("listaFascicolo").success(
//			function(data, status, headers, config) {
//				$scope.fascicoloList = data;
//			}).error(function(data, status, headers, config) {
//				// called asynchronously if an error occurs
//				// or server returns response with an error status.
//			});
//	};
});