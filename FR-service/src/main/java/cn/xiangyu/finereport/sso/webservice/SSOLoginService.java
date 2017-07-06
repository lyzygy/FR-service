package cn.xiangyu.finereport.sso.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author liuzg
 */
//@WebService(name = "SSOLoginService", targetNamespace = "http://www.xiangyu.cn/webservice/finereport/ssoLogin")
@WebService(name = "SSOLoginService", targetNamespace = "http://login.service.xy.snsoft/")
public interface SSOLoginService {
	public SSOLoginResponse getSSOURL(@WebParam(name = "ssoLoginParam") SSOLoginRequest request);
}
