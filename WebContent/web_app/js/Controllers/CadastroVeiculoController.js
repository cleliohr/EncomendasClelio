app.controller("CadastroVeiculoController", function($http) {
	var vm = this;
	var urlPath = "http://localhost:8080/projeto_encomendas/Veiculo!";
	var urlPathZona = "http://localhost:8080/projeto_encomendas/Zona!";

	findAll = function() {
		var retorno = $http.get(urlPath + 'findAll.action');
		retorno.then(function(pl) {
			vm.VeiculosCadastrados = pl.data.contexto.veiculos;
		})
	};

	montarComboZona = function() {
		var retorno = $http.get(urlPathZona + 'findAll.action');
		retorno.then(function(pl) {
			vm.zonas = pl.data.contexto.zonas;
		})
	};

	vm.Cadastrar = function() {
		var data = {
			'contexto' : {
				'veiculo' : vm.Veiculo
			}
		};
		var retorno = $http.post(urlPath + 'gravar.action', data);
		retorno.then(function(pl) {
			vm.VeiculosCadastrados = pl.data.contexto.veiculos;
			vm.Limpar();
		})
	};

	vm.Limpar = function() {
		vm.Veiculo = {};
		vm.Veiculo.nome = "";
		vm.Veiculo.zona = {};
		vm.Veiculo.zona.id = "";
		vm.formCadastro.$setUntouched();
	};

	vm.Excluir = function(id) {
		var veiculo = {};
		veiculo.id = id;
		var data = {
			'contexto' : {
				'veiculo' : veiculo
			}
		};
		var retorno = $http.post(urlPath + 'excluir.action', data);
		retorno.then(function(pl) {
			vm.VeiculosCadastrados = pl.data.contexto.veiculos;
		});
	}

	// onLoad
	findAll();
	montarComboZona();
});