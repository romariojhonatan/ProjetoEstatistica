package view;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculoView extends JDialog{

	/** Janela principal do sistema. */
	private MainFrame mainFrame;
	
	private String[] calculos = {  "", "Média de Reservas", "Média de Noites", 
			"Média de Diárias", "Média de Gastos Extras","Média de Gasto Total", 
			"Média de Pessoas", "Média Ocupapação"};
	
	private String[] mes = { "", "Janeiro", "Fevereiro", "Março", "Abril", 
			"Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", 
			"Novembro", "Dezembro"};
	
	private String[] tipocalculo = { "", "Mensal", "Anual", "Periodo"};
	
	private String[] ano = { "", "2017", "2018"};
	
	private JComboBox<String> calculoComboBox;
	
	private JComboBox<String> deComboBox;
	
	private JComboBox<String> ateComboBox;
	
	private JComboBox<String> anoComboBox;
	
	/**
	 * Construtor.
	 * 
	 * @param mainframe
	 * 				Janela principal.
	 */
	public CalculoView(MainFrame mainFrame) {
		build();
	}

	/**
	 * Constroi a Janela.
	 */
	private void build() {
		setLayout(new GridBagLayout());
		buildComponents();
		pack();
		setResizable(false);
		setTitle("Calculos");
		setLocationRelativeTo(mainFrame);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);
	}

	/**
	 * Constrói os componentes da janela.
	 */
	private void buildComponents() {
		primeiraLinha();
		segundaLinha();
	}

	private void primeiraLinha() {
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel jLabel1 = new JLabel("Qual tipo de Qualculo:");
		panel.add(jLabel1, new GBC(0, 0));
		calculoComboBox = new JComboBox<>(calculos);
		panel.add(calculoComboBox, new GBC(1, 0));
		
		JLabel jLabel2 = new JLabel("Tipo de calculo:");
		panel.add(jLabel2, new GBC(2, 0));
		calculoComboBox = new JComboBox<>(tipocalculo);
		panel.add(calculoComboBox, new GBC(3, 0));
		
		add(panel, new GBC(0, 0));
	}

	private void segundaLinha() {
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel jLabel1 = new JLabel("De:");
		panel.add(jLabel1, new GBC(0, 1).right());
		deComboBox = new JComboBox<>(mes);
		panel.add(deComboBox, new GBC(1, 1));
		
		JLabel jLabel2 = new JLabel("Até:");
		panel.add(jLabel2, new GBC(2, 1));
		ateComboBox = new JComboBox<>(mes);
		panel.add(ateComboBox, new GBC(3, 1));
		
		JLabel jLabel3 = new JLabel("Ano:");
		panel.add(jLabel3, new GBC(4, 1));
		anoComboBox = new JComboBox<>(ano);
		panel.add(anoComboBox, new GBC(5, 1));
		
		add(panel, new GBC(0, 1));
	}
	
	

}
