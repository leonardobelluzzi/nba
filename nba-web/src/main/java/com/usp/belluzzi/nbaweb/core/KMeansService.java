package com.usp.belluzzi.nbaweb.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.usp.belluzzi.nbaweb.cluster.KMeans;
import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;
import com.usp.belluzzi.nbaweb.cluster.model.Team;

@Service
public class KMeansService{

	Logger log = Logger.getLogger("ClusterKmeans");

	private KMeans kmeansOffensivo;
	
	private KMeans kmeansDefensive;

	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		try {
			
			

			log.info("Vamos iniciar a Leitrua dos arquivos ");
			
			
			String fileOffensive = "offensive.csv";
			
			log.info("Vamos iniciar a Leitrua dos arquivos");
			String fileDefensive = "defensive.CSV";
			
			log.info("Vamos iniciar a Leitrua dos arquivos teste");
			String fileTestDefensiveString = "temp1617.CSV";
			
			log.info("Vamos iniciar a Leitrua dos arquivos teste");
			String fileTestOffensiveString = "temp1617O.CSV";
			

			//OFFENSIVO
			log.info("Ofensivo - dados no arquivo (" + fileOffensive + ")");
			Map<String, StatsSeason> hashOfenssive = ReadArchive.hardCodeOfffensive();
			
			log.info("Ofensivo - dados no arquivo (" + fileDefensive + ")");
			Map<String, StatsSeason> hashDefensive = ReadArchive.hardCodeDefensive();
			
			log.info("Ofensivo - dados no arquivo (" + fileOffensive + ")");
			Map<String, StatsSeason> hashOfenssiveTest = ReadArchive.testeOfensivo();
			
			log.info("Ofensivo - dados no arquivo (" + fileDefensive + ")");
			Map<String, StatsSeason> hashDefensiveTest = ReadArchive.testeDefensivo();

			//CENTROOFFENSIVO
			log.info("Vamos iniciar os Arquivo de centro");
			List<StatsSeason> centroOffenssive = centroTimesOffenssive (hashOfenssive);

			//AGRUPAR VALORES
			kmeansOffensivo = new KMeans(hashOfenssive, centroOffenssive, hashOfenssiveTest);
			
			kmeansOffensivo.executarKmeans();
			
			
			//CENTROOFFENSIVO
			log.info("Vamos iniciar os Arquivo de centro");
			List<StatsSeason> centroDefensive = centroTimesDefensive (hashDefensive);
			
			//AGRUPAR VALORES
			kmeansDefensive = new KMeans(hashDefensive, centroDefensive, hashDefensiveTest);
			
			kmeansDefensive.executarKmeans();
			
			//log.info(");
			
			log.info("terminar");
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<StatsSeason> centroTimesOffenssive(Map<String, StatsSeason> hashOfenssive) {
		log.info("Buscar times campeao temporada Regular");
		List<StatsSeason> lista = new ArrayList<StatsSeason>();

		Team team1516 = new Team("15/16", "Golden State Warriors");
		Team team1415 = new Team("14/15", "Golden State Warriors");
		Team team1314 = new Team("13/14", "Los Angeles Clippers");
		Team team1213 = new Team("12/13", "Denver Nuggets");
		//Team team1112 = new Team("11/12", "Miami Heat");
		Team team1011 = new Team("10/11", "Denver Nuggets");
		Team team0910 = new Team("09/10", "Phoenix Suns");
		Team team0809 = new Team("08/09", "Phoenix Suns");
		Team team0708 = new Team("07/08", "Golden State Warriors");
		Team team0607 = new Team("06/07", "Phoenix Suns");
		Team team0506 = new Team("05/06", "Phoenix Suns");
		
		log.info("Campeao ofensivo da temporada 15/16 (" + team1516.toString() + ")");
		lista.add(hashOfenssive.get(team1516.toString()));
		
		log.info("Campeao ofensivo da temporada 14/15 (" + team1415.toString() + ")");
		lista.add(hashOfenssive.get(team1415.toString()));
		
		log.info("Campeao ofensivo da temporada 13/14 (" + team1314.toString() + ")");
		lista.add(hashOfenssive.get(team1314.toString()));
		
		log.info("Campeao ofensivo da temporada 12/13 (" + team1213.toString() + ")");
		lista.add(hashOfenssive.get(team1213.toString()));
		
		/*log.info("Campeao da temporada 11/12 (" + team1112.toString() + ")");
		lista.add(hashOfenssive.get(team1112.toString()));*/
		
		log.info("Campeao ofensivo da temporada 10/11 (" + team1011.toString() + ")");
		lista.add(hashOfenssive.get(team1011.toString()));
		
		log.info("Campeao ofensivo da temporada 09/10 (" + team0910.toString() + ")");
		lista.add(hashOfenssive.get(team0910.toString()));
		
		log.info("Campeao ofensivo da temporada 08/09 (" + team0809.toString() + ")");
		lista.add(hashOfenssive.get(team0809.toString()));
		
		log.info("Campeao ofensivo da temporada 07/08 (" + team0708.toString() + ")");
		lista.add(hashOfenssive.get(team0708.toString()));
		
		log.info("Campeao offensivo da temporada 06/07 (" + team0607.toString() + ")");
		lista.add(hashOfenssive.get(team0607.toString()));
		
		log.info("Campeao ofensivo da temporada 05/06 (" + team0506.toString() + ")");
		lista.add(hashOfenssive.get(team0506.toString()));

		
		

		return lista;
	}
	
	private List<StatsSeason> centroTimesDefensive(Map<String, StatsSeason> hashOfenssive) {
		log.info("Buscar times campeao temporada Regular");
		List<StatsSeason> lista = new ArrayList<StatsSeason>();

		Team team1516 = new Team("15/16", "San Antonio Spurs");
		Team team1415 = new Team("14/15", "Utah Jazz");
		Team team1314 = new Team("13/14", "Chicago Bulls");
		Team team1213 = new Team("12/13", "Memphis Grizzlies");
		//Team team1112 = new Team("11/12", "Miami Heat");
		Team team1011 = new Team("10/11", "Boston Celtics");
		Team team0910 = new Team("09/10", "Charlotte Bobcats/Hornets");
		Team team0809 = new Team("08/09", "Cleveland Cavaliers");
		Team team0708 = new Team("07/08", "Detroit Pistons");
		Team team0607 = new Team("06/07", "San Antonio Spurs");
		Team team0506 = new Team("05/06", "Memphis Grizzlies");
		
		log.info("Campeao defensivos da temporada 15/16 (" + team1516.toString() + ")");
		lista.add(hashOfenssive.get(team1516.toString()));
		
		log.info("Campeao defensivos da temporada 14/15 (" + team1415.toString() + ")");
		lista.add(hashOfenssive.get(team1415.toString()));
		
		log.info("Campeao defensivos da temporada 13/14 (" + team1314.toString() + ")");
		lista.add(hashOfenssive.get(team1314.toString()));
		
		log.info("Campeao defensivos da temporada 12/13 (" + team1213.toString() + ")");
		lista.add(hashOfenssive.get(team1213.toString()));
		
		/*log.info("Campeao da temporada 11/12 (" + team1112.toString() + ")");
		lista.add(hashOfenssive.get(team1112.toString()));*/
		
		log.info("Campeao defensivos da temporada 10/11 (" + team1011.toString() + ")");
		lista.add(hashOfenssive.get(team1011.toString()));
		
		log.info("Campeao defensivos da temporada 09/10 (" + team0910.toString() + ")");
		lista.add(hashOfenssive.get(team0910.toString()));
		
		log.info("Campeao defensivos da temporada 08/09 (" + team0809.toString() + ")");
		lista.add(hashOfenssive.get(team0809.toString()));
		
		log.info("Campeao defensivos da temporada 07/08 (" + team0708.toString() + ")");
		lista.add(hashOfenssive.get(team0708.toString()));
		
		log.info("Campeao defensivos da temporada 06/07 (" + team0607.toString() + ")");
		lista.add(hashOfenssive.get(team0607.toString()));
		
		log.info("Campeao defensivos da temporada 05/06 (" + team0506.toString() + ")");
		lista.add(hashOfenssive.get(team0506.toString()));
		
		
		return lista;
	}

	public KMeans getKmeansOffensivo() {
		return kmeansOffensivo;
	}

	public void setKmeansOffensivo(KMeans kmeansOffensivo) {
		this.kmeansOffensivo = kmeansOffensivo;
	}

	public KMeans getKmeansDefensive() {
		return kmeansDefensive;
	}

	public void setKmeansDefensive(KMeans kmeansDefensive) {
		this.kmeansDefensive = kmeansDefensive;
	}
}
