package cn.xiangyu.finereport.exception;

/**
 * @author liuzg
 *
 */
public class FineReportSSOLoginException extends Exception {
	private static final long serialVersionUID = 1L;

	public FineReportSSOLoginException(String message) {
		super(message);
	}

	public FineReportSSOLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public FineReportSSOLoginException(String message, String additionalMessage) {
		super(message);
	}
}
