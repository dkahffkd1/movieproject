module movieproject {
	exports member.dao;
	exports login.main;
	exports login.service;
	exports login.controller;
	exports common;
	exports member.main;
	exports member.dto;
	exports member.controller;
	exports login.dao;
	exports member.service;
	exports login.dto;
	exports login.url;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}