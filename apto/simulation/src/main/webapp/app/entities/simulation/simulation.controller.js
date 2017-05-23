(function() {
    'use strict';

    angular
        .module('simulationApp')
        .controller('SimulationController', SimulationController);

    SimulationController.$inject = ['Simulation'];

    function SimulationController(Simulation) {

        var vm = this;

        vm.simulations = [];

        loadAll();

        function loadAll() {
            Simulation.query(function(result) {
                vm.simulations = result;
                vm.searchQuery = null;
            });
        }
    }
})();
