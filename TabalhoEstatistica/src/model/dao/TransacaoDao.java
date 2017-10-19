package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Transacao;
import model.Utility;

public class TransacaoDao extends DaoGenerico<Transacao>{

	private EntityManager entity = getEntityManager();
	
	private static TransacaoDao instancia;

	private TransacaoDao() {
		
	}

	public static TransacaoDao getInstancia() {

		if (instancia == null) {
			instancia = new TransacaoDao();
			return instancia;
		} else {
			return instancia;
		}
	}
	
	public List<Transacao> searchAll() {
		return entity.createQuery("FROM Transacao t").getResultList();
	}

	public static double mediaMensal(Date deDate, int i) {
		System.out.println(model.Utility.dateToString(deDate));
		System.out.println(i);
		return 0;
	}

	public static double mediaAnual(Date anoDate, int i) {
		System.out.println(model.Utility.dateToString(anoDate));
		System.out.println(i);		
		return 0;
	}

	public static double mediaPeriodo(Date deDate, Date ateDate, int i) {		
		//1 - "Média de Reservas",2 - "Média de Noites", 
		//3 - "Média de Diárias", 4 - "Média de Gastos Extras", 5 - "Média de Gasto Total", 
		//6 - "Média de Pessoas", 7 - "Média Ocupapação"
		
		/*
		Query query = entity.createQuery("SELECT t FROM Transacao t WHERE t.checkIn BETWEEN :dataInicial AND :dataFinal");
		System.out.println(query);
		query.setParameter("dataInicial", Utility.dateToSql(deDate));
		query.setParameter("dataFinal", Utility.dateToSql(ateDate));
		List<Transacao> list = query.getResultList();
		
		double cont = list.size() + 1;
		double soma = 0;
		
		switch (i) {
		case 1:
			return cont;
		case 2:
			soma = 0;
			for (int j = 0; j < list.size(); j++) {
				soma = soma + list.get(i).getQuantNoites();
			}
			return soma / cont;
		case 3:
			soma = 0;
			for (int j = 0; j < list.size(); j++) {
				soma = soma + list.get(i).getValDiaria();
			}
			return soma / cont;
		case 4:
			soma = 0;
			for (int j = 0; j < list.size(); j++) {
				soma = soma + list.get(i).getValoExtra();
			}
			return soma / cont;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		}
		*/
		return 0;
	}

}
