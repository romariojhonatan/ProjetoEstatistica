package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Transacao;
import model.Utility;

public class GestaoTableModel extends DefaultTableModel{

	private String[] columNames = {"Cliente","Quant.Hospedes","check-in","check-out","Quant.Noites","Tipo de Uh","Vl diarias","R$/UH","Gastos extras"};

	private List<Transacao> transacao = new ArrayList<>();
	
	@Override
	public int getColumnCount() {
		return columNames.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Transacao tran = transacao.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return tran.getCliente();
		case 1:
			return tran.getQuantHospedes();
		case 2:
			return tran.getCheckIn();
		case 3:
			return tran.getCheckOut();
		case 4:
			return tran.getQuantNoites();
		case 5:
			return tran.getTipoUh();
		case 6:
			return tran.getValDiaria();
		case 7:
			return tran.getValUh();
		case 8:
			return tran.getValoExtra();
		}
		return "";
	}
	
	@Override
	public String getColumnName(int column) {
		return columNames[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void addTransacao(Transacao tran) {
		transacao.add(tran);
		Object[] tranData = {tran.getCliente(),tran.getQuantHospedes(),tran.getCheckIn(),tran.getCheckOut(),tran.getQuantNoites(),tran.getTipoUh(),tran.getValDiaria(),tran.getValUh(),tran.getValoExtra()};
		this.addRow(tranData);
	}

	public void updateTransacao(Transacao tran, int selectedRow) {
		for (Transacao t: transacao) {
			if (t.equals(tran)) {
				t.setCliente(tran.getCliente()); 
				t.setQuantHospedes(Integer.toString(tran.getQuantHospedes())); 
				t.setCheckIn(Utility.dateToString(tran.getCheckIn())); 
				t.setCheckOut(Utility.dateToString(tran.getCheckOut())); 
				t.setQuantNoites(Integer.toString(tran.getQuantNoites())); 
				t.setTipoUh(tran.getTipoUh()); 
				t.setValDiaria(Integer.toString(tran.getValDiaria())); 
				t.setValUh(Integer.toString(tran.getValUh())); 
				t.setValoExtra(Integer.toString(tran.getValoExtra())); 
			}
		}
		//aqui
				// Falta atualiza o dado da tabela.
				this.setValueAt(tran.getCliente(), selectedRow, 0); // TODO criar
																	// constantes para
																	// isso.
				this.setValueAt(tran.getQuantHospedes(), selectedRow, 1);
		
	}
	
}