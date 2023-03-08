package com.fatec.banco;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoApplication {

	public static void main(String[] args) {
		/*
		 * Código padrão do spring, comentado
		 * SpringApplication.run(BancoApplication.class, args);
		 */

		// 1. Inicio da configuração
		// Objeto de configuração.
		// No objeto configuração são adicionados as configurações utilizadas na inicialização do sistema.
		Map<String, Object> configuracao = new HashMap<>();

		// 2. Configuração para trocar de porta.
		// Nesta configuração você pode escolher a porta que o servidor web será executado.
		// Por padrão a porta é 8080
		configuracao.put("server.port", "8080"); // seleção da porta

		// 3. Configurações do banco de dados mysql
		// 3.1 A URL de conexão é o caminho onde spring irá tentar conectar com o banco.
		// Este caminho é uma URL, porque o banco não é um arquivo é um sistema, que pode inclusive estar em "nuvem"
		configuracao.put("spring.datasource.url", "jdbc:mysql://localhost:3306/banco"); // caminho da conexão
		
		// 3.2 Usuário e senha
		configuracao.put("spring.datasource.username", "root"); // usuario
		configuracao.put("spring.datasource.password", "root"); // senha
		
		// 4. Configurações adicionais para o mapeamento objeto relacional
		// Estas configurações servem para auxiliar o desenvolvedor a interagir diretamento com o banco
		// Permitem automatizar a criação de tabelas e visualizar os comandos utilizados
		configuracao.put("spring.jpa.show-sql", "true"); // mostrar comandos
		configuracao.put("spring.jpa.hibernate.ddl-auto", "update"); // criar editar
		
		SpringApplication app = new SpringApplication(BancoApplication.class);
		app.setDefaultProperties(configuracao);
		app.run(args);
	}

}
