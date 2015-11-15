package co.com.etrust.etapi.dao.report;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import co.com.etrust.etapi.response.dto.ETReviewReport;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataColumn;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataTable;

@Repository("reportDAO")
public class ReportDAO implements IReportDAO {

	@Override
	public List<Object> getReviewReport(List<ETMetaDataTable> tables) {
		Session sess = ETDBConnectionManager.getCurrentSession();
		sess.getTransaction();
		String field = "et.product_et_id";
		List<ETReviewReport> report = new ArrayList<ETReviewReport>();
		String str = "SELECT r.review_et_id as reviewId, "
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
				+ " FROM et_reviews r";
		Query q = sess.createSQLQuery(str).setResultTransformer(Transformers.aliasToBean(ETReviewReport.class));
		report = q.list();
		for (ETReviewReport review : report) {
			String select = "Select ";
			String from = " FROM et_reviews et, ";
			String where = " WHERE et.review_et_id = :reviewId AND ";
			for (ETMetaDataTable table : tables) {
				from+= " "+table.getTableName();
				for (ETMetaDataColumn col : table.getColumns()) {
					select += table.getTableName()+"."+col.getColumnName()+",";
					if(col.getColumnKey() != null && col.getColumnKey().equals("PRI")){
						where += field+"="+col.getColumnName();
					}
				}
			}
			String str2 = select.substring(0, select.length()-1) + from + where;
			Query det = sess.createSQLQuery(str2).setInteger("reviewId", review.getReviewId());
			Iterator i = det.list().iterator();
			while (i.hasNext()) {
				Object[] tuple = (Object[]) i.next();
				List<ETMetaDataColumn> columns = tables.get(0).getColumns();
				for(int b = 0;b < columns.size() ;b++){
					review.getEcommerceInfo().put(columns.get(b).getColumnName(), (String)tuple[b].toString());
				}
				
			}
		}
		return new ArrayList<Object>(report);
	}

}
