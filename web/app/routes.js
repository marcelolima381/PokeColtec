(function(){
angular.module("pokedex").config(['$routeProvider', function($routeProvider){
  $routeProvider
    .when('/', { //pokedex
        templateUrl: 'app/templates/homepage/index.html',
        controller: 'homePageController'
    })
    .when('/pokemon/:id', { //page individual de cada pokemon
        templateUrl: 'app/templates/pokepage/index.html',
        controller: 'pokePageController'
    })
    .when('/auth', { //login do admin
        templateUrl: 'app/templates/loginpage/index.html',
        controller: 'loginPageController',
        controllerAs: 'loginpgCtrl'
    })
    .when('/admin', { //pokedex do admin com opcoes superUser
        templateUrl: 'app/templates/admin/index.html',
        controller: 'adminPageController',
        controllerAs: 'adminCtrl'
    })
    .when('/admin/pokeAdd', { //pokeAdd do admin
        templateUrl: 'app/templates/admin/pokeAdd/index.html',
        controller: 'pokemonAddController',
        controllerAs: 'pokeAddCtrl'
    })
    .when('/admin/pokeEdit/:id', { //pokeEdit do admin
        templateUrl: 'app/templates/admin/pokeEdit/index.html',
        controller: 'pokemonEditController',
        controllerAs: 'pokeEditCtrl'
    })
    .when('/admin/pokeRemove', { //pokeRemove do admin
        templateUrl: 'app/templates/pokeRemove/index.html',
        controller: 'pokemonEditController',
        controllerAs: 'pokeEditVisitCtrl'
    })
  .otherwise({redirectTo: '/'});
}]);
})();
