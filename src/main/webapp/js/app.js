var myApp = angular.module('CarApp', ['ngRoute']);

myApp.controller('ViewCarsController', function ($scope, CarFactory)
{

    $scope.cars = CarFactory.getCars();
    $scope.title = "Cars Demo App with REST";
    $scope.predicate = "year";

    $scope.deleteCar = function (id) {
        CarFactory.deleteCar(id);
    };

    $scope.editCar = function (id) {
        CarFactory.editCar(id);
    };

});

myApp.controller('AddCarController', function ($scope, CarFactory, $routeParams)
{

    $scope.cars = {};

    if (!$routeParams.id)
    {
        $scope.cars.id = null;
        $scope.legend = "New Car";
    } else
    {
        $scope.cars = CarFactory.getCars()[$routeParams.id - 1];
        $scope.legend = "Edit Car";
    }

    $scope.edit = function ()
    {
        CarFactory.addCar($scope.cars);
    };
});

//Service
myApp.factory('CarFactory', function () {
    
    var cars = [];
    
    //Return Cars from the server
    var getCars = function () 
    {
        cars = [];
        $.getJSON("http://localhost:8084/Ex6Prb3/api/car/all", function (result)
        {
            $.each(result, function (car)
            {
                cars.push({id: car.id, year: car.model_Year, registered: car.registered, make: car.make, model: car.model, description: car.description, price: car.price});
            });
        });
    };
    //Delete Car on the Server
    var deleteCar = function (id) 
    {
        
    };
    //Add Car on the Server
    var addCar = function (newcar) 
    {
        
    };
    //Edit Car on the Server;
    var editCar = function (car) 
    {
        
    };
    
    return {
        getCars: getCars,
        deleteCar: deleteCar,
        addCar: addCar,
        editCar: editCar
    };

});


myApp.config(function ($routeProvider)
{
    $routeProvider
            .when('/home', {
                templateUrl: 'AllCars.html',
                controller: 'ViewCarsController'
            })
            .when('/newCar/:id', {
                templateUrl: 'NewCar.html',
                controller: 'AddCarController'
            })
            .when('/newCar', {
                templateUrl: 'NewCar.html',
                controller: 'AddCarController'
            })
            .otherwise({
                redirectTo: '/AllCars.html'
            });
});


