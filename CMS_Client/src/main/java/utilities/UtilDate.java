package utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UtilDate{

    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertToDate(java.sql.Date sqlDate) {
        return new Date(sqlDate.getTime());
    }

    public static LocalDate convertToLocalDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    public static LocalDate convertToLocalDate(java.sql.Date sqlDate) {
        return convertToLocalDate(convertToDate(sqlDate));
    }

    public static java.sql.Date convertToSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Date convertToSQLDate(LocalDate localDate) {
        return convertToSQLDate(convertToDate(localDate));
    }
}
