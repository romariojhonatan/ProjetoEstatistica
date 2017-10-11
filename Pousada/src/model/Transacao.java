package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transacao {

	@Id
	private int idTransacao;
	
	@Column
	private String cliente;
	
	@Column
	private int quantHospedes;
	
	@Column
	private Date checkIn;
	
	@Column
	private Date checkOut;
	
	@Column
	private int quantNoites;
	
	@Column
	private String tipoUh;
	
	@Column
	private int valDiaria;
	
	@Column
	private int valUh;
	
	@Column
	private int valoExtra;
	
	public Transacao(String cliente, String quantHospedes, String checkIn, String checkOut, String quantNoites, String tipoUh,
			String valDiaria, String valUh, String valoExtra) {
		super();
		this.cliente = cliente;
		setQuantHospedes(quantHospedes);
		setCheckIn(checkIn);
		setCheckOut(checkOut);
		setQuantNoites(quantNoites);
		this.tipoUh = tipoUh;
		setValDiaria(valDiaria);
		setValUh(valUh);
		setValoExtra(valoExtra);
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getQuantHospedes() {
		return quantHospedes;
	}

	public void setQuantHospedes(String quantHospedes) {
		this.quantHospedes = Integer.parseInt(quantHospedes);
	}

	public String getCheckIn() {
		return Utility.dateToString(checkIn);
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = Utility.stringToDate(checkIn);
	}

	public String getCheckOut() {
		return Utility.dateToString(checkOut);
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = Utility.stringToDate(checkOut);
	}

	public Date getCheckIn1() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut1() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public int getQuantNoites() {
		return quantNoites;
	}

	public void setQuantNoites(String quantNoites) {
		this.quantNoites = Integer.parseInt(quantNoites);
	}

	public String getTipoUh() {
		return tipoUh;
	}

	public void setTipoUh(String tipoUh) {
		this.tipoUh = tipoUh;
	}

	public int getValDiaria() {
		return valDiaria;
	}

	public void setValDiaria(String valDiaria) {
		this.valDiaria = Integer.parseInt(valDiaria);
	}

	public int getValUh() {
		return valUh;
	}

	public void setValUh(String valUh) {
		this.valUh = Integer.parseInt(valUh);
	}

	public int getValoExtra() {
		return valoExtra;
	}

	public void setValoExtra(String valoExtra) {
		this.valoExtra = Integer.parseInt(valoExtra);
	}

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
	
	
	
}
