package cn.xiangyu.finereport.sso.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author liuzg
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SSOLoginUserPermissionList {
	@XmlElement(name = "userPermission")
	private List<SSOLoginUserPermission> userPermissions = new ArrayList<SSOLoginUserPermission>();

	public List<SSOLoginUserPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<SSOLoginUserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}
}
