(function(){
  angular.module("pokedex").controller('pokePageController', ['$scope', '$location', '$http', '$routeParams', '$rootScope', function($scope, $location, $http, $routeParams, $rootScope) {

      var currentID = $routeParams.id;

      $scope.pokemon = new Object();
      // $scope.pokemon.id = currentID;
      // if (currentID < 10) {
      //     $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+currentID+".png";
      // }
      // else if(currentID >= 10 && currentID < 100) {
      //     $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+currentID+".png";
      // }
      // else {
      //     $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+currentID+".png";
      // }
    //   $scope.pokemon.photo = $scope.pokemon.id + ".jpg";
      // $scope.pokemon.name = "Bulbasaur";
      // $scope.pokemon.height = 100;
      // $scope.pokemon.attack = 50;
      // $scope.pokemon.hp = 25;
      // $scope.pokemon.weight = 25;
      // $scope.pokemon.defense = 75;
      // $scope.pokemon.types = ["grass","poison"];
      // $scope.pokemon.abilities = ["daw","kank"];
      // $scope.pokemon.evolutions = ["ivysaur","venosaur"];

      $http({
        method: 'GET',
        url: 'mvc?logica=GetPokemonById&id='+currentID
      }).then(function successCallback(response) {
          // console.log("preenchendo dados do pokemon...");
          $scope.pokemon = response.data;
          $http({
            method: 'GET',
            url: 'mvc?logica=GetEvolucaoPokemon&id='+$scope.pokemon.id
          }).then(function successCallback(response) {
              // console.log("preenchendo dados do pokemon...");
              $scope.pokemon.evolution = response.data;
              console.log("EVOLUCÃO:" + response.data.name);


            }, function errorCallback(response) {
              alert('ERROR! CALL THE JÃO!');
            });

        }, function errorCallback(response) {
          alert('ERROR! CALL THE JÃO!');
        });

        // $http({method: 'POST', url: '/rota', data: JSON.stringify($scope.pokemon)}).then(function successCallback(response) {
        //   $scope.pokemon.evolutions.push(response.data.evolution);
        // }, function errorCallback(response) {
        //   alert('ERROR! CALL THE JÃO!');
        // });



      $scope.isAdmin = function() {
        if (localStorage.getItem("adminID") == 1) {
          return true;
        }
        return false;
      }

      $scope.signOut = function() {
        localStorage.setItem("adminID", 0);
        $location.path("/");
      }

      // Go
      $scope.go = function(path) {
        console.log(path);
        $location.path(path);
      };


  }]);
})();
