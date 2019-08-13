/**
 * 
 */
package com.health.core.client;

import com.sunshine.common.utils.ObjectUtils;
import com.health.core.constant.ConfigConstant;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

/**
 * @author 张梓枫
 * @Description
 * @date:   2019年1月3日 下午5:30:21
 */
@Configuration
public class RestClient<Q,R> {

    @Autowired
    private RestTemplate restTemplate;
    
    private HttpHeaders headers;
    
    @Autowired
    private CloseableHttpClient httpClient;
    
    @Autowired
    private RequestConfig requestConfig;
    
    public R callForObject(String url, Q q, HttpMethod method, Class<R> clazz) {
        HttpEntity<Q> httpEntity = new HttpEntity<Q>(q,this.getHeaders());
        ResponseEntity<R> entity = restTemplate.exchange(url, method, httpEntity, clazz);
        return entity.getBody();
    }
    
    public R callGetObject(URI uri,Class<R> clazz) {
        HttpEntity<Q> httpEntity = new HttpEntity<Q>(this.getHeaders());
        ResponseEntity<R> entity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, clazz);
        return entity.getBody();
    }
    
    public R callGetObject(String url,Class<R> clazz) {
        HttpEntity<Q> httpEntity = new HttpEntity<Q>(this.getHeaders());
        ResponseEntity<R> entity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, clazz);
        return entity.getBody();
    }
    
    public String httpGetObject(String url){
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try {
            CloseableHttpResponse entity = httpClient.execute(httpGet);
            String result = EntityUtils.toString(entity.getEntity());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String httpPost4Json(String url, String jsonString){
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(jsonString, Charset.forName("utf-8"));
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        try{
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String httpPost4Form(String url, String formString){
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(formString, Charset.forName("utf-8"));
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(entity);
        try{
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public RestClient<Q,R> createHeaders(String tokenValue) {
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.valueOf(ConfigConstant.CONTENT_TYPE));
        this.headers.add(ConfigConstant.SESSION_TOKEN, tokenValue);
        return this;
    }

    public RestClient<Q,R> createHeaders(String contentType, String tokenValue) {
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.valueOf(contentType));
        if (ObjectUtils.isNotEmpty(tokenValue)){
            this.headers.add(ConfigConstant.SESSION_TOKEN, tokenValue);
        }
        return this;
    }

    public RestClient<Q,R> createHeaders(String contentType, String tokenKey, String tokenValue) {
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.valueOf(contentType));
        this.headers.add(tokenKey, tokenValue);
        return this;
    }
    
    public HttpHeaders getHeaders() {
        if (ObjectUtils.isNotEmpty(headers)) {
            return this.headers;
        }
        return this.getHeaders(ConfigConstant.CONTENT_TYPE);
    }

    private HttpHeaders getHeaders(String contentType) {
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.valueOf(contentType));
        return this.headers;
    }
}
