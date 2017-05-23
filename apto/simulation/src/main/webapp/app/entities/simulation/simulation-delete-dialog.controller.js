(function() {
    'use strict';

    angular
        .module('simulationApp')
        .controller('SimulationDeleteController',SimulationDeleteController);

    SimulationDeleteController.$inject = ['$uibModalInstance', 'entity', 'Simulation'];

    function SimulationDeleteController($uibModalInstance, entity, Simulation) {
        var vm = this;

        vm.simulation = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Simulation.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
