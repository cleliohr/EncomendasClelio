app.controller("AgruparController", function($http) {
	var vm = this;

	var urlPath = "http://localhost:8080/projeto_encomendas/Agrupar!";

	findAll = function() {
		var retorno = $http.get(urlPath + 'findAll.action');
		retorno.then(function(pl) {
			vm.encomendas = pl.data.contexto.viewsAgrupar;
		})
	};

	vm.Agrupar = function() {
		var retorno = $http.get(urlPath + 'agrupar.action');
		retorno.then(function(pl) {
			vm.encomendas = pl.data.contexto.viewsAgrupar;
			vm.mensagem = pl.data.contexto.mensagem;
			vm.mostrarMensagem = true;
		})
	};

	// onLoad
	findAll();
});