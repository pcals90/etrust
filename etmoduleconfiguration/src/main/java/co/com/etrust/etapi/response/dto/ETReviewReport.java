package co.com.etrust.etapi.response.dto;

import java.util.HashMap;
import java.util.Map;

public class ETReviewReport {

	private Map<String,String> ecommerceInfo;
	
	private int reviewId;
	
	private String etTituloCalificacion;
	private String etComentarioGeneral;
	private int etCalificacionProducto;
	private int etCalificacionServicioCliente;
	private int etSatisfaccionGeneral;
	private String etProsProducto;
	private String etContrasProducto;
	private String etMejorasProducto;
	private int etRecomendarAmigo;
	private int etComprariaDeNuevo;
	private int etUtilidadProducto;
	private String reviewType;
	private String reviewDate;
	private int reviewCalification;
	
	public ETReviewReport(){
		ecommerceInfo = new HashMap<String,String>();
	}

	public Map<String, String> getEcommerceInfo() {
		return ecommerceInfo;
	}

	public void setEcommerceInfo(Map<String, String> ecommerceInfo) {
		this.ecommerceInfo = ecommerceInfo;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getEtTituloCalificacion() {
		return etTituloCalificacion;
	}

	public void setEtTituloCalificacion(String etTituloCalificacion) {
		this.etTituloCalificacion = etTituloCalificacion;
	}

	public String getEtComentarioGeneral() {
		return etComentarioGeneral;
	}

	public void setEtComentarioGeneral(String etComentarioGeneral) {
		this.etComentarioGeneral = etComentarioGeneral;
	}

	public int getEtCalificacionProducto() {
		return etCalificacionProducto;
	}

	public void setEtCalificacionProducto(int etCalificacionProducto) {
		this.etCalificacionProducto = etCalificacionProducto;
	}

	public int getEtCalificacionServicioCliente() {
		return etCalificacionServicioCliente;
	}

	public void setEtCalificacionServicioCliente(int etCalificacionServicioCliente) {
		this.etCalificacionServicioCliente = etCalificacionServicioCliente;
	}

	public int getEtSatisfaccionGeneral() {
		return etSatisfaccionGeneral;
	}

	public void setEtSatisfaccionGeneral(int etSatisfaccionGeneral) {
		this.etSatisfaccionGeneral = etSatisfaccionGeneral;
	}

	public String getEtProsProducto() {
		return etProsProducto;
	}

	public void setEtProsProducto(String etProsProducto) {
		this.etProsProducto = etProsProducto;
	}

	public String getEtContrasProducto() {
		return etContrasProducto;
	}

	public void setEtContrasProducto(String etContrasProducto) {
		this.etContrasProducto = etContrasProducto;
	}

	public String getEtMejorasProducto() {
		return etMejorasProducto;
	}

	public void setEtMejorasProducto(String etMejorasProducto) {
		this.etMejorasProducto = etMejorasProducto;
	}

	public int getEtRecomendarAmigo() {
		return etRecomendarAmigo;
	}

	public void setEtRecomendarAmigo(int etRecomendarAmigo) {
		this.etRecomendarAmigo = etRecomendarAmigo;
	}

	public int getEtComprariaDeNuevo() {
		return etComprariaDeNuevo;
	}

	public void setEtComprariaDeNuevo(int etComprariaDeNuevo) {
		this.etComprariaDeNuevo = etComprariaDeNuevo;
	}

	public int getEtUtilidadProducto() {
		return etUtilidadProducto;
	}

	public void setEtUtilidadProducto(int etUtilidadProducto) {
		this.etUtilidadProducto = etUtilidadProducto;
	}

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewCalification() {
		return reviewCalification;
	}

	public void setReviewCalification(int reviewCalification) {
		this.reviewCalification = reviewCalification;
	}

	@Override
	public String toString() {
		return "ETReviewReport [ecommerceInfo=" + ecommerceInfo + ", reviewId=" + reviewId + ", etTituloCalificacion="
				+ etTituloCalificacion + ", etComentarioGeneral=" + etComentarioGeneral + ", etCalificacionProducto="
				+ etCalificacionProducto + ", etCalificacionServicioCliente=" + etCalificacionServicioCliente
				+ ", etSatisfaccionGeneral=" + etSatisfaccionGeneral + ", etProsProducto=" + etProsProducto
				+ ", etContrasProducto=" + etContrasProducto + ", etMejorasProducto=" + etMejorasProducto
				+ ", etRecomendarAmigo=" + etRecomendarAmigo + ", etComprariaDeNuevo=" + etComprariaDeNuevo
				+ ", etUtilidadProducto=" + etUtilidadProducto + ", reviewType=" + reviewType + ", reviewDate="
				+ reviewDate + ", reviewCalification=" + reviewCalification + "]";
	}

	
	
	
	
}
