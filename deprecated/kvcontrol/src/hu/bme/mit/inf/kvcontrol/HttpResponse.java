package hu.bme.mit.inf.kvcontrol;

public final class HttpResponse {
	private static final String CRLF = "\r\n";
	private final int statusCode;
	private final String reasonPhrase;
	private final String contentType;
	private final String payload;

	public HttpResponse(int statusCode) {
		this(statusCode, null, null);
	}

	public HttpResponse(int statusCode, String contentType, String payload) {
		this.statusCode = statusCode;
		this.reasonPhrase = HttpStatusCodes.getReasonPhrase(statusCode);
		this.contentType = contentType;
		if (payload != null) {
			this.payload = payload;
		} else {
			this.payload = statusCode + " " + reasonPhrase;
		}
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	public String getContentType() {
		return contentType;
	}

	public String getPayload() {
		return payload;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("HTTP/1.1 ").append(statusCode);

		if (reasonPhrase != null) {
			sb.append(' ').append(reasonPhrase);
		}
		sb.append(CRLF);

		if (contentType != null) {
			sb.append("Content-Type: ").append(contentType).append(CRLF);
		} else {
			sb.append("Content-Type: text/plain").append(CRLF);
		}

		if (payload != null) {
			sb.append("Content-Length: ").append(payload.length()).append(CRLF);
			sb.append(CRLF);
			sb.append(payload);
			sb.append(CRLF);
		} else {
			sb.append("Content-Length: 0").append(CRLF);
			sb.append(CRLF);
			sb.append(CRLF);
		}

		return sb.toString();
	}
}
