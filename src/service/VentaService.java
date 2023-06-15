package service;

import beans.Venta;
import dao.DAOFactory;
import interfaces.VentaDAO;
import utils.Constantes;

public class VentaService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	VentaDAO objVen = fabrica.getVenta();
	
	public String ObtenNumeroDeFactura() {
		return objVen.ObtenerNumeroDeFactura();
	}
	
	public void RegistraVenta(Venta venta) {
		return objVen.RegistrarVenta();
	}
	
	public void GuardaDetalleVenta(Venta venta) {
		return objVen.GuardarDetalleVenta(venta);
	}
	
	public int ObtenMaximoIdVentas() {
		return objVen.ObtenerMaximoIdVentas();
	}
}
