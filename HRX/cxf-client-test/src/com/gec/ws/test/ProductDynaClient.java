package com.gec.ws.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;



public class ProductDynaClient {

    public static void main(String[] args) {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        String WSDL = "http://localhost:8080/services/productService?wsdl";
        String menthodName = "findProductByJson";

        Client client = factory.createClient(WSDL);

        try {
            Object[] result = client.invoke(menthodName);//远程方法调用
            String json = result[0].toString();
            System.out.println(json);

            JSONArray array = JSON.parseArray(json);
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = array.getJSONObject(i);
                System.out.println(obj.getInteger("id")+","+obj.getString("name")+","+obj.getDouble("price")+","+obj.getString("location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
