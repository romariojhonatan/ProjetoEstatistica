package control;

import java.util.Date;

import model.Transacao;
import model.Utility;
import model.dao.TransacaoDao;
import view.MainFrame;

public class Main {

	public static void main(String[] args) {
		
//		TransacaoDao t = TransacaoDao.getInstancia();
//		Transacao t1 = new Transacao("pamela", "456", "09/05/1999", "09/05/2017", "456", "456", "456", "456", "456");
//		
//		t.toPersist(t1);
		
		new MainFrame();
	}
}
