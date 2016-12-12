(function(){
  angular.module("pokedex").factory('pokemonService', ['$http', function($http) {
    var getPokemons = function(i) {
      return $http.get('http://pokeapi.co/api/v2/pokemon/' + i);
    };

    return {
      getPokemons: getPokemons
    };
  }]);
})();
