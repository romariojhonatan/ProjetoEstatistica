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

	public double mediaMensal(Date deDate, int i) {
		System.out.println(model.Utility.dateToString(deDate));
		System.out.println(i);
		return 0;
	}

	public double mediaAnual(Date anoDate, int i) {
		System.out.println(model.Utility.dateToString(anoDate));
		System.out.println(i);		
		return 0;
	}

	public double mediaPeriodo(Date deDate, Date ateDate, int i) {		
		//1 - "Média de Reservas",2 - "Média de Noites", 
		//3 - "Média de Diárias", 4 - "Média de Gastos Extras", 5 - "Média de Gasto Total", 
		//6 - "Média de Pessoas", 7 - "Média Ocupapação"
		
		
		Query query = entity.createQuery("SELECT t FROM Transacao t WHERE t.checkIn BETWEEN :dataInicial AND :dataFinal");
		query.setParameter("dataInicial", Utility.dateToSql(deDate));
		query.setParameter("dataFinal", Utility.dateToSql(ateDate));
		List<Transacao> list = query.getResultList();
		
		long quantidadeDias = (Utility.dateToSql(ateDate).getTime() - Utility.dateToSql(deDate).getTime()) + 3600000;
		quantidadeDias = (quantidadeDias / 86400000L) + 1;
		
		long cont = list.size();
		long soma = 0;
		int quantidadeNoites = 0;
		
		switch (i) {
		//Realiza a media de reserva. Quantidade de reserva dividida pela quantidade de dias
		case 1:
			return cont / quantidadeDias;
		//Realiza a media de quantidade de noites. Quantidade de noites dividida pela quantidade de reserva.
		case 2:
			soma = 0;
			for (int j = 0; j < list.size(); j++) {
				soma += list.get(j).getQuantNoites();
			}
			return soma / cont;
		//Realiza a media de diarias. Valor da diaria vezes quantidade de noites dividido pela quantidade de reserva.
		case 3:
			soma = 0;
			for (int j = 0; j < list.size(); j++) {
				soma += list.get(j).getValUh();
				quantidadeNoites += list.get(j).getQuantNoites();
			}
			return soma / quantidadeNoites;
		case 4:
			soma = 0;
			for (int j = 0; j < list.size(); j++) {
				soma += list.get(j).getValoExtra();
			}
			return soma / quantidadeNoites;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		}
		
		return 0;
	}

}
