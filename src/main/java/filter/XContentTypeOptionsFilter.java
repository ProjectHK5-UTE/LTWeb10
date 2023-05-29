package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" })
public class XContentTypeOptionsFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Khởi tạo Filter
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

		response.setHeader("X-Content-Type-Options", "nosniff");

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		// Hủy Filter
	}
}
