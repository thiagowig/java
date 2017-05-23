(function() {
    'use strict';

    angular
        .module('simulationApp')
        .controller('SimulationDialogController', SimulationDialogController);

    SimulationDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Simulation'];

    function SimulationDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Simulation) {
        var vm = this;

        vm.simulation = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.simulation.id !== null) {
                Simulation.update(vm.simulation, onSaveSuccess, onSaveError);
            } else {
                Simulation.save(vm.simulation, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('simulationApp:simulationUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
