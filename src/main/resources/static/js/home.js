var DictionaryModule = angular.module('dictionaryApp',[]);

DictionaryModule.controller('dictionaryController', function ($scope,$http) {

    $http.defaults.headers.post["Content-Type"] = "application/json";

    function findAllWords() {
        $http.get('words/search/findAllByOrderByRatingDesc').
            success(function (data) {
                $scope.words = data._embedded.words;
            });
    }

    findAllWords();

    $scope.updateRating = function updateRating(wordName,wordMeaning,wordRating) {
            $http.post('words', {
                word: wordName,
                meaning: wordMeaning,
                rating: wordRating
            }).
                success(function() {
                    alert("Rating updated");
                    findAllWords();
                });
    };

    $scope.checkWord = function checkWord(rating) {
        if(rating>0) return "success";
        else if(rating==0) return "warning";
        else return "danger";
    };

});
