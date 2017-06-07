
var app = angular.module("App", []);

app.controller("IssuedCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/issued').then(function (response){
        $scope.greetings=response.data;
    });
});
app.controller("ClientCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/client').then(function (response){
        $scope.greetings=response.data;
    });
});
app.controller("CarCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/cars').then(function (response){
        $scope.greetings=response.data;
    });
});

