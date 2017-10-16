package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Transacao;
import model.dao.TransacaoDao;

/**
 * 
 * @author Rom�rio
 *
 *Janela principal do sistema.
 */
public class MainFrame extends JFrame{

	/** Tabela que aprensentara os dados. */
	private JTable table;

	private TransacaoDao trandao = TransacaoDao.getInstancia();
	
	/**
	 * Construtor.
	 */
	public MainFrame() {
		build();
	}

	/**
	 * Constr�i a janela.
	 */
	private void build() {
		setLayout(new GridBagLayout());
		setTitle("Gest�o de Pousada");
		buildComponents();
		setSize(1100, 600);
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	/**
	 * Constr�i os componentes da janela.
	 */
	private void buildComponents() {
		buildMainPanel();
		buildButtonPanel();
	}

	/**
	 * Constr�i o painel de bot�es.
	 */
	private void buildButtonPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		JButton newButton = new JButton("Novo");
		panel.add(newButton, new GBC(0, 0).horizontal());
		newButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new transacaoDialog(MainFrame.this);
			}
		});

		JButton editButton = new JButton("Alterar");
		panel.add(editButton, new GBC(0, 1));
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				GestaoTableModel model = (GestaoTableModel) table.getModel();
				Transacao tran = model.getRow(selectedRow);
				new transacaoDialog(MainFrame.this, tran, table.getSelectedRow());
			}
		});

		JButton deleteButton = new JButton("Excluir");
		panel.add(deleteButton, new GBC(0, 2));
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				GestaoTableModel model = (GestaoTableModel) table.getModel();
				Transacao tran = model.getRow(selectedRow);
				excluiTransacao(tran, table.getSelectedRow());
			}
		});

		add(panel, new GBC(1, 0));
	}

	/**
	 * Constr�i o painel principal.
	 */
	private void buildMainPanel() {
		JPanel panel = new JPanel(new GridBagLayout());

		String[] items = { "Nome", "Data" };
		JComboBox<String> comboBox = new JComboBox<>(items);
		panel.add(comboBox, new GBC(0, 0));

		JTextField searchField = new JTextField(20);
		panel.add(searchField, new GBC(1, 0).horizontal());

		buildTable(panel);

		add(panel, new GBC(0, 0).both().insets(10, 5, 5, 0));
	}

	/**
	 * Constr�i a tabela.
	 * 
	 * @param panel
	 *            Painel principal.
	 */
	private void buildTable(JPanel panel) {
		table = new JTable();
		table.setModel(new GestaoTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, new GBC(0, 1).gridwh(2, 1).both());
	}

	/**
	 * Atualiza os dados da transa��o.
	 * 
	 * @param transacao
	 * @param selectedRow
	 */
	public void updateTransacao(Transacao t, int selectedRow) {
		GestaoTableModel model = (GestaoTableModel) table.getModel();
		trandao.update(t);
		model.updateTransacao(t, selectedRow);
	}

	/**
	 * Adiciona uma transa��o.
	 * 
	 * @param transacao
	 */
	public void addTransacao(Transacao t) {	
		GestaoTableModel model = (GestaoTableModel) table.getModel();
		trandao.toPersist(t);
		model.addTransacao(t);
	}
	
	/**
	 * Exclui uma transa��o
	 * 
	 * @param tran
	 * @param row
	 */
	private void excluiTransacao(Transacao t, int row) {
		GestaoTableModel model = (GestaoTableModel) table.getModel();
		trandao.remove(t);
		model.removeTransacao(row);
	}
}

