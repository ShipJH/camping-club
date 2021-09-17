package com.cc.kr.config;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.IThrowableProxy;

public class ExceptionLogConverter extends ThrowableProxyConverter {
    @Override
    protected String throwableProxyToString(IThrowableProxy tp) {
        return this.extractException(tp);
    }

    private String extractException(IThrowableProxy tp) {
        StringBuffer sb = new StringBuffer();
        sb.append(tp.getClassName());
        sb.append(" : ");
        sb.append(tp.getMessage());
        Stream.of(tp.getStackTraceElementProxyArray())
                .forEach(v -> {
                    if (StringUtils.indexOf(v.getSTEAsString(), "com.cc.kr") > 0) {
                        sb.append("\n");
                        sb.append(v.getSTEAsString());
                    }
                });
        return sb.toString();
    }
}
