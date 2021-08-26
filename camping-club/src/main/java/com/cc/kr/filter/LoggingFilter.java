package com.cc.kr.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cc.kr.domain.Constant;

import lombok.extern.slf4j.Slf4j;

/**
 * @since 2021-08-26
 * @category 필터 요청과 응답에 대한 로그를 남기는 필터
 * @author shipjh
 *
 */

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {
		MDC.put(Constant.MDCProperty.REQSEQ, RandomStringUtils.randomAlphanumeric(5));

		final HttpServletRequest req = (HttpServletRequest) request;
		final String method = req.getMethod();
		final String uri = req.getRequestURI();

		if (log.isTraceEnabled()) {
			log.trace("path, {} {}", method, uri);
		}

		filterChain.doFilter(request, response);

		final HttpServletResponse res = (HttpServletResponse) response;
		final int status = res.getStatus();

		switch (HttpStatus.resolve(status).series()) {
		case INFORMATIONAL:
		case SUCCESSFUL:
		case REDIRECTION:
			if (log.isInfoEnabled()) {
				log.info("status: {}, path: {} {}", status, method, uri);
			}
			break;
		case CLIENT_ERROR:
			if (log.isWarnEnabled()) {
				log.warn("status: {}, path: {} {}", status, method, uri);
			}
			break;
		case SERVER_ERROR:
			if (log.isErrorEnabled()) {
				log.error("status: {}, path: {} {}", status, method, uri);
			}
			break;
		}
		MDC.clear();
	}

}
