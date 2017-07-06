package cn.xiangyu.finereport.sso.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import cn.xiangyu.finereport.domain.CommonParam;

/**
 * @author liuzg
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class SSOLoginRequest {
	private CommonParam commonParam;
	private String applId; // 应用编号
	private String userCode; // 用户
	private String funcid; // 系统功能id;
	private String theme; // 样式
	private String lang; // 语言
	private String wsp; // 账套
	private SSOLoginUserPermissionList userPermissionList; //权限列表
	private String extendfield1; // 扩展字段1
	private String extendfield2; // 扩展字段2
	private String extendfield3; // 扩展字段3
	private String extendfield4; // 扩展字段4
	private String extendfield5; // 额度字段5
	private String extendfield6; // 额度字段6
	private String extendfield7; // 额度字段7
	private String extendfield8; // 额度字段8
	private String extendfield9; // 额度字段9
	private String extendfield10; // 额度字段10

	public CommonParam getCommonParam() {
		return commonParam;
	}

	public void setCommonParam(CommonParam commonParam) {
		this.commonParam = commonParam;
	}

	public String getApplId() {
		return applId;
	}

	public void setApplId(String applId) {
		this.applId = applId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getFuncid() {
		return funcid;
	}

	public void setFuncid(String funcid) {
		this.funcid = funcid;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getWsp() {
		return wsp;
	}

	public void setWsp(String wsp) {
		this.wsp = wsp;
	}

	public SSOLoginUserPermissionList getUserPermissionList() {
		return userPermissionList;
	}

	public void setUserPermissionList(SSOLoginUserPermissionList userPermissionList) {
		this.userPermissionList = userPermissionList;
	}

	public String getExtendfield1() {
		return extendfield1;
	}

	public void setExtendfield1(String extendfield1) {
		this.extendfield1 = extendfield1;
	}

	public String getExtendfield2() {
		return extendfield2;
	}

	public void setExtendfield2(String extendfield2) {
		this.extendfield2 = extendfield2;
	}

	public String getExtendfield3() {
		return extendfield3;
	}

	public void setExtendfield3(String extendfield3) {
		this.extendfield3 = extendfield3;
	}

	public String getExtendfield4() {
		return extendfield4;
	}

	public void setExtendfield4(String extendfield4) {
		this.extendfield4 = extendfield4;
	}

	public String getExtendfield5() {
		return extendfield5;
	}

	public void setExtendfield5(String extendfield5) {
		this.extendfield5 = extendfield5;
	}

	public String getExtendfield6() {
		return extendfield6;
	}

	public void setExtendfield6(String extendfield6) {
		this.extendfield6 = extendfield6;
	}

	public String getExtendfield7() {
		return extendfield7;
	}

	public void setExtendfield7(String extendfield7) {
		this.extendfield7 = extendfield7;
	}

	public String getExtendfield8() {
		return extendfield8;
	}

	public void setExtendfield8(String extendfield8) {
		this.extendfield8 = extendfield8;
	}

	public String getExtendfield9() {
		return extendfield9;
	}

	public void setExtendfield9(String extendfield9) {
		this.extendfield9 = extendfield9;
	}

	public String getExtendfield10() {
		return extendfield10;
	}

	public void setExtendfield10(String extendfield10) {
		this.extendfield10 = extendfield10;
	}
}
