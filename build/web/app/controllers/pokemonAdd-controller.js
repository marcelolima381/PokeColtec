(function(){
  angular.module("pokedex").controller('pokemonAddController', ['$scope', '$location', '$http', '$routeParams',  function($scope, $location, $http, $routeParams) {
    $scope.isAdmin = function() {
      if (localStorage.getItem("adminID") == 1) {
        return true;
      }
      return false;
    }
    if ($scope.isAdmin()) {
      console.log("ok");
    }
    else {
      console.log("nao ok");
      alert("ACCESS DENIED");
      $location.path('/');
    }
      //   // Go
        $scope.go = function(path) {
          $location.path(path);
        };
      $scope.pokemon = {};
      $scope.pokemon.abilities = [];
      var currentID = $routeParams.id;
      $scope.pokemon.id = currentID;
      console.log($scope.pokemon.id);



      $scope.submitAddForm = function(isValid) {

        $scope.rota, $scope.rotaTypes = "", $scope.rotaAbilities = "";
        for(var i = 0; i < $scope.pokemon.abilities.length; i++) {
          console.log($scope.pokemon.abilities.length);
          $scope.rotaAbilities = $scope.rotaAbilities+"&abilities="+$scope.pokemon.abilities[i];
          // $scope.rotaAbilities.concat("&abilities="+$scope.pokemon.abilities[i]);
        }
        for(var i = 0; i < $scope.pokemon.types.length; i++) {
          console.log($scope.pokemon.types.length);
          $scope.rotaTypes = $scope.rotaTypes+"&types="+$scope.pokemon.types[i];
          // $scope.rotaTypes.concat("&types="+$scope.pokemon.types[i]);
        }
        // console.log($scope.rotaTypes);
        // solveUrl(,,);
        // solveUrl(,,);
        console.log("&id="+$scope.pokemon.id+"&name="+$scope.pokemon.name+"&height="+$scope.pokemon.height+"&weight="+$scope.pokemon.weight+"&hp="+$scope.pokemon.hp+"&attack="+$scope.pokemon.attack+"&defense="+$scope.pokemon.defense+"&evolution="+$scope.pokemon.evolution+$scope.rotaTypes+$scope.rotaAbilities+"&imgURL="+$scope.pokemon.imgURL);
          $http({method: 'POST', url: 'mvc?logica=InsertPokemon&id='+$scope.pokemon.id+"&name="+$scope.pokemon.name+"&height="+$scope.pokemon.height+"&weight="+$scope.pokemon.weight+"&hp="+$scope.pokemon.hp+"&attack="+$scope.pokemon.attack+"&defense="+$scope.pokemon.defense+"&evolution="+$scope.pokemon.evolution+$scope.rotaTypes+$scope.rotaAbilities+"&imgURL="+$scope.pokemon.imgURL, data: JSON.stringify($scope.pokemon)}).then(function successCallback(response) {
            console.log("Pokemon adicionado com sucesso");
            $location.path("/");
          }, function errorCallback(response) {
            alert('ERROR! CALL THE JÃO!');
          });
      };

      // types
      $scope.types = ['normal', 'poison', 'psychic', 'grass', 'ground', 'ice', 'fire', 'rock', 'dragon', 'water', 'bug', 'dark', 'fighting', 'ghost', 'steel', 'flying', 'electric', 'fairy'];
      // $scope.nAbilitieSelected = 3;
      $scope.singleAbilitie;
      $scope.addAbilitie = function() {
        $scope.pokemon.abilities.push($scope.singleAbilitie);
        console.log(JSON.stringify($scope.pokemon.abilities));
        $scope.singleAbilitie = null;
      }
      // selected types
      $scope.pokemon.types = [];

      // toggle types for a given fruit by name
      $scope.toggleSelection = function toggleSelection(pokemonType) {
          var idx = $scope.pokemon.types.indexOf(pokemonType);

          // is currently selected
          if (idx > -1) {
            $scope.pokemon.types.splice(idx, 1);
          }

          // is newly selected
          else {
            $scope.pokemon.types.push(pokemonType);
          }
      };



      $scope.signOut = function() {
        localStorage.setItem("adminID", 0);
        $location.path("/");
      }

      $scope.getAbilitie = function(abi) {
        console.log(abi);
      }




  }]);
})();
