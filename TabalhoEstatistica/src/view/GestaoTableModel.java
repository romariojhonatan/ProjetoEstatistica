package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Transacao;
import model.Utility;
import model.dao.TransacaoDao;

public class GestaoTableModel extends DefaultTableModel{

	private Transacao tran;
	
	private String[] columNames = {"Cliente","Quant.Hospedes","check-in","check-out","Quant.Noites","Tipo de Uh","Vl diarias","R$/UH","Gastos extras"};

	private List<Transacao> transacao = new ArrayList<>();
	
	private TransacaoDao trandao;
	
	public GestaoTableModel() {
		//refresh(trandao.searchAll(tran));
	}
	
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
	
	public Transacao getRow(int rowNumber) {
		return transacao.get(rowNumber);
	}

	public void addTransacao(Transacao tran) {
		transacao.add(tran);
		Object[] tranData = {tran.getCliente(),tran.getQuantHospedes(),tran.getCheckIn(),tran.getCheckOut(),tran.getQuantNoites(),tran.getTipoUh(),tran.getValDiaria(),tran.getValUh(),tran.getValoExtra()};
		this.addRow(tranData);
	}
	
	//Não esta atualizando.
	public void updateTransacao(Transacao tran, int selectedRow) {
		for (Transacao t: transacao) {
			if (t.equals(tran)) {
				t.setCliente(tran.getCliente()); 
				t.setQuantHospedes(Integer.toString(tran.getQuantHospedes())); 
				t.setCheckIn(tran.getCheckIn()); 
				t.setCheckOut(tran.getCheckOut()); 
				t.setQuantNoites(Integer.toString(tran.getQuantNoites())); 
				t.setTipoUh(tran.getTipoUh()); 
				t.setValDiaria(Integer.toString(tran.getValDiaria())); 
				t.setValUh(Integer.toString(tran.getValUh())); 
				t.setValoExtra(Integer.toString(tran.getValoExtra())); 
			}
		}
				this.setValueAt(tran.getCliente(), selectedRow, 0); 
				this.setValueAt(tran.getQuantHospedes(), selectedRow, 1); 											
				this.setValueAt(tran.getCheckIn(), selectedRow, 2);
				this.setValueAt(tran.getCheckOut(), selectedRow, 3); 
				this.setValueAt(tran.getQuantNoites(), selectedRow, 4); 
				this.setValueAt(tran.getTipoUh(), selectedRow, 5); 
				this.setValueAt(tran.getValDiaria(), selectedRow, 6); 
				this.setValueAt(tran.getValUh(), selectedRow, 7); 
				this.setValueAt(tran.getValoExtra(), selectedRow, 8); 
	}

	public void removeTransacao(int row) {
		transacao.remove(row);
		this.removeRow(row);
	}
	
	public void refresh(List<Transacao> list){
		for (int i = 0; i < list.size(); i++) {
			
			addTransacao(list.get(1));
			
		}
	}
	
}