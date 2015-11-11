package co.com.etrust.etapi.request;

import java.util.List;

public class ETReviewDTO {

	private int saleId;
	private int productId;
	private int customerId;
	
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
	
	public String getReviewDate() {
		return reviewDate;
	}





	public int getReviewCalification() {
		return reviewCalification;
	}





	public void setReviewCalification(int reviewCalification) {
		this.reviewCalification = reviewCalification;
	}





	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}





	private int reviewId;
	
	private List<ETMediaReviewDTO> mediaReview;
	
	
	


	public int getSaleId() {
		return saleId;
	}





	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}





	public int getProductId() {
		return productId;
	}





	public void setProductId(int productId) {
		this.productId = productId;
	}





	public int getCustomerId() {
		return customerId;
	}





	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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





	public int getReviewId() {
		return reviewId;
	}





	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}





	public List<ETMediaReviewDTO> getMediaReview() {
		return mediaReview;
	}





	public void setMediaReview(List<ETMediaReviewDTO> mediaReview) {
		this.mediaReview = mediaReview;
	}





	@Override
	public String toString() {
		return "ETReviewDTO [saleId=" + saleId + ", productId=" + productId + ", customerId=" + customerId
				+ ", etTituloCalificacion=" + etTituloCalificacion + ", etComentarioGeneral=" + etComentarioGeneral
				+ ", etCalificacionProducto=" + etCalificacionProducto + ", etCalificacionServicioCliente="
				+ etCalificacionServicioCliente + ", etSatisfaccionGeneral=" + etSatisfaccionGeneral
				+ ", etProsProducto=" + etProsProducto + ", etContrasProducto=" + etContrasProducto
				+ ", etMejorasProducto=" + etMejorasProducto + ", etRecomendarAmigo=" + etRecomendarAmigo
				+ ", etComprariaDeNuevo=" + etComprariaDeNuevo + ", etUtilidadProducto=" + etUtilidadProducto
				+ ", reviewType=" + reviewType + ", reviewDate=" + reviewDate + ", reviewId=" + reviewId
				+ ", mediaReview=" + mediaReview + "]";
	}
	
	
	
}
