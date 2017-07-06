package cn.xiangyu.finereport.sso.webservice;

/**
 * @author liuzg
 */
public class SSOloginCorpbcodeFilter {
	private String userEBSCorpCode;

	/**
	 * 获取EBS用户公司编码
	 * 
	 * @return String
	 */
	public String getUserEBSCorpCode() {
		return userEBSCorpCode;
	}

	/**
	 * 设置EBS用户公司编码
	 * 
	 * @param userEBSCorpCode
	 */
	public void setUserEBSCorpCode(String userEBSCorpCode) {
		this.userEBSCorpCode = userEBSCorpCode;
	}

}
