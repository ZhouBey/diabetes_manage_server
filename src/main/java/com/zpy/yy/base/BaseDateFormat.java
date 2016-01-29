package com.zpy.yy.base;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *»ù±¾date×ª»»
 *
 */
public class BaseDateFormat extends DateFormat {
    private final SimpleDateFormat innerFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat innerFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat innerFormat3 = new SimpleDateFormat("yyyy/MM/dd");
    private final SimpleDateFormat innerFormat4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return innerFormat.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        return innerFormat.parse(source, pos);
    }

    @Override
    public Date parse(String source) throws ParseException {
        System.out.println(source);
        try {
            return innerFormat.parse(source);
        } catch (Exception e) {

        }
        try {
            return innerFormat2.parse(source);
        } catch (Exception e) {

        }
        try {
            return innerFormat3.parse(source);
        } catch (Exception e) {

        }
        try {
            return innerFormat4.parse(source);
        } catch (Exception e) {

        }
        throw new ParseException("Unparseable date: \"" + source + "\"",
                0);
    }
}
