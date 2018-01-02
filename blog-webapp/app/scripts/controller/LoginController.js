'use strict';
var app = angular.module('blog', []);
app.controller('LoginController', LoginController);
 function LoginController($scope) {
  $scope.login = function (user) {
    console.log(user);
    if(!user.bill_code){

      return;
    }
    if(!user.password){

      return;
    }




  }
 }

