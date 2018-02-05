package com.usp.belluzzi.nbaweb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;
import com.usp.belluzzi.nbaweb.core.KMeansService;


@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private KMeansService kMeansService;
	
	private ObjectMapper mapper = new ObjectMapper(new JsonFactory());
	
	@RequestMapping(value = "/list/offensive", method = RequestMethod.GET)
	public String seeDefensive(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		
		Map<String, StatsSeason> mapa = kMeansService.getKmeansDefensive().getElementos();

		return mapper.writeValueAsString(mapa).toString();
	}
	
	@RequestMapping(value = "/list/defensive", method = RequestMethod.GET)
	public String seeOffensive(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{

		Map<String, StatsSeason> mapa = kMeansService.getKmeansOffensivo().getElementos();

		return mapper.writeValueAsString(mapa).toString();
	}
}
