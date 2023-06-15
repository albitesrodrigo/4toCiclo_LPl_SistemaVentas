package interfaces;

import beans.Venta;

public interface VentaDAO {
	
	public String ObtenerNumeroDeFactura();
	public void RegistrarVenta(Venta venta);
	public void GuardarDetalleVenta(Venta venta);
	public int ObtenerMaximoIdVentas();
}
