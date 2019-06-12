package com.jimy.ec.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 〈一句话功能简述〉
 * 〈HttpServletRequestWrapper重写〉
 *
 * @author 周金明
 * @create 2019/4/28
 * @since 1.0.0
 */
public class BodyRequestWrapper extends HttpServletRequestWrapper {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final String body;

    public BodyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        StringBuffer stringBuilder = new StringBuffer();
        byte[] b = new byte[1024];
        int len = 0;
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            if (inputStream != null) {
                while ((len = inputStream.read(b)) != -1){
                    stringBuilder.append(new String(b, 0, len, "utf-8"));
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            logger.error("【系统拦截器异常】", ex);
        } finally {
            if( inputStream != null){
                inputStream.close();
            }
        }
        body = stringBuilder.toString();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
        ServletInputStream servletInputStream = new ServletInputStream() {
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
            @Override
            public boolean isFinished() {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public boolean isReady() {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public void setReadListener(ReadListener readListener) {
                // TODO Auto-generated method stub

            }
        };
        return servletInputStream;
    }
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
    public String getBody() {
        return this.body;
    }
}