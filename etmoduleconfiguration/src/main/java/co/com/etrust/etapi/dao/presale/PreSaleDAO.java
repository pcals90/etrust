package co.com.etrust.etapi.dao.presale;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import co.com.etrust.etapi.request.ETMediaReviewDTO;
import co.com.etrust.etapi.request.ETReviewDTO;
import co.com.etrust.etapi.request.ETReviewFiltersDTO;
import co.com.etrust.etapi.request.ETReviewRateDTO;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;

@Repository("presaleServiceDAO")
public class PreSaleDAO implements IPresaleDAO {


	@Override
	public boolean addProductReview(ETReviewDTO review) {

		Session sess = ETDBConnectionManager.getCurrentSession();
		sess.getTransaction();

		Query query = sess
				.createSQLQuery("INSERT INTO et_reviews"
						+ " ( review_et_id,sales_et_id,product_et_id,customer_et_id,review_title,review_comment,"
						+ " product_review,esq_review,satisfaction_review,pros_review,cons_review,best_usage,"
						+ " recommend_firend,buy_again,review_date,review_product_utility,review_type)"
						+ " VALUES"
						+ " (0,"
						+ " 0, "
						+ ":productId,"
						+ " 0,"
						+ " :reviewTitle,"
						+ " :reviewComment,"
						+ " :productReview,"
						+ " :esqReview,"
						+ " :satisfactionReview,"
						+ " :prosReview,"
						+ " :consReview,"
						+ " :bestUsage,"
						+ " :recommendFriend,"
						+ " :buyAgain,"
						+ " :reviewDate,"
						+ " :productUtility,"
						+ " :reviewType)");
		
		query.setInteger("productId",review.getProductId());
		query.setString("reviewTitle",review.getEtTituloCalificacion());
		query.setString("reviewComment",review.getEtComentarioGeneral());
		query.setInteger("productReview",review.getEtCalificacionProducto());
		query.setInteger("esqReview",review.getEtCalificacionServicioCliente());
		query.setInteger("satisfactionReview",review.getEtSatisfaccionGeneral());
		query.setString("prosReview",review.getEtProsProducto());
		query.setString("consReview",review.getEtContrasProducto());
		query.setString("bestUsage",review.getEtMejorasProducto());
		query.setInteger("recommendFriend",review.getEtRecomendarAmigo());
		query.setInteger("buyAgain",review.getEtComprariaDeNuevo());
		query.setDate("reviewDate",new Date());
		query.setInteger("productUtility",review.getEtUtilidadProducto());
		query.setString("reviewType",review.getReviewType());
		
		query.executeUpdate();
		
		if (review.getMediaReview() != null)
		for(ETMediaReviewDTO media : review.getMediaReview()){
		
			Query mediaQuery = sess
					.createSQLQuery("INSERT INTO `prestashop`.`et_media_review` (`review_media_et_id`, `media_type`, `media_file`,"
							+ " `review_et_id`, `sales_et_id`, `product_et_id`, `customer_et_id`) "
							+ " VALUES ("
							+ " 0, "
							+ " :mediaType, "
							+ " :mediaFile, "
							+ " (select max(r.review_et_id) from et_reviews), "
							+ " 0,"
							+ " :prodctId,"
							+ " 0)");
			
			query.setString("mediaType", media.getMediaType());
			query.setBinary("mediaFile", media.getFile());
			query.setInteger("productId", review.getProductId());
			
			mediaQuery.executeUpdate();
		}
		
		return true;
	}

	@Override
	public List<ETReviewDTO> getProductReview(ETReviewFiltersDTO filters) {
		
		Session sess = ETDBConnectionManager.getCurrentSession();
		sess.getTransaction();

		String queryString = "SELECT r.review_et_id as reviewId, "
				+ " r.review_title as etTituloCalificacion, "
				+ " r.review_comment as etComentarioGeneral, "
				+ " r.product_review as etCalificacionProducto,"
				+ " r.esq_review as etCalificacionServicioCliente,"
				+ " r.satisfaction_review as etSatisfaccionGeneral, "
				+ " r.pros_review as etProsProducto, "
				+ " r.cons_review as etContrasProducto,"
				+ " r.best_usage as etMejorasProducto, "
				+ "	r.recommend_firend as etRecomendarAmigo, "
				+ " r.buy_again as etComprariaDeNuevo, CAST(r.review_date as CHAR) as reviewDate, r.review_product_utility as etUtilidadProducto, "
				+ "	r.review_type as reviewType, r.reviewCalification as reviewCalification"
				+ " FROM et_reviews r"
				+ " WHERE r.product_et_id = :productId";
		
		
		Query query = sess
				.createSQLQuery(queryString).setInteger("productId", filters.getProductId())
				.setResultTransformer(Transformers.aliasToBean(ETReviewDTO.class));
		
		List<ETReviewDTO> reviews = query.list();

		for (ETReviewDTO review : reviews) {
			
			Query mediaQuery = sess
					.createSQLQuery(
							"SELECT mr.media_type as mediaType, mr.media_file as file "
							+ " FROM et_media_review mr "
							+ " WHERE review_et_id = :reviewId").setInteger("reviewId", review.getReviewId())
					.setResultTransformer(Transformers.aliasToBean(ETMediaReviewDTO.class));
			
			review.setMediaReview(mediaQuery.list());
		}
		
		return reviews;
		
	}

	@Override
	public Boolean getProductReview(ETReviewRateDTO rate) {
		
		Session sess = ETDBConnectionManager.getCurrentSession();
		sess.getTransaction();

		String querySelect = "SELECT et.reviewCalification from et_reviews et WHERE et.review_et_id = :reviewId";
		
		Query q = sess.createSQLQuery(querySelect).setInteger("reviewId", rate.getReviewId());
		List ret = q.list();
		Integer rating = (Integer)ret.get(0);
		
		Query query = sess.createSQLQuery("UPDATE et_reviews rev SET reviewCalification = "
				+ ":rate+:rating "
				+ "WHERE review_et_id = :reviewId").
				setInteger("reviewId", rate.getReviewId()).
				setInteger("rating", rating).
				setInteger("rate", rate.getRate());
		
		return query.executeUpdate() > 0;
		
		
	}

	

}
