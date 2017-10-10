package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {

	private String cliente;
	
	private int quantHospedes;
	
	private Date checkIn;
	
	private Date checkOut;
	
	private int quantNoites;
	
	private String tipoUh;
	
	private int valDiaria;
	
	private int valUh;
	
	private int valoExtra;
	
	/** Formatador da Date*/
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		Date dateFormated = null;
		try {
			dateFormated = sdf.parse(checkIn);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		Date dateFormated = null;
		try {
			dateFormated = sdf.parse(checkOut);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

}
