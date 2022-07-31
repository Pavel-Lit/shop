angular.module('market').controller('registrationController', function ($scope, $http, $location) {

    $scope.tryToRegistration = function () {
        if($scope.newUser.password == $scope.newUser.confirmPassword){
            $http.post('http://localhost:5555/auth/registration', $scope.newUser)
                .then(function successCallback(response) {
                    // alert("Регистрация пользователя"+response.value+"прошла успешно")
                    $location.path('/');
                });
        } else {
            alert("пароли не соответствуют друг другу")
        }

    };

    $scope.fillTable = function () {
        $http.get('http://localhost:5555/core/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
                // console.log(response);
            });
    };
});
