package cn.xiangyu.finereport.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiangyu.finereport.dao.FineReportSSOLoginDao;
import cn.xiangyu.finereport.entity.NfanGuid;
import cn.xiangyu.finereport.exception.FineReportSSOLoginException;
import cn.xiangyu.finereport.sso.webservice.SSOLoginRequest;
import cn.xiangyu.finereport.sso.webservice.SSOLoginUserPermission;
import cn.xiangyu.finereport.sso.webservice.SSOLoginUserPermissionList;
import oracle.apps.fnd.security.WebSessionManagerProc;

/**
 * @author liuzg
 *
 */
@Service
public class FineReportSSOLoginService {
	@Value("${finereport.login.secret}")
	private String secret;

	@Value("${finereport.login.tokenExpirationInterval}")
	private String tokenExpirationInterval;

	@Autowired
	private FineReportSSOLoginDao fineReportLoginDao;

	@Transactional
	public String getLoginURL(SSOLoginRequest request) throws FineReportSSOLoginException {
		List<SSOLoginUserPermission> userPermissions = request.getUserPermissionList().getUserPermissions();
		if (userPermissions == null || userPermissions.isEmpty()) {
			throw new FineReportSSOLoginException("用户权限列表不能为空！");
		}

		return buildLoginURL(request, getLoginUserToken(request));
	}

	public String getLoginUserToken(SSOLoginRequest request) {
		List<NfanGuid> nfanGuids = fineReportLoginDao.findByUserCode(request.getUserCode());
		if (nfanGuids.isEmpty()) {
			return addLoginUserToken(request);
		}

		NfanGuid nfanGuid = nfanGuids.get(0);
		Date tokenExpirationTime = nfanGuid.getTokenExpirationTime();
		if (System.currentTimeMillis() > tokenExpirationTime.getTime()) {
			return refreshLoginUserToken(nfanGuids, request);
		}

		return nfanGuid.getGuid();
	}

	public String buildLoginURL(SSOLoginRequest request, String tokenId) throws FineReportSSOLoginException {
		String encodedReportPath = "";
		try {
			encodedReportPath = URLEncoder.encode(request.getFuncid(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new FineReportSSOLoginException(e.getMessage(), e);
		}

		return "?username=" + request.getUserCode() + "&tokenid=" + tokenId + "&report=" + encodedReportPath;
	}

	public String addLoginUserToken(SSOLoginRequest request) {
		String userToken = WebSessionManagerProc.encrypt(secret, request.getUserCode());
		createUserPermission(request, userToken);

		return userToken;
	}

	public String refreshLoginUserToken(List<NfanGuid> nfanGuids, SSOLoginRequest request) {
		deleteUserPermission(nfanGuids);

		String userToken = WebSessionManagerProc.encrypt(secret, request.getUserCode());
		createUserPermission(request, userToken);

		return userToken;
	}

	private void deleteUserPermission(List<NfanGuid> nfanGuids) {
		for (NfanGuid nfanGuid : nfanGuids) {
			fineReportLoginDao.delete(nfanGuid);
		}
	}

	private void createUserPermission(SSOLoginRequest request, String userToken) {
		SSOLoginUserPermissionList userPermissionList = request.getUserPermissionList();
		for (SSOLoginUserPermission userPermission : userPermissionList.getUserPermissions()) {
			NfanGuid nfanGuid = new NfanGuid();
			nfanGuid.setGuid(userToken);
			nfanGuid.setFieldType(userPermission.getFieldType());
			nfanGuid.setFieldName(userPermission.getFieldCode());
			nfanGuid.setFieldDesc(userPermission.getFieldName());
			nfanGuid.setCreatedBy(request.getUserCode());
			nfanGuid.setCreationDate(new Date());

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MINUTE, Integer.parseInt(tokenExpirationInterval));
			nfanGuid.setTokenExpirationTime(calendar.getTime());

			fineReportLoginDao.save(nfanGuid);
		}
	}
}
