package test;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import cn.xiangyu.finereport.sso.webservice.SSOLoginRequest;
import cn.xiangyu.finereport.sso.webservice.SSOLoginResponse;
import cn.xiangyu.finereport.sso.webservice.SSOLoginService;
import cn.xiangyu.finereport.sso.webservice.SSOLoginUserPermission;
import cn.xiangyu.finereport.sso.webservice.SSOLoginUserPermissionList;

public class LoginClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factoryBean=new JaxWsProxyFactoryBean();
		factoryBean.getInInterceptors().add(new LoggingInInterceptor());
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
		factoryBean.setServiceClass(SSOLoginService.class);
		factoryBean.setAddress("http://localhost:8080/finereport-service/webservice/ssoLogin?wsdl");
//		factoryBean.setAddress("http://192.168.10.79:8011/FR/SSOLogin/ProxyServices/SSOLoginPS");
//		factoryBean.setAddress("http://192.168.10.10/finereport-service/webservice/ssoLogin?wsdl");
		
		SSOLoginRequest request = new SSOLoginRequest();
		request.setApplId("");
		request.setUserCode("张三");
		
//		SSOloginCorpbcodeFilterArr ssOloginCorpbcodeFilterArr = new SSOloginCorpbcodeFilterArr();
//		SSOloginCorpbcodeFilter ssOloginCorpbcodeFilter = new SSOloginCorpbcodeFilter();
//		ssOloginCorpbcodeFilter.setUserEBSCorpCode("303");
//		SSOloginCorpbcodeFilter[] ssOloginCorpbcodeFilters = {ssOloginCorpbcodeFilter};
//		ssOloginCorpbcodeFilterArr.setCorpbcodeFilter(ssOloginCorpbcodeFilters);
//		request.setCorpbcodeFilterArr(ssOloginCorpbcodeFilterArr);
//		
//		SSOloginBcodeFilterArr ssOloginBcodeFilterArr = new SSOloginBcodeFilterArr();
//		SSOloginBcodeFilter ssOloginBcodeFilter = new SSOloginBcodeFilter();
//		ssOloginBcodeFilter.setUserEBSBcode("30034120");
//		SSOloginBcodeFilter[] ssOloginBcodeFilters = {ssOloginBcodeFilter};
//		ssOloginBcodeFilterArr.setBcodeFilter(ssOloginBcodeFilters);
//		request.setBcodeFilterArr(ssOloginBcodeFilterArr);
		
		SSOLoginUserPermission userPermission = new SSOLoginUserPermission();
		userPermission.setFieldType("company");
		userPermission.setFieldCode("303");
		userPermission.setFieldName("303desc_成大");
		
		SSOLoginUserPermission userPermission2 = new SSOLoginUserPermission();
		userPermission2.setFieldType("department");
		userPermission2.setFieldCode("30034120");
		userPermission2.setFieldName("30034120desc");
		
		List<SSOLoginUserPermission> userPermissions = new ArrayList<SSOLoginUserPermission>();
		userPermissions.add(userPermission);
		userPermissions.add(userPermission2);
		
		SSOLoginUserPermissionList userPermissionList = new SSOLoginUserPermissionList();
		userPermissionList.setUserPermissions(userPermissions);
		request.setUserPermissionList(userPermissionList);
		request.setFuncid("Work2.cpt");
		
		SSOLoginService client = (SSOLoginService)factoryBean.create();
		SSOLoginResponse result = client.getSSOURL(request);
		System.out.println("***********" + result.getReturnMsg());
		
//		System.out.println(WebSessionManagerProc.decrypt("SNABC", "ZGEA22A650B0CBDB402802BB7DDDABE91C12789591BD511A505A883780A50D779730AB344B603022CC0CB53A93C7C0661E66"));
//		System.out.println(WebSessionManagerProc.decrypt("SNABC", "ZG4363FA7EF5FCC41786E033A747A913C9EF2B68AC0E952ABCA0FE2696443A7A37D418FE223370061EE2D2E75FB4080E3890"));
	}

}
