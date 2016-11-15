app.controller("CadastroEncomendaController", function($http) {
	var vm = this;

	var urlPath = "http://localhost:8080/projeto_encomendas/Encomenda!";
	var urlUsuarioPath = "http://localhost:8080/projeto_encomendas/Usuario!";

	findAll = function() {
		var retorno = $http.get(urlPath + 'findAll.action');
		retorno.then(function(pl) {
			vm.Encomendas = pl.data.contexto.encomendas;
		})
	};

	vm.Cadastrar = function() {
		vm.Encomenda.status = "aguardando";
		var data = {
			'contexto' : {
				'encomenda' : vm.Encomenda
			}
		};

		var retorno = $http.post(urlPath + 'gravar.action', data);
		retorno.then(function(pl) {
			vm.Encomendas = pl.data.contexto.encomendas;
			vm.Limpar();
		})
	};

	montaComboUsuario = function() {
		var retorno = $http.get(urlUsuarioPath + 'findAll.action');
		retorno.then(function(pl) {
			vm.Usuarios = pl.data.contexto.usuarios;
		});
	};

	vm.Limpar = function() {
		vm.Encomenda = {};
		vm.Encomenda.usuario = {};
		vm.Encomenda.nome = "";
		vm.Encomenda.usuario.id = "";
		vm.formCadastro.$setUntouched();
	};

	vm.Excluir = function(id) {
		var encomenda = {};
		encomenda.id = id;
		var data = {
			'contexto' : {
				'encomenda' : encomenda
			}
		};
		var retorno = $http.post(urlPath + 'excluir.action', data);
		retorno.then(function(pl) {
			vm.Encomendas = pl.data.contexto.encomendas;
			vm.Limpar();
		});
	}

	// onLoad
	findAll();
	montaComboUsuario();
});