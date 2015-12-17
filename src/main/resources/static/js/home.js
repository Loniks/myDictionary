var DictionaryModule = angular.module('dictionaryApp', ['ngRoute', 'mgcrea.ngStrap'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                controller: 'index'
            })
            .when('/home', {
                templateUrl: 'home.html',
                controller: 'home'
            })
            .when('/my', {
                templateUrl: 'my.html',
                controller: 'my'
            })
            .when('/login', {
                templateUrl: 'login.html',
                controller: 'navigation'
            })
            .when('/add', {
                templateUrl: 'add.html',
                controller: 'save'
            })
            .when('/register', {
                templateUrl: 'register.html',
                controller: 'registration'
            })
            .otherwise('/');
    })
    .service('user', function () {
        this.sumeUser = null;
    })
    .controller('navigation', function ($scope, $http, user, $window) {
        $scope.error = false;
        $scope.login = function login() {
            $http.get("users/search/findOneByEmailAndPassword",
                {
                    "params": {
                        "email": $scope.email,
                        "password": $scope.password
                    }
                })
                .error(function (data) {
                    $scope.error = true;
                })
                .success(function (data) {
                    if (!angular.isUndefined(data)) {
                        user.sumeUser = data;
                        $window.location.href = '#/home';
                    }
                    else {
                        $scope.error = true;
                    }
                });
        };
    })
    .controller('registration', function ($scope, $http, user, $window) {
        $scope.error = false;
        $scope.register = function register() {
            $http.post('users', {
                "name": $scope.name,
                "email": $scope.email,
                "password": $scope.password,
            })
                .error(function () {
                    $scope.error = true;
                })
                .success(function (data) {
                    if (!angular.isUndefined(data)) {
                        user.sumeUser = data;
                        $window.location.href = '#/home';
                    }
                    else {
                        $scope.error = true;
                    }
                });

        };
    })
    .controller('save', function ($scope, $http, user) {
        $scope.user = user.sumeUser;
        $http.defaults.headers.post["Content-Type"] = "application/json";

        $scope.wordName = "";
        $scope.wordMeaning = "";

        $scope.addWord = function addWord() {
            if ($scope.wordName.trim() == "" || $scope.wordMeaning.trim() == "") {
                alert("Word cant be added because it has null parameter");
            }
            else {
                $http.post('words', {
                    user: $scope.user._links.self.href,
                    word: $scope.wordName,
                    meaning: $scope.wordMeaning,
                    rating: 0
                })
                    .success(function () {
                        alert("Word added");
                    });
            }
        };

    })
    .controller('index', function ($scope, user, $window) {
        $scope.user = user.sumeUser;

        $scope.$watch(function () {
                return user.sumeUser;
            },
            function (newVal, oldVal) {
                $scope.user = newVal;
            }, true);

        $scope.logout = function () {
            user.sumeUser = null;
            $window.location.reload();
            console.log("logout");
        }

    })
    .controller('home', function ($scope, $http, $interval, user) {

        $scope.user = undefined;
        $http.defaults.headers.post["Content-Type"] = "application/json";

        findAllUsers();

        var interval, interval2;

        $scope.$watch(function () {
            return user.sumeUser;
        }, function () {
            $scope.user = undefined;
        }, true);

        $scope.$watch("user", function (newVal, oldVal) {
            if (angular.isDefined(newVal) && angular.isDefined(newVal.email)) start();
            else {
                $scope.words = null;
                if (angular.isDefined(interval)) {
                    $interval.cancel(interval);
                    interval = undefined;
                }
                if (angular.isDefined(interval2)) {
                    $interval.cancel(interval2);
                    interval2 = undefined;
                }
            }
        }, true);

        var start = function () {
            interval = $interval(function () {
                findAllWords();
            }, 1000);
            interval2 = $interval(function () {
                findAllUsers();
            }, 40000);
        };

        function findAllUsers() {
            $http.get('users')
                .success(function (data) {
                    $scope.users = data._embedded.users.filter(function (element) {
                        return !angular.equals(element, user.sumeUser);
                    });
                });
        };

        function findAllWords() {
            $http.get('words/search/findUsers', {
                params: {"id": $scope.user.userId}
            })
                .success(function (data) {
                    $scope.words = data._embedded.words;
                });
        };

        $scope.updateRating = function updateRating(word, vote) {
            if (vote) word.rating++;
            else word.rating--;
            word.user = $scope.user._links.self.href;
            $http.post('words', word).
                success(function () {
                    findAllWords();
                });
        };

        $scope.checkWord = function checkWord(rating) {
            if (rating > 0) return "success";
            else if (rating == 0) return "warning";
            else return "danger";
        };

    })
    .controller('my', function ($scope, $http, $interval, user) {

        $scope.user = user.sumeUser;
        $http.defaults.headers.post["Content-Type"] = "application/json";

        var start = function () {
            $interval(function () {
                findAllWords();
            }, 1000);
        };

        $scope.$watch(function () {
                return user.sumeUser;
            },
            function (newVal, oldVal) {
                console.log("user changed in my")
                $scope.user = newVal;
                if (angular.isDefined(newVal.email)) start();
            }, true);

        function findAllWords() {
            $http.get('words/search/findUsers', {
                params: {"id": $scope.user.userId}
            })
                .success(function (data) {
                    $scope.words = data._embedded.words;
                });
        };

        $scope.checkWord = function checkWord(rating) {
            if (rating > 0) return "success";
            else if (rating == 0) return "warning";
            else return "danger";
        };

    });

