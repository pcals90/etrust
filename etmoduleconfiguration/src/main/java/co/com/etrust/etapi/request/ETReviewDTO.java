package co.com.etrust.etapi.request;

import java.util.List;

public class ETReviewDTO {

	private int saleId;
	private int productId;
	private int customerId;
	
	private String titleReview;
	private String reviewComment;
	private int productReview;
	private int esqReview;
	private int satisfactionReview;
	private String prosReview;
	private String consReview;
	private String bestUsageReview;
	private int recommendFriend;
	private int buyAgain;
	private int productUtility;
	private String reviewType;
	
	private int reviewId;
	
	private List<ETMediaReviewDTO> mediaReview;
	
	public List<ETMediaReviewDTO> getMediaReview() {
		return mediaReview;
	}
	public void setMediaReview(List<ETMediaReviewDTO> mediaReview) {
		this.mediaReview = mediaReview;
	}
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
	public String getTitleReview() {
		return titleReview;
	}
	public void setTitleReview(String titleReview) {
		this.titleReview = titleReview;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public int getEsqReview() {
		return esqReview;
	}
	public void setEsqReview(int esqReview) {
		this.esqReview = esqReview;
	}
	public int getSatisfactionReview() {
		return satisfactionReview;
	}
	public void setSatisfactionReview(int satisfactionReview) {
		this.satisfactionReview = satisfactionReview;
	}
	public String getProsReview() {
		return prosReview;
	}
	public void setProsReview(String prosReview) {
		this.prosReview = prosReview;
	}
	public String getConsReview() {
		return consReview;
	}
	public void setConsReview(String consReview) {
		this.consReview = consReview;
	}
	public String getBestUsageReview() {
		return bestUsageReview;
	}
	public void setBestUsageReview(String bestUsageReview) {
		this.bestUsageReview = bestUsageReview;
	}
	public int getRecommendFriend() {
		return recommendFriend;
	}
	public void setRecommendFriend(int recommendFriend) {
		this.recommendFriend = recommendFriend;
	}
	public int getBuyAgain() {
		return buyAgain;
	}
	public void setBuyAgain(int buyAgain) {
		this.buyAgain = buyAgain;
	}

	public int getProductUtility() {
		return productUtility;
	}
	public void setProductUtility(int productUtility) {
		this.productUtility = productUtility;
	}
	public String getReviewType() {
		return reviewType;
	}
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	
	public int getProductReview() {
		return productReview;
	}
	public void setProductReview(int productReview) {
		this.productReview = productReview;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	@Override
	public String toString() {
		return "ETReviewDTO [saleId=" + saleId + ", productId=" + productId + ", customerId=" + customerId
				+ ", titleReview=" + titleReview + ", reviewComment=" + reviewComment + ", productReview="
				+ productReview + ", esqReview=" + esqReview + ", satisfactionReview=" + satisfactionReview
				+ ", prosReview=" + prosReview + ", consReview=" + consReview + ", bestUsageReview=" + bestUsageReview
				+ ", recommendFriend=" + recommendFriend + ", buyAgain=" + buyAgain + ", productUtility="
				+ productUtility + ", reviewType=" + reviewType + ", reviewId=" + reviewId + ", mediaReview="
				+ mediaReview + "]";
	}
	
	
	
}
