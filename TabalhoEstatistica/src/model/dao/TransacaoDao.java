package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Transacao;

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

	public static double mediaMensal(Date deDate, String string) {
		System.out.println(model.Utility.dateToString(deDate));
		System.out.println(string);
		return 0;
	}

	public static double mediaAnual(Date anoDate, String string) {
		System.out.println(model.Utility.dateToString(anoDate));
		System.out.println(string);		
		return 0;
	}

	public static double mediaPeriodo(Date deDate, Date ateDate, String string) {
		System.out.println(model.Utility.dateToString(deDate));
		System.out.println(model.Utility.dateToString(ateDate));
		System.out.println(string);	
		return 0;
	}



}
