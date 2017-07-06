package cn.xiangyu.finereport.sso.webservice;

/**
 * @author liuzg
 */
public class SSOloginBcodeFilter {
	private String userEBSBcode;

	/**
	 * 获取EBS用户部门编码
	 * @return String
	 */
	public String getUserEBSBcode() {
		return userEBSBcode;
	}

	/**
	 * 设置EBS用户部门编码
	 * @param userEBSBcode
	 */
	public void setUserEBSBcode(String userEBSBcode) {
		this.userEBSBcode = userEBSBcode;
	}
}
