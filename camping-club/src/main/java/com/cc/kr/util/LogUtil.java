package com.cc.kr.util;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @since 2021-08-26
 * @category 유틸 
 * 객체를 JsonString 화 하여, 로그를 보기 쉽도록 변경해주는 유틸
 * @author shipjh
 */
@Slf4j
@Component
public class LogUtil {
	
	private static ObjectMapper objectMapper;

	@Autowired
	public void setObjectMapper(final ObjectMapper objectMapper) {
		LogUtil.objectMapper = objectMapper.copy();
	}
	
	public static String exception(final Throwable e) {
		return StringUtils.normalizeSpace(e.toString());
	}

	public static String toJSONString(final Object object) {
		if (Objects.isNull(object)) {
			return null;
		}
		try {
			return StringUtils.normalizeSpace(objectMapper.writeValueAsString(object));
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
			if (log.isErrorEnabled()) {
				log.error("toJSONString, {}", StringUtils.normalizeSpace(e.toString()));
			}
		}
		return null;
	}
}
