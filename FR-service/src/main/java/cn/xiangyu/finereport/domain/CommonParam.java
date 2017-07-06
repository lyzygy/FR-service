package cn.xiangyu.finereport.domain;

/**
 * @author liuzg
 *
 */
public class CommonParam {
	private String source;
	private String target;
	private String pageTotal;
	private String pageNo;
	private String docType;
	private String docCode;
	private String property;

	/**
	 * 获取来源系统（调用系统）简称
	 */
	public String getSource() {
		return source;
	}

	/**
	 * 设置来源系统（调用系统）简称
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * 获取目标系统（服务系统）简称
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 设置目标系统（服务系统）简称
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 获取请求总页数。当请求的业务数据有明细行超过1000条时，拆分标记总页数。
	 */
	public String getPageTotal() {
		return pageTotal;
	}

	/**
	 * 设置请求总页数。当请求的业务数据有明细行超过1000条时，拆分标记总页数。
	 */
	public void setPageTotal(String pageTotal) {
		this.pageTotal = pageTotal;
	}

	/**
	 * 获取当前请求页号。分页请求时，当前请求的页号。
	 */
	public String getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前请求页号。分页请求时，当前请求的页号。
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 获取单据类型。当前请求相关单据类型。
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * 设置单据类型。当前请求相关单据类型。
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * 获取单据号码。当前请求业务单据的单号。
	 */
	public String getDocCode() {
		return docCode;
	}

	/**
	 * 设置单据号码。当前请求业务单据的单号。
	 */
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	/**
	 * 获取备用字段。预留字段，当需要时，可以用来传递请求流水号。
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * 设置备用字段。预留字段，当需要时，可以用来传递请求流水号。
	 */
	public void setProperty(String property) {
		this.property = property;
	}

}
