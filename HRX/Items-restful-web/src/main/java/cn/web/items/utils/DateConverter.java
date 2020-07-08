package cn.web.items.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverter implements Converter<String, Date> {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String sourse) {
        try {
            return sdf.parse(sourse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
