package view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Classe utilit�ria de GridBagConstraints.
 */
public class GBC extends GridBagConstraints {

	/**
	 * Construtor padr�o.
	 *
	 * @param gridx
	 *            x da grade.
	 * @param gridy
	 *            y da grade.
	 */
	public GBC(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.insets = new Insets(2, 2, 2, 2);
	}

	/**
	 * Define a expans�o como horizintal apenas.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC horizontal() {
		this.weightx = 1;
		this.fill = GridBagConstraints.HORIZONTAL;
		return this;
	}

	/**
	 * Define a expans�o como vertical apenas.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC vertical() {
		this.weighty = 1;
		this.fill = GridBagConstraints.VERTICAL;
		return this;
	}

	/**
	 * Define a expans�o para ambos os lados.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC both() {
		this.weightx = 1;
		this.weighty = 1;
		this.fill = GridBagConstraints.BOTH;
		return this;
	}

	/**
	 * Faz merge de linhas e colunas.
	 *
	 * @param w
	 *            N�mero de c�lulas da linha.
	 * @param h
	 *            N�mero de c�lulas da coluna.
	 * @return O pr�prio GBC.
	 */
	public GBC gridwh(int w, int h) {
		this.gridwidth = w;
		this.gridheight = h;
		return this;
	}

	/**
	 * Alinha ao topo.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC top() {
		this.anchor = GridBagConstraints.NORTH;
		return this;
	}

	/**
	 * Alinha na esquerda.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC left() {
		this.anchor = GridBagConstraints.WEST;
		return this;
	}

	/**
	 * Alinha na esquerda.
	 * 
	 * @param weightx
	 *            Peso para deslocar a esquerda.
	 * 
	 * @return O pr�prio GBC.
	 */
	public GBC left(int weightx) {
		this.anchor = GridBagConstraints.WEST;
		this.weightx = weightx;
		return this;
	}

	/**
	 * Alinha na direita.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC right() {
		this.anchor = GridBagConstraints.EAST;
		return this;
	}

	/**
	 * Alinha ao centro.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC center() {
		this.anchor = GridBagConstraints.CENTER;
		return this;
	}

	/**
	 * Define a margem entre a c�lula e o componente.
	 *
	 * @param top
	 *            Margem entre o topo da c�lula e o componente.
	 * @param left
	 *            Margem entre o canto esquerdo da c�lula e o componente.
	 * @param bottom
	 *            Margem entre a base da c�lula e o componente.
	 * @param right
	 *            Margem entre o canto direito da c�lula e o componente.
	 *
	 * @return O pr�prio GBC.
	 */
	public GBC insets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

}
