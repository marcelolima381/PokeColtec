(function(){
  angular.module("pokedex").controller('pokemonAddController', ['$scope', '$location', '$http', '$routeParams',  function($scope, $location, $http, $routeParams) {

      //   // Go
        $scope.go = function(path) {
          $location.path(path);
        };
      $scope.pokemon = {};
      $scope.pokemon.abilities = [];
      $scope.evolutionPokemon = {};
      var currentID = $routeParams.id;
      $scope.pokemon.id = currentID;
      console.log($scope.pokemon.id);

      $scope.evolutionPokemon.pokemon_id = $scope.pokemon.id;
      $scope.submitAddForm = function(isValid) {
          $http({method: 'POST', url: '/rota', data: JSON.stringify($scope.pokemon)}).then(function successCallback(response) {
            console.log("Pokemon editado com sucesso");
          //   $location.path("/");
          }, function errorCallback(response) {
            alert('ERROR! CALL THE JÃO!');
          });
          $http({method: 'POST', url: '/rota', data: JSON.stringify($scope.evolutionPokemon)}).then(function successCallback(response) {
            console.log("Evolução do pokemon editada com sucesso");
            $location.path("/");
          }, function errorCallback(response) {
            alert('ERROR! CALL THE JÃO!');
          });
      };

      // types
      $scope.types = ['Normal', 'Poison', 'Psychic', 'Grass', 'Ground', 'Ice', 'Fire', 'Rock', 'Dragon', 'Water', 'Bug', 'Dark', 'Fighting', 'Ghost', 'Steel', 'Flying', 'electric', 'Fairy'];

      // selected types
      $scope.pokemon.selection = [];

      // toggle selection for a given fruit by name
      $scope.toggleSelection = function toggleSelection(pokemonType) {
          var idx = $scope.pokemon.selection.indexOf(pokemonType);

          // is currently selected
          if (idx > -1) {
            $scope.pokemon.selection.splice(idx, 1);
          }

          // is newly selected
          else {
            $scope.pokemon.selection.push(pokemonType);
          }
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
