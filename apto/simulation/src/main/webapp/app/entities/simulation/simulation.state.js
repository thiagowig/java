(function() {
    'use strict';

    angular
        .module('simulationApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('simulation', {
            parent: 'entity',
            url: '/simulation',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Simulations'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/simulation/simulations.html',
                    controller: 'SimulationController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('simulation-detail', {
            parent: 'simulation',
            url: '/simulation/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Simulation'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/simulation/simulation-detail.html',
                    controller: 'SimulationDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'Simulation', function($stateParams, Simulation) {
                    return Simulation.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'simulation',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('simulation-detail.edit', {
            parent: 'simulation-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/simulation/simulation-dialog.html',
                    controller: 'SimulationDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Simulation', function(Simulation) {
                            return Simulation.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('simulation.new', {
            parent: 'simulation',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/simulation/simulation-dialog.html',
                    controller: 'SimulationDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                financialInstituition: null,
                                propertyValue: null,
                                usingFgts: null,
                                financialValue: null,
                                initialValue: null,
                                fgtsValue: null,
                                months: null,
                                tax: null,
                                withTR: null,
                                sacInstallment: null,
                                priceInstallment: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('simulation', null, { reload: 'simulation' });
                }, function() {
                    $state.go('simulation');
                });
            }]
        })
        .state('simulation.edit', {
            parent: 'simulation',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/simulation/simulation-dialog.html',
                    controller: 'SimulationDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Simulation', function(Simulation) {
                            return Simulation.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('simulation', null, { reload: 'simulation' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('simulation.delete', {
            parent: 'simulation',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/simulation/simulation-delete-dialog.html',
                    controller: 'SimulationDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Simulation', function(Simulation) {
                            return Simulation.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('simulation', null, { reload: 'simulation' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
