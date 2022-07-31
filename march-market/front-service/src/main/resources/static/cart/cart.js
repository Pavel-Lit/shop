angular.module('market').controller('cartController', function ($scope, $http, $localStorage) {
    $scope.fillCart = function (){
        $http.get('http://localhost:5555/cart/api/v1/cart/'+ $localStorage.marchMarketGuestCartId)
            .then(function (response){
                $scope.cartList = response.data;
                console.log($scope.cartList)
            })
    }
    $scope.clearCart = function (){
        $http.get('http://localhost:5555/cart/api/v1/cart/'+ $localStorage.marchMarketGuestCartId+'/clear')
            .then(function (response){
                $scope.fillCart();
            })
    }
    $scope.deleteOneProductFromCart = function (productId){
        $http.get('http://localhost:5555/cart/api/v1/cart/'+ $localStorage.marchMarketGuestCartId+'/remove/' + productId)
            .then(function (response){
                $scope.fillCart();
            })
    }

    $scope.createNewOrder = function (){
        $http.post('http://localhost:5555/core/api/v1/orders', $scope.newOrder)
            .then(function (response){

                console.log(response);
                alert("Заказ успешно сформирован");
                $scope.fillCart();
            })
    }
    $scope.addProductToCart = function (id){
        $http.get('http://localhost:5555/cart/api/v1/cart/'+ $localStorage.marchMarketGuestCartId+'/add/' + id)
            .then(function (response){
                $scope.fillCart();
            });
    }
    $scope.guestCreateOrder = function () {
        alert('Для оформления заказа необходимо войти в учетную запись');
    }
    $scope.fillCart()
});