package com.tht.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author TianWei
 */
public class YamlHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
  
    public YamlHttpMessageConverter() {  
        super(new MediaType("application", "yaml", StandardCharsets.UTF_8));
    }

    /**
     * 可以根据实际需求具体优化, 判断返回值类型 clazz 是否需要被转换成yaml格式
     * @param clazz the class to test for support
     * @return 此类型是否触发转换器
     */
    @Override  
    protected boolean supports(Class<?> clazz) {  
        return true;
    }  
  
    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;  
    }  
  
    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper objectMapper = new ObjectMapper(factory);
        try(OutputStream body = outputMessage.getBody()) {
            objectMapper.writeValue(body, o);
        }  
    }  
}