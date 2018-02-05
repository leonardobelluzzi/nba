package com.usp.belluzzi.nbaweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;
import com.usp.belluzzi.nbaweb.core.Distancia;
import com.usp.belluzzi.nbaweb.core.KMeansService;



@RestController
@RequestMapping("/variation")
public class VariationController {

	@Autowired
	private KMeansService kMeansService; 

	@RequestMapping(value = "/offensive/points", method = RequestMethod.GET)
	public String gruopOffensive(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		JSONObject json = new JSONObject();

		List<StatsSeason> lista = kMeansService.getKmeansOffensivo().getkCentrosFinais();
		
		
		
		for (StatsSeason centro : lista){
			
			JSONObject jsonValores = new JSONObject();
			jsonValores.put("media", Math.round(centro.getPoint() / 82));
			
			
			//aquiiiiiiiiiiiiii
			
			
			double varianciaPoint = Distancia.varianciaPoints (centro, kMeansService.getKmeansOffensivo().getElementos() );
			jsonValores.put("variancia", Math.round(varianciaPoint / 82));
			jsonValores.put("desvio-padrao", Math.round(Math.sqrt(varianciaPoint) / 82));
			
			
			json.put(centro.getTeam().toString(), jsonValores);
		}
		
		

		return json.toString();
	}

	@RequestMapping(value = "/defensive/points", method = RequestMethod.GET)
	public String gruopDefensive(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		JSONObject json = new JSONObject();

		List<StatsSeason> lista = kMeansService.getKmeansDefensive().getkCentrosFinais();
		
		
		
		for (StatsSeason centro : lista){
			
			JSONObject jsonValores = new JSONObject();
			jsonValores.put("media", Math.round(centro.getPoint() / 82));
			
			
			//aquiiiiiiiiiiiiii
			
			
			double varianciaPoint = Distancia.varianciaPoints (centro, kMeansService.getKmeansDefensive().getElementos() );
			jsonValores.put("variancia", Math.round(varianciaPoint / 82));
			jsonValores.put("desvio-padrao", Math.round(Math.sqrt(varianciaPoint) / 82));
			
			
			json.put(centro.getTeam().toString(), jsonValores);
		}
		
		

		return json.toString();
	}

	

}
