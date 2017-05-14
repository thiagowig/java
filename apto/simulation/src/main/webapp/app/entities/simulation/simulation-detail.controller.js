(function() {
    'use strict';

    angular
        .module('simulationApp')
        .controller('SimulationDetailController', SimulationDetailController);

    SimulationDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Simulation'];

    function SimulationDetailController($scope, $rootScope, $stateParams, previousState, entity, Simulation) {
        var vm = this;

        vm.simulation = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('simulationApp:simulationUpdate', function(event, result) {
            vm.simulation = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
