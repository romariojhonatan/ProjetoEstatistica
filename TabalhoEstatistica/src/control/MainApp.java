package control;

import java.util.Date;

import model.Transacao;
import model.Utility;
import model.dao.TransacaoDao;
import view.CalculorDialog;
import view.MainFrame;
import view.TransacaoDialog;

public class MainApp {

	public static void main(String[] args) {
		//new TransacaoDialog(null);
		//new CalculoView(null);
		new MainFrame();
	}
}