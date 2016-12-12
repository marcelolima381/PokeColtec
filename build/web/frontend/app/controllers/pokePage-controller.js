(function(){
  angular.module("pokedex").controller('pokePageController', ['$scope', '$location', '$http', '$routeParams', '$rootScope', function($scope, $location, $http, $routeParams, $rootScope) {

      var currentID = $routeParams.id;

      $scope.pokemon = new Object();
      $scope.pokemon.id = currentID;
      if (currentID < 10) {
          $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+currentID+".png";
      }
      else if(currentID >= 10 && currentID < 100) {
          $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+currentID+".png";
      }
      else {
          $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+currentID+".png";
      }
    //   $scope.pokemon.photo = $scope.pokemon.id + ".jpg";
      $scope.pokemon.name = "Bulbasaur";
      $scope.pokemon.height = 100;
      $scope.pokemon.attack = 50;
      $scope.pokemon.hp = 25;
      $scope.pokemon.weight = 25;
      $scope.pokemon.defense = 75;
      $scope.pokemon.types = ["grass","poison"];
      $scope.pokemon.abilities = ["daw","kank"];
      $scope.pokemon.evolutions = ["ivysaur","venosaur"];

    //   $http({
    //     method: 'GET',
    //     url: 'rota/' + currentID
    //   }).then(function successCallback(response) {
    //       // console.log("preenchendo dados do pokemon...");
    //       $scope.pokemon.id = response.data.id;
    //       $scope.pokemon.name = response.data.name;
    //       $scope.pokemon.height = response.data.height;
    //       $scope.pokemon.attack = response.data.attack;
    //       $scope.pokemon.hp = response.data.hp;
    //       $scope.pokemon.weight = response.data.weight;
    //       $scope.pokemon.defense = response.data.defense;
    //       $scope.pokemon.types = response.data.types;
    //       $scope.pokemon.abilities = response.data.abilities;
      //
      //
    //     }, function errorCallback(response) {
    //       alert('ERROR! CALL THE JÃO!');
    //     });

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
