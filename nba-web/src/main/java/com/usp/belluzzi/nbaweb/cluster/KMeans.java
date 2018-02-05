package com.usp.belluzzi.nbaweb.cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;
import com.usp.belluzzi.nbaweb.cluster.model.Team;
import com.usp.belluzzi.nbaweb.core.Distancia;



public class KMeans {

	static Logger log = Logger.getLogger("kMeans");


	private Map<String, StatsSeason> elementos;

	private List<StatsSeason> kCentros;

	private List<StatsSeason> kCentrosFinais;
	
	private List<StatsSeason> kCentrosIniciais;
	
	private Map<String, StatsSeason> test;
	

	public KMeans (Map<String, StatsSeason> elementos, List<StatsSeason> kCentros, Map<String, StatsSeason> test){

		this.setElementos(elementos);
		this.setkCentros(kCentros);
		this.setkCentrosIniciais(kCentros);
		this.setTest(test);
	}

	public void executarKmeans() {
		Object matrizSistancia [][] = new Object[elementos.size()][kCentros.size() + 3]; 

		double novoErro = 0;
		double erro = 0;
		int interacao = 1;

		do{
			erro = novoErro;
			novoErro = 0;

			int linhaElemento = 0;
			for (StatsSeason values : elementos.values()){
				StatsSeason maisProximo = kCentros.get(0);
				double maisProx = Distancia.euclidiana(maisProximo, values);

				int colunaDistancia = 0;
				for(StatsSeason centros : kCentros){
					double proximo = Distancia.euclidiana(centros, values);
					maisProx = Distancia.euclidiana(maisProximo, values);

					matrizSistancia[linhaElemento][colunaDistancia] = proximo;
					//System.out.print("(" + proximo + " - " + centros.getTeam().getSeason() + ") ");

					if (maisProx > proximo){
						maisProximo = centros;
						//mudou ++;
					}
					values.setGruop(maisProximo.getTeam());
					colunaDistancia++;
				}

				matrizSistancia[linhaElemento][kCentros.size()] = maisProx;

				matrizSistancia[linhaElemento][kCentros.size() + 1] = maisProximo.getTeam();
				matrizSistancia[linhaElemento][kCentros.size() + 2] = values.getTeam();

				novoErro = novoErro + maisProx;
				linhaElemento++;
			}

			//mostrarConteudo(matrizSistancia);



			log.info("Recaucular centros");

			kCentrosFinais = new ArrayList<StatsSeason>();

			int elementosNoCentro = 0;
			for (StatsSeason centros : kCentros){

				List <StatsSeason> lista = getByCentro(centros.getTeam());

				log.info("O cluster iniciado como (" + centros.getTeam().toString() + ") tem " + lista.size() + " elementos");

				StatsSeason avg = Distancia.averageCluster(lista, centros.getTeam(), interacao);
				log.info("A novo centro do cluster ficou em :");
				log.info(avg.toString());

				kCentrosFinais.add(avg);

				elementosNoCentro = elementosNoCentro + lista.size();
				
				/*for (StatsSeason ss : lista){
					System.out.println(ss.getTeam().toString());
				}*/
			}

			kCentros = kCentrosFinais;
			
			showDistancias (kCentros);

			//log.info("Total elementos nos centros " + elementosNoCentro);

			log.info("Distancia do centro (" + novoErro + ")");
			interacao++;
			log.info("");
		}while(erro != novoErro);
	}
	
	public void showDistancias (List<StatsSeason> lista){
		
		for (StatsSeason team : lista){
			for (StatsSeason pivo : lista){
				double dist = Distancia.euclidiana(team, pivo);
				System.out.print(dist + " ");
			}
			System.out.println();
		}
	}

	public List<StatsSeason> getByCentro (Team centro){
		List<StatsSeason> lista = new ArrayList<StatsSeason>();


		for (StatsSeason values : elementos.values()){

			if (values.getGruop().equals(centro)){
				lista.add(values);
			}

		}
		return lista;
	}

	public Map<String, StatsSeason> getElementos() {
		return elementos;
	}

	public void setElementos(Map<String, StatsSeason> elementos) {
		this.elementos = elementos;
	}

	public List<StatsSeason> getkCentros() {
		return kCentros;
	}

	public void setkCentros(List<StatsSeason> kCentros) {
		this.kCentros = kCentros;
	}

	public List<StatsSeason> getkCentrosFinais() {
		return kCentrosFinais;
	}

	public void setkCentrosFinais(List<StatsSeason> kCentrosFinais) {
		this.kCentrosFinais = kCentrosFinais;
	}

	public List<StatsSeason> getkCentrosIniciais() {
		return kCentrosIniciais;
	}

	public void setkCentrosIniciais(List<StatsSeason> kCentrosIniciais) {
		this.kCentrosIniciais = kCentrosIniciais;
	}

	public Map<String, StatsSeason> getTest() {
		return test;
	}

	public void setTest(Map<String, StatsSeason> test) {
		this.test = test;
	}

	
}
