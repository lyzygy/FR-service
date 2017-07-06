/**
 * 
 */
package cn.xiangyu.finereport.sso.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author liuzg
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class SSOLoginResponse {

	private String returnCode;
	private String returnMsg;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
}
