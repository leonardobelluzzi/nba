package com.usp.belluzzi.nbaweb.core;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;
import com.usp.belluzzi.nbaweb.cluster.model.Team;


public class Distancia {

	static Logger log = Logger.getLogger("Distancia");

	public static double euclidiana (StatsSeason stats1, StatsSeason stats2){


		double threePointPow = Math.pow((stats1.getThreePoint() - stats2.getThreePoint()), 2);
		double threePointAttemptPow = Math.pow((stats1.getThreePointAttempt() - stats2.getThreePointAttempt()), 2);
		double twoPointPow = Math.pow((stats1.getTwoPoint() - stats2.getTwoPoint()), 2);
		double twoPointAttemptPow = Math.pow((stats1.getTwoPointAttempt() - stats2.getTwoPointAttempt()), 2);
		double freeThrowPow = Math.pow((stats1.getFreeThrow() - stats2.getFreeThrow()), 2);
		double freeThrowAttemptPow = Math.pow((stats1.getFreeThrowAttempt() - stats2.getFreeThrowAttempt()), 2);
		double offensiveReboundPow = Math.pow((stats1.getOffensiveRebound() - stats2.getOffensiveRebound()), 2);
		double defensiveReboundPow = Math.pow((stats1.getDefensiveRebound() - stats2.getDefensiveRebound()), 2);
		double assistPow = Math.pow((stats1.getAssist() - stats2.getAssist()), 2);
		double stealPow = Math.pow((stats1.getSteal() - stats2.getSteal()), 2);
		double blockPow = Math.pow((stats1.getBlock() - stats2.getBlock()), 2);
		double turnoverPow = Math.pow((stats1.getTurnover() - stats2.getTurnover()), 2);
		double personalFoulPow = Math.pow((stats1.getPersonalFoul() - stats2.getPersonalFoul()), 2);
		double pointPow = Math.pow((stats1.getPoint() - stats2.getPoint()), 2);

		double sumPow = threePointPow + threePointAttemptPow + twoPointPow + twoPointAttemptPow + freeThrowPow + 
				freeThrowAttemptPow + offensiveReboundPow + defensiveReboundPow + assistPow + stealPow + blockPow + 
				turnoverPow + personalFoulPow + pointPow;


		double raiz = Math.round(Math.sqrt(sumPow));


		return raiz;
	}

	public static StatsSeason averageCluster (List <StatsSeason> lista, Team centro, int interacao){
		StatsSeason retorno = new StatsSeason();

		int threePoint = 0;
		int threePointAttempt = 0;
		int twoPoint = 0;
		int twoPointAttempt = 0;
		int freeThrow = 0;
		int freeThrowAttempt = 0;
		int offensiveRebound = 0;
		int defensiveRebound = 0;
		int assist = 0;
		int steal = 0;
		int block = 0;
		int turnover = 0;
		int personalFoul = 0;
		int point = 0;


		for (StatsSeason valores : lista){

			//log.info("O time " + valores.getTeam() + " " + ver.getGruop());

			threePoint = (threePoint + valores.getThreePoint());
			threePointAttempt = (threePointAttempt + valores.getThreePointAttempt());
			twoPoint = (twoPoint + valores.getTwoPoint());
			twoPointAttempt = (twoPointAttempt + valores.getTwoPointAttempt());
			freeThrow = (freeThrow + valores.getFreeThrow());
			freeThrowAttempt = (freeThrowAttempt + valores.getFreeThrowAttempt());
			offensiveRebound = (offensiveRebound + valores.getOffensiveRebound());
			defensiveRebound = (defensiveRebound + valores.getDefensiveRebound());
			assist = (assist + valores.getAssist());
			steal = (steal + valores.getSteal());
			block = (block + valores.getBlock());
			turnover = (turnover + valores.getTurnover());
			personalFoul = (personalFoul + valores.getPersonalFoul());
			point = (point + valores.getPoint());

		}

		threePoint = (threePoint / lista.size());
		threePointAttempt = (threePointAttempt / lista.size());
		twoPoint = (twoPoint / lista.size());
		twoPointAttempt = (twoPointAttempt / lista.size());
		freeThrow = (freeThrow / lista.size());
		freeThrowAttempt = (freeThrowAttempt / lista.size());
		offensiveRebound = (offensiveRebound / lista.size());
		defensiveRebound = (defensiveRebound / lista.size());
		assist = (assist / lista.size());
		steal = (steal / lista.size());
		block = (block / lista.size());
		turnover = (turnover / lista.size());
		personalFoul = (personalFoul / lista.size());
		point = (point / lista.size());

		Team team = new Team(centro.getSeason(), centro.getName());

		retorno = new StatsSeason (team, threePoint, threePointAttempt, twoPoint, twoPointAttempt, freeThrow, freeThrowAttempt, offensiveRebound, 
				defensiveRebound, assist, steal, block, turnover, personalFoul, point);


		return retorno;
	}

	public static StatsSeason getCetroidMaisProixmo (List <StatsSeason> centros, StatsSeason pivo){
		double menorDist = Double.MAX_VALUE;
		StatsSeason resp = centros.get(0);
		
		for (StatsSeason centro : centros){
			double pivoDist = euclidiana (centro, pivo);
			
			if (pivoDist < menorDist){
				resp = centro;
				menorDist = pivoDist;
			}
		}
		
		return resp;		
	}
	
	public static void mostrarConteudo(Object [][] matriz){
		log.info("Mostrar matriz de confusao");

		for (int linha = 0; linha < matriz.length; linha++){

			for (int coluna = 0; coluna < matriz[linha].length; coluna++){
				System.out.print(matriz[linha][coluna].toString() + " ");
			}
			System.out.println();
		}
	}

	public static double varianciaPoints (StatsSeason centro, Map<String, StatsSeason> elementos){
		double variancia = 0.0;
		int numeroElemento = 0;
		
		for (StatsSeason st : elementos.values()){
			if (centro.getTeam().toString().equals(st.getGruop().toString())){
				variancia = variancia + Math.pow((st.getPoint() - centro.getPoint()) , 2);
				numeroElemento++;
			}
		}
		
		return (variancia / numeroElemento);
	}

}