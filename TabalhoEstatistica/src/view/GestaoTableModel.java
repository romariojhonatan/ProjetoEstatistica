package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Transacao;
import model.Utility;
import model.dao.TransacaoDao;

/**
 * Classe responsavel por monta a tabela.
 * 
 * @author rjmlopes
 *
 */
public class GestaoTableModel extends DefaultTableModel{
	
	/*Array de string responsavel pelo nome das colulas da tabela*/
	private String[] columNames = {"Cliente","Quant.Hospedes","check-in","check-out","Quant.Noites","Tipo de Uh","Vl diarias","R$/UH","Gastos extras"};

	/*ArrayList de Transacao*/
	private List<Transacao> transacao = new ArrayList<>();
	
	/*Construtor de TransacaoDao*/
	private TransacaoDao trandao = TransacaoDao.getInstancia();
	
	/**
	 * Construtor de GestaoTableModel chamando por padr�o o metodo reflesh,
	 */
	public GestaoTableModel() {
		refresh(trandao.searchAll());
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

	/**
	 * Metodo responsavel pela adi��o de linha na tabela
	 * 
	 * @param tran
	 */
	public void addTransacao(Transacao tran) {
		transacao.add(tran);
		Object[] tranData = {tran.getCliente(),tran.getQuantHospedes(),tran.getCheckIn(),tran.getCheckOut(),tran.getQuantNoites(),tran.getTipoUh(),tran.getValDiaria(),tran.getValUh(),tran.getValoExtra()};
		this.addRow(tranData);
	}
	
	/**
	 * Metodo responsavel pela atualiza��o de linha na tabela
	 * 
	 * @param tran
	 * @param selectedRow
	 */
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

	/**
	 * Metodo responsavel pela exclus�o de linha da tabela
	 * 
	 * @param row
	 */
	public void removeTransacao(int row) {
		transacao.remove(row);
		this.removeRow(row);
	}
	
	/**
	 * Metodo responsavel pela atualiza��o da tabela junto ao banco.
	 * 
	 * @param list
	 */
	public void refresh(List<Transacao> list){
		for (int i = 0; i < list.size(); i++) {
			
			addTransacao(list.get(i));
			
		}
	}
	
}