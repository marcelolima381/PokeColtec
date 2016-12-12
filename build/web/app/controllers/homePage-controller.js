(function(){
  angular.module("pokedex").controller('homePageController', ['$scope', '$location', '$http', '$routeParams', 'pokemonService', '$rootScope', function($scope, $location, $http, $routeParams, $rootScope, pokemonService) {
      $scope.$on('$viewContentLoaded', function () {
        $scope.pokemon = {};
        // $scope.pokemons = [];
        $scope.pokemons = {};
        $scope.pokemons.types = [];
        $scope.pokemons.abilities = [];
          $http({
            method: 'GET',
            url: 'mvc?logica=GetAllPokemon'
          }).then(function successCallback(response) {
            // console.log(JSON.stringify(response.data));
            console.log(response.data.length);

            $scope.pokemons = response.data;
            console.log(JSON.stringify($scope.pokemons));
            // $scope.pokemons.id = response.data.id;
            // $scope.pokemons.name = response.data.name;
            // $scope.pokemons.height = response.data.height;
            // $scope.pokemons.weight = response.data.weight;
            // $scope.pokemons.hp = response.data.hp;
            // $scope.pokemons.attack = response.data.attack;
            // $scope.pokemons.defense = response.data.defense;
            // $scope.pokemons.types = response.data.types;
            // $scope.pokemons.abilities = response.data.abilities;
              // if ( < 10) {
              //     $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+i+".png";
              // }
              // else if( >= 10 && i < 100) {
              //     $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+i+".png";
              // }
              // else {
              //     $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+i+".png";
              // }
              $scope.pokemons.photo = response.data.imgURL;
            // $scope.pokemon.photo = i + ".jpg";
            // $scope.pokemon.id = i;
            // console.log(JSON.stringify($scope.pokemons));
            // $scope.pokemons.push($);
            }, function errorCallback(response) {
              alert("erro");
            });


        // $scope.pokemons = [];
        // for(var i = 1; i <= 151; i++) {
        //   $.ajax({
        //     type: "GET",
        //     url: 'jooj',
        //     async: false,
        //     success: function(response){
        //         if (i < 10) {
        //             $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+i+".png";
        //         }
        //         else if(i >= 10 && i < 100) {
        //             $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+i+".png";
        //         }
        //         else {
        //             $scope.pokemon.photo = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+i+".png";
        //         }
        //
        //       $scope.pokemon.id = i;
        //       $scope.pokemon.idString = $scope.pokemon.id.toString();
        //       $scope.pokemons.push({photo:$scope.pokemon.photo,id:$scope.pokemon.id,idString:$scope.pokemon.idString});
        //
        //     }
        //   });
        // }
        // console.log(JSON.stringify($scope.pokemons));
        // $route.reload();
      });


    //   for (var i = 0; i <= 151; i++) {
    //     pokemonService.getPokemons(i).success(function(data) {
    //       $scope.pokemon.photo = i + ".jpg";
    //       $scope.pokemon.id = i;
    //       $scope.pokemon.name = data.forms.name;
    //       $scope.pokemons.push({photo:$scope.pokemon.photo,id:$scope.pokemon.id,name:$scope.pokemon.name});
    //     });
    //   }

      $scope.go = function(path) {
        console.log(path);
        $location.path(path);
      };

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

  }]);
})();
