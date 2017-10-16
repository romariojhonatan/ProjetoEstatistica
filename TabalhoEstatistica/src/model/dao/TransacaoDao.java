package model.dao;

import java.util.List;

import model.Transacao;

public class TransacaoDao extends DaoGenerico<Transacao>{

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
	
	public void update(Transacao t) {
		// TODO Auto-generated method stub
		super.update(t);
	}
	
	private void remo() {
		// TODO Auto-generated method stub

	}
	
	public void toPersist(Transacao t) {
		// TODO Auto-generated method stub
		super.toPersist(t);
	}
	
	@Override
	public List<Transacao> searchAll(Transacao t) {
		// TODO Auto-generated method stub
		return super.searchAll(t);
	}
}
