package cn.xiangyu.finereport.sso.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.xiangyu.finereport.exception.FineReportSSOLoginException;
import cn.xiangyu.finereport.service.FineReportSSOLoginService;
import cn.xiangyu.finereport.sso.webservice.SSOLoginRequest;
import cn.xiangyu.finereport.sso.webservice.SSOLoginResponse;
import cn.xiangyu.finereport.sso.webservice.SSOLoginService;

/**
 * @author liuzg
 *
 */
@WebService
@Component("ssoLoginServiceImpl")
public class SSOLoginServiceImpl implements SSOLoginService {
	@Autowired
	private FineReportSSOLoginService fineReportSSOLoginService;

	@Override
	public SSOLoginResponse getSSOURL(SSOLoginRequest request) {

		SSOLoginResponse response = new SSOLoginResponse();
		try {
			String loginUserToken = fineReportSSOLoginService.getLoginURL(request);
			response.setReturnCode("S");
			response.setReturnMsg(loginUserToken);
		} catch (FineReportSSOLoginException e) {
			response.setReturnCode("E");
			response.setReturnMsg(e.getMessage());
			// TODO 记录异常日志
		} catch (Exception e) {
			response.setReturnCode("E");
			response.setReturnMsg("服务异常:" + e.getMessage());
			e.printStackTrace();
			// TODO 记录异常日志
		}
		return response;
	}

}
