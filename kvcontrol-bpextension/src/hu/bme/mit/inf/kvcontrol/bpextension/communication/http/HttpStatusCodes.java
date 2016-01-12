package hu.bme.mit.inf.kvcontrol.bpextension.communication.http;

import java.util.HashMap;
import java.util.Map;

//Based on RFC 2616
//http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
public final class HttpStatusCodes {
	private static final Map<Integer, String> reasonPhrases;

	public static final int CONTINUE = 100;
	public static final int SWITCHING_PROTOCOLS = 101;

	public static final int OK = 200;
	public static final int CREATED = 201;
	public static final int ACCEPTED = 202;
	public static final int NON_AUTHORITATIVE_INFORMATION = 203;
	public static final int NO_CONTENT = 204;
	public static final int RESET_CONTENT = 205;
	public static final int PARTIAL_CONTENT = 206;

	public static final int MULTIPLE_CHOICES = 300;
	public static final int MOVED_PERMANENTLY = 301;
	public static final int MOVED_TEMPORARILY = 302;
	public static final int SEE_OTHER = 303;
	public static final int NOT_MODIFIED = 304;
	public static final int USE_PROXY = 305;
	public static final int TEMPORARY_REDIRECT = 307;

	public static final int BAD_REQUEST = 400;
	public static final int UNAUTHORIZED = 401;
	public static final int PAYMENT_REQUIRED = 402;
	public static final int FORBIDDEN = 403;
	public static final int NOT_FOUND = 404;
	public static final int METHOD_NOT_ALLOWED = 405;
	public static final int NOT_ACCEPTABLE = 406;
	public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
	public static final int REQUEST_TIMEOUT = 408;
	public static final int CONFLICT = 409;
	public static final int GONE = 410;
	public static final int LENGTH_REQUIRED = 411;
	public static final int PRECONDITION_FAILED = 412;
	public static final int REQUEST_TOO_LONG = 413;
	public static final int REQUEST_URI_TOO_LONG = 414;
	public static final int UNSUPPORTED_MEDIA_TYPE = 415;
	public static final int REQUESTED_RANGE_NOT_SATISFIABLE = 416;
	public static final int EXPECTATION_FAILED = 417;

	public static final int INTERNAL_SERVER_ERROR = 500;
	public static final int NOT_IMPLEMENTED = 501;
	public static final int BAD_GATEWAY = 502;
	public static final int SERVICE_UNAVAILABLE = 503;
	public static final int GATEWAY_TIMEOUT = 504;
	public static final int HTTP_VERSION_NOT_SUPPORTED = 505;

	static {
		reasonPhrases = new HashMap<>();
		reasonPhrases.put(OK, "OK");
		reasonPhrases.put(CREATED, "Created");
		reasonPhrases.put(ACCEPTED, "Accepted");
		reasonPhrases.put(NO_CONTENT, "No Content");
		reasonPhrases.put(MOVED_PERMANENTLY, "Moved Permanently");
		reasonPhrases.put(MOVED_TEMPORARILY, "Moved Temporarily");
		reasonPhrases.put(NOT_MODIFIED, "Not Modified");
		reasonPhrases.put(BAD_REQUEST, "Bad Request");
		reasonPhrases.put(UNAUTHORIZED, "Unauthorized");
		reasonPhrases.put(FORBIDDEN, "Forbidden");
		reasonPhrases.put(NOT_FOUND, "Not Found");
		reasonPhrases.put(INTERNAL_SERVER_ERROR, "Internal Server Error");
		reasonPhrases.put(NOT_IMPLEMENTED, "Not Implemented");
		reasonPhrases.put(BAD_GATEWAY, "Bad Gateway");
		reasonPhrases.put(SERVICE_UNAVAILABLE, "Service Unavailable");

		reasonPhrases.put(CONTINUE, "Continue");
		reasonPhrases.put(TEMPORARY_REDIRECT, "Temporary Redirect");
		reasonPhrases.put(METHOD_NOT_ALLOWED, "Method Not Allowed");
		reasonPhrases.put(CONFLICT, "Conflict");
		reasonPhrases.put(PRECONDITION_FAILED, "Precondition Failed");
		reasonPhrases.put(REQUEST_TOO_LONG, "Request Too Long");
		reasonPhrases.put(REQUEST_URI_TOO_LONG, "Request-URI Too Long");
		reasonPhrases.put(UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
		reasonPhrases.put(MULTIPLE_CHOICES, "Multiple Choices");
		reasonPhrases.put(SEE_OTHER, "See Other");
		reasonPhrases.put(USE_PROXY, "Use Proxy");
		reasonPhrases.put(PAYMENT_REQUIRED, "Payment Required");
		reasonPhrases.put(NOT_ACCEPTABLE, "Not Acceptable");
		reasonPhrases.put(PROXY_AUTHENTICATION_REQUIRED,
				"Proxy Authentication Required");
		reasonPhrases.put(REQUEST_TIMEOUT, "Request Timeout");

		reasonPhrases.put(SWITCHING_PROTOCOLS, "Switching Protocols");
		reasonPhrases.put(NON_AUTHORITATIVE_INFORMATION,
				"Non Authoritative Information");
		reasonPhrases.put(RESET_CONTENT, "Reset Content");
		reasonPhrases.put(PARTIAL_CONTENT, "Partial Content");
		reasonPhrases.put(GATEWAY_TIMEOUT, "Gateway Timeout");
		reasonPhrases.put(HTTP_VERSION_NOT_SUPPORTED,
				"Http Version Not Supported");
		reasonPhrases.put(GONE, "Gone");
		reasonPhrases.put(LENGTH_REQUIRED, "Length Required");
		reasonPhrases.put(REQUESTED_RANGE_NOT_SATISFIABLE,
				"Requested Range Not Satisfiable");
		reasonPhrases.put(EXPECTATION_FAILED, "Expectation Failed");
	}

	public static String getReasonPhrase(int statusCode) {
		return reasonPhrases.get(statusCode);
	}
}