'use strict';

/**
 * @ngdoc overview
 * @name blogAngularApp
 * @description
 * # blogAngularApp
 *
 * Main module of the application.
 */
angular.module('blog', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/login',{
        templateUrl: '../views/login.html'
      })
      .otherwise({
        redirectTo: '/login'
      });
  });
