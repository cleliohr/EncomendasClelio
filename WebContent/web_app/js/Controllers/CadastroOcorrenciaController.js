app
		.controller(
				"CadastroOcorrenciaController",
				function($http) {
					var vm = this;

					var urlPath = "http://localhost:8080/projeto_encomendas/Ocorrencia!";

					find = function() {
						var ocorrencia = {
							encomenda : {
								id : vm.id
							}
						}
						var data = {
							'contexto' : {
								'ocorrencia' : ocorrencia
							}
						};

						var retorno = $http.post(urlPath + 'find.action', data);
						retorno.then(function(pl) {
							vm.ocorrencias = pl.data.contexto.ocorrencias;
						});
					};

					vm.Cadastrar = function() {
						vm.Ocorrencia.dataHora = new Date(
								vm.Ocorrencia.dataHora);
						vm.Ocorrencia.viagem = {};
						vm.Ocorrencia.viagem.id = null;

						var data = {
							'contexto' : {
								'ocorrencia' : vm.Ocorrencia
							}
						};

						var retorno = $http.post(urlPath + 'gravar.action',
								data);
						retorno.then(function(pl) {
							vm.ocorrencias = pl.data.contexto.ocorrencias;
							vm.Limpar();
						});
					};

					vm.Limpar = function() {
						vm.Ocorrencia.descricao = "";
						vm.Ocorrencia.dataHora = "";
						vm.Ocorrencia.tipoOcorrencia = "";
						vm.formCadastro.$setUntouched();
					};

					vm.Excluir = function(id) {
						var ocorrencia = {};
						ocorrencia.id = id;
						var data = {
							'contexto' : {
								'ocorrencia' : ocorrencia
							}
						};
						var retorno = $http.post(urlPath + 'excluir.action',
								data);
						retorno.then(function(pl) {
							vm.ocorrencias = pl.data.contexto.ocorrencias;
							find();
						});
					}

					vm.abrirData = function() {
						vm.dataAberta = true;
					};

					vm.voltar = function() {
						location.href = 'cadastroEncomenda.html';
					};

					// onLoad
					vm.id = getParameterByName('id');
					vm.descricao = getParameterByName('descricao');
					vm.Ocorrencia = {};
					vm.Ocorrencia.encomenda = {};
					vm.Ocorrencia.encomenda.id = vm.id;
					vm.dataAberta = false;
					find();

					function getParameterByName(name, url) {
						if (!url)
							url = window.location.href;
						name = name.replace(/[\[\]]/g, "\\$&");
						var regex = new RegExp("[?&]" + name
								+ "(=([^&#]*)|&|#|$)"), results = regex
								.exec(url);
						if (!results)
							return null;
						if (!results[2])
							return '';
						return decodeURIComponent(results[2]
								.replace(/\+/g, " "));
					}
				});