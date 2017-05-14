(function() {
    'use strict';
    angular
        .module('simulationApp')
        .factory('Simulation', Simulation);

    Simulation.$inject = ['$resource'];

    function Simulation ($resource) {
        var resourceUrl =  'api/simulations/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
