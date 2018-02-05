package com.usp.belluzzi.nbaweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
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
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private KMeansService kMeansService; 

	private ObjectMapper mapper = new ObjectMapper(new JsonFactory());

	@RequestMapping(value = "/defensive/initial", method = RequestMethod.GET)
	public String seeDefensiveGroupInitial(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{

		List<StatsSeason> lista = kMeansService.getKmeansDefensive().getkCentrosIniciais();


		return mapper.writeValueAsString(lista);
	}

	@RequestMapping(value = "/offensive/initial", method = RequestMethod.GET)
	public String seeOffensiveGroupInitial(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{

		List<StatsSeason> lista = kMeansService.getKmeansOffensivo().getkCentrosIniciais();


		return mapper.writeValueAsString(lista);
	}

	@RequestMapping(value = "/offensive/final", method = RequestMethod.GET)
	public String seeOffensiveGroupFinal(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		List<StatsSeason> lista = kMeansService.getKmeansOffensivo().getkCentrosFinais();


		return mapper.writeValueAsString(lista);
	}

	@RequestMapping(value = "/defensive/final", method = RequestMethod.GET)
	public String seeDefensiveGroupFinal(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		List<StatsSeason> lista = kMeansService.getKmeansDefensive().getkCentrosFinais();


		return mapper.writeValueAsString(lista);
	}

	@RequestMapping(value = "/defensive", method = RequestMethod.GET)
	public String gruopDefensive(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		JSONObject json = new JSONObject();

		Map<String, StatsSeason> elementos = kMeansService.getKmeansDefensive().getElementos();

		
		for (StatsSeason stats : elementos.values()){
			String st = "";
			if (json.has(stats.getGruop().toString())){
				st = json.getString(stats.getGruop().toString());
			}

			
			json.put(stats.getGruop().toString(), stats.getTeam().toString() + ":" + st);
		}
		
		List<StatsSeason> centroFinal = kMeansService.getKmeansDefensive().getkCentrosFinais();
		
		JSONObject resposta = new JSONObject();
		for(StatsSeason stats : centroFinal){
			
			String st = json.getString(stats.getTeam().toString());
			
			String [] matriz = st.split(":");
			
			JSONArray ja = new JSONArray();

			for(String a : matriz){
				ja.put(a);
			}

			resposta.put(stats.getTeam().toString(), ja);			
		}

		return resposta.toString();
	}


	@RequestMapping(value = "/offensive", method = RequestMethod.GET)
	public String gruopOffensive(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		JSONObject json = new JSONObject();

		Map<String, StatsSeason> elementos = kMeansService.getKmeansOffensivo().getElementos();

		for (StatsSeason stats : elementos.values()){
			String st = "";
			if (json.has(stats.getGruop().toString())){
				st = json.getString(stats.getGruop().toString());
			}


			json.put(stats.getGruop().toString(), stats.getTeam().toString() + ":" + st);
		}
		
		List<StatsSeason> centroFinal = kMeansService.getKmeansOffensivo().getkCentrosFinais();
		
		JSONObject resposta = new JSONObject();
		for(StatsSeason stats : centroFinal){
			
			String st = json.getString(stats.getTeam().toString());
			
			String [] matriz = st.split(":");
			
			JSONArray ja = new JSONArray();

			for(String a : matriz){
				ja.put(a);
			}
			
			resposta.put(stats.getTeam().toString(), ja);
		}

		return resposta.toString();
	}

	
	@RequestMapping(value = "/defensive/number", method = RequestMethod.GET)
	public String gruopDefensiveNumber(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		JSONObject json = new JSONObject();

		Map<String, StatsSeason> elementos = kMeansService.getKmeansDefensive().getElementos();

		
		for (StatsSeason stats : elementos.values()){
			String st = "";
			if (json.has(stats.getGruop().toString())){
				st = json.getString(stats.getGruop().toString());
			}

			
			json.put(stats.getGruop().toString(), stats.getTeam().toString() + ":" + st);
		}
		
		List<StatsSeason> centroFinal = kMeansService.getKmeansDefensive().getkCentrosFinais();
		
		JSONObject resposta = new JSONObject();
		for(StatsSeason stats : centroFinal){
			
			String st = json.getString(stats.getTeam().toString());
			
			String [] matriz = st.split(":");

			resposta.put(stats.getTeam().toString(), matriz.length);			
		}

		return resposta.toString();
	}


	@RequestMapping(value = "/offensive/number", method = RequestMethod.GET)
	public String gruopOffensiveNumber(@RequestHeader HttpHeaders head, HttpServletResponse response) throws JsonProcessingException{
		JSONObject json = new JSONObject();

		Map<String, StatsSeason> elementos = kMeansService.getKmeansOffensivo().getElementos();

		for (StatsSeason stats : elementos.values()){
			String st = "";
			if (json.has(stats.getGruop().toString())){
				st = json.getString(stats.getGruop().toString());
			}


			json.put(stats.getGruop().toString(), stats.getTeam().toString() + ":" + st);
		}
		
		List<StatsSeason> centroFinal = kMeansService.getKmeansOffensivo().getkCentrosFinais();
		
		JSONObject resposta = new JSONObject();
		for(StatsSeason stats : centroFinal){
			
			String st = json.getString(stats.getTeam().toString());
			
			String [] matriz = st.split(":");

			resposta.put(stats.getTeam().toString(), matriz.length);
		}

		return resposta.toString();
	}
}
