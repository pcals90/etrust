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
		query.setString("reviewTitle",review.getTitleReview());
		query.setString("reviewComment",review.getReviewComment());
		query.setInteger("productReview",review.getProductReview());
		query.setInteger("esqReview",review.getEsqReview());
		query.setInteger("satisfactionReview",review.getSatisfactionReview());
		query.setString("prosReview",review.getProsReview());
		query.setString("consReview",review.getConsReview());
		query.setString("bestUsage",review.getBestUsageReview());
		query.setInteger("recommendFriend",review.getRecommendFriend());
		query.setInteger("buyAgain",review.getBuyAgain());
		query.setDate("reviewDate",new Date());
		query.setInteger("productUtility",review.getProductUtility());
		query.setString("reviewType",review.getReviewType());
		
		query.executeUpdate();
		
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

		String queryString = "SELECT r.review_et_id r.reviewTitle, r.reviewComment, r.productReview, r.esqReview, r.satisfactionReview, r.prosReview, r.consReview,"
				+ " r.bestUsage, r.recommendFriend, r.buyAgain, r.reviewDate, r.productUtility, r.reviewType, r.reviewCalification"
				+ " FROM et_reviews r"
				+ " WHERE r.product_et_id = :productId";
		
		
		Query query = sess
				.createSQLQuery(queryString).setInteger("productId", filters.getProductId())
				.setResultTransformer(Transformers.aliasToBean(ETReviewDTO.class));
		
		List<ETReviewDTO> reviews = query.list();

		for (ETReviewDTO review : reviews) {
			
			Query mediaQuery = sess
					.createSQLQuery(
							"SELECT mr "
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

		Query query = sess.createQuery("UPDATE et_reviews SET reviewCalification = "
				+ "(:rate+(SELECT reviewCalification from et_reviews WHERE review_et_id = :reviewId)) "
				+ "WHERE review_et_id = :reviewId").
				setInteger("reviewId", rate.getReviewId()).
				setInteger("rate", rate.getRate());
		
		return query.executeUpdate() > 0;
		
		
	}

	

}
