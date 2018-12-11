package org.chishingmateo.servlet.filter;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String subpath = null;
		try {
			URL url = new URL(req.getRequestURL().toString());
			String path = url.getPath();
			subpath = path.substring(req.getContextPath().length());
			
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
			System.out.println("subpath " + subpath);
		} catch (Exception e) {
			chain.doFilter(request, response);
			return;
		}
		if (subpath == null) {
			chain.doFilter(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

}
