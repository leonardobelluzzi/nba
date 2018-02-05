package com.usp.belluzzi.nbaweb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;
import com.usp.belluzzi.nbaweb.core.Distancia;
import com.usp.belluzzi.nbaweb.core.KMeansService;

@RestController
@RequestMapping("/game")
public class GameController {
	/**
	@Autowired
	private KMeansService kMeansService;
	 */

	@Autowired
	private KMeansService KMeansService;

	@RequestMapping(value = "/defensive/stats/{teamHome}/{teamVisti}", method = RequestMethod.GET)
	public String seeDefensiveByKey(@PathVariable("teamVisti") String teamVisti, @PathVariable("teamHome") String teamHome, @RequestHeader HttpHeaders head, HttpServletResponse response){


		Map<String, StatsSeason> defensiveList = KMeansService.getKmeansDefensive().getTest();
		Map<String, StatsSeason> offensiveList = KMeansService.getKmeansOffensivo().getTest();

		StatsSeason defensiveVisit = new StatsSeason();
		StatsSeason offensiveVisit = new StatsSeason();

		StatsSeason defensiveHome = new StatsSeason();
		StatsSeason offensiveHome = new StatsSeason();

		for (StatsSeason st : defensiveList.values()){
			if (st.getTeam().getSeason().equals(teamVisti)){
				defensiveVisit = st;
				break;
			}
		}

		for (StatsSeason st : defensiveList.values()){
			if (st.getTeam().getSeason().equals(teamHome)){
				defensiveHome = st;
				break;
			}
		}

		for (StatsSeason st : offensiveList.values()){
			if (st.getTeam().getSeason().equals(teamVisti)){
				offensiveVisit = st;
				break;
			}
		}

		for (StatsSeason st : offensiveList.values()){
			if (st.getTeam().getSeason().equals(teamHome)){
				offensiveHome = st;
				break;
			}
		}

		StatsSeason centroidDefensiveHome = Distancia.getCetroidMaisProixmo(KMeansService.getKmeansDefensive().getkCentros(), defensiveHome);
		
		StatsSeason centroidOffensiveHome = Distancia.getCetroidMaisProixmo(KMeansService.getKmeansOffensivo().getkCentros(), offensiveHome);

		StatsSeason centroidDefensiveVisit = Distancia.getCetroidMaisProixmo(KMeansService.getKmeansDefensive().getkCentros(), defensiveVisit);
		
		StatsSeason centroidOffensiveVisit = Distancia.getCetroidMaisProixmo(KMeansService.getKmeansOffensivo().getkCentros(), offensiveVisit);


		JSONObject respsota = new JSONObject();
		
		JSONObject cluster = new JSONObject();
		cluster.put("clsuter-defensivo-casa", centroidDefensiveHome.getTeam().toString());
		cluster.put("clsuter-offensivo-casa", centroidOffensiveHome.getTeam().toString());
		cluster.put("clsuter-defensivo-visitante", centroidDefensiveVisit.getTeam().toString());
		cluster.put("clsuter-offensivo-visitante", centroidOffensiveVisit.getTeam().toString());
		respsota.put("clsuter", cluster);

		int mediaOfensivaCasa = Math.round(centroidOffensiveHome.getPoint() / 82);
		int mediaDefensivaCasa = Math.round(centroidDefensiveHome.getPoint() / 82);

		int mediaOfensivaVisistante = Math.round(centroidOffensiveVisit.getPoint() / 82);
		int mediaDefensivaVisitante = Math.round(centroidDefensiveVisit.getPoint() / 82);

		respsota.put("media-ofensiva-casa", mediaOfensivaCasa);
		respsota.put("media-defensiva-casa", mediaDefensivaCasa);

		respsota.put("media-ofensiva-visitante", mediaOfensivaVisistante);
		respsota.put("media-defensiva-visitante", mediaDefensivaVisitante);


		long varianciaOffensivaCasa = Math.round(Distancia.varianciaPoints(centroidOffensiveHome, KMeansService.getKmeansOffensivo().getElementos()));
		long varianciaDefensivaCasa = Math.round(Distancia.varianciaPoints(centroidDefensiveHome, KMeansService.getKmeansDefensive().getElementos()));

		long varianciaOffensivaVisitante = Math.round(Distancia.varianciaPoints(centroidDefensiveVisit, KMeansService.getKmeansDefensive().getElementos()));
		long varianciaDefensivaVisitante = Math.round(Distancia.varianciaPoints(centroidOffensiveVisit, KMeansService.getKmeansOffensivo().getElementos()));



		respsota.put("variancia-ofensiva-casa", varianciaOffensivaCasa);
		respsota.put("variancia-defensiva-casa", varianciaDefensivaCasa);

		respsota.put("variancia-ofensiva-visitante", varianciaOffensivaVisitante);
		respsota.put("variancia-defensiva-visitante", varianciaDefensivaVisitante);


		long desvioPadraoOffensivaCasa = Math.round(Math.sqrt(varianciaOffensivaCasa));
		long desvioPadraoDefensivaCasa = Math.round(Math.sqrt(varianciaDefensivaCasa));

		long desvioPadraoOffensivaVisitante = Math.round(Math.sqrt(varianciaOffensivaVisitante));
		long desvioPadraoDefensivaVisitante = Math.round(Math.sqrt(varianciaDefensivaVisitante));



		respsota.put("desvio-padrao-ofensiva-casa", desvioPadraoOffensivaCasa);
		respsota.put("desvio-padrao-defensiva-casa", desvioPadraoDefensivaCasa);

		respsota.put("desvio-padrao-ofensiva-visitante", desvioPadraoOffensivaVisitante);
		respsota.put("desvio-padrao-defensiva-visitante", desvioPadraoDefensivaVisitante);

		//prevalecimento do fator casa
		long mediaOffensiva = (mediaOfensivaCasa + mediaDefensivaVisitante) / 2;
		long varOffensiva = (desvioPadraoOffensivaCasa + desvioPadraoDefensivaVisitante);
		long menorOffensivo = (mediaOffensiva - varOffensiva);
		long maiorOffensivo = (mediaOffensiva + varOffensiva);
		
		

		String estimativaPontosCasa = "" + menorOffensivo + "/" + mediaOffensiva + "/" + maiorOffensivo;

		long mediaDefensiva = (mediaOfensivaVisistante + mediaDefensivaCasa) / 2;
		long varDefensiva = (desvioPadraoOffensivaVisitante + desvioPadraoDefensivaCasa);
		long menorDefensiva = (mediaDefensiva - varDefensiva);
		long maiorDefensiva = (mediaDefensiva + varDefensiva);

		String estimativaPontosVisitante = "" + menorDefensiva + "/" + mediaDefensiva + "/" + maiorDefensiva;
		
		




		JSONObject resp = new JSONObject();

		resp.put("aux", respsota);

		resp.put(defensiveVisit.getTeam().toString(), estimativaPontosVisitante);

		resp.put(defensiveHome.getTeam().toString(), estimativaPontosCasa);

		return resp.toString();
	}
}
