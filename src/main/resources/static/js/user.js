var UserModule = angular.module('userApp',[]);

UserModule.controller('userController', function ($scope,$http) {

    $http.defaults.headers.post["Content-Type"] = "application/json";

    $scope.wordName ="";
    $scope.wordMeaning = "";

    console.log(2552);
    $scope.addWord = function addWord() {
        if($scope.wordName.trim()==""||$scope.wordMeaning.trim()==""){
            alert("Word cant be added because it has null parameter");
        }
        else {
            $http.post('words', {
                word: $scope.wordName,
                meaning: $scope.wordMeaning,
                rating: 0
            }).
                success(function () {
                    alert("Word added");
                });
        }
    };

});