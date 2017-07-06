package cn.xiangyu.finereport.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.xiangyu.finereport.db.DataAccess;
import cn.xiangyu.finereport.entity.NfanGuid;

/**
 * @author liuzg
 *
 */
@Repository
public class FineReportSSOLoginDao {

	@Autowired
	protected DataAccess dataAccess;

	@Transactional
	public NfanGuid findById(final Long id) {
		return (NfanGuid) getSession().get(NfanGuid.class, id);
	}

	@Transactional
	public NfanGuid findByFieldName(String fieldName) {
		return (NfanGuid) getSession().createQuery("from NfanGuid where fieldName = ?")
				.setString(0, fieldName)
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<NfanGuid> findByUserCode(String userCode) {
		return (List<NfanGuid>) getSession().createQuery("from NfanGuid where createdBy = :createdBy")
				.setString("createdBy", userCode)
				.list();
	}

	@Transactional
	public NfanGuid save(NfanGuid nfanGuid) {
		getSession().setFlushMode(FlushMode.AUTO);
		getSession().save(nfanGuid);
		getSession().flush();
		return nfanGuid;
	}
	
	@Transactional
	public void delete(NfanGuid nfanGuid) {
		getSession().setFlushMode(FlushMode.AUTO);
		getSession().delete(nfanGuid);
		getSession().flush();
	}

	public Session getSession() {
		return dataAccess.getSession();
	}
}
