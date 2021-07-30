package com.example.music.typeHandler;

import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库时间转换
 *
 * @ClassPath com.example.music.typeHandler
 * @ClassName SyDateTypeHandler
 * @Author whd
 * @Date 2021/7/29 16:55
 * @Version 1.0
 */
@MappedJdbcTypes({JdbcType.TIMESTAMP})
@MappedTypes(value = Date.class)
public class SyDateTypeHandler extends DateTypeHandler {

    private static final long zeroTime = -28800000L;

    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnName);
        return sqlTimestamp != null && sqlTimestamp.getTime() > -28800000L ? super.getNullableResult(rs, columnName) : null;
    }

    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnIndex);
        return sqlTimestamp != null && sqlTimestamp.getTime() > -28800000L ? super.getNullableResult(rs, columnIndex) : null;
    }

    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = cs.getTimestamp(columnIndex);
        return sqlTimestamp != null && sqlTimestamp.getTime() > -28800000L ? super.getNullableResult(cs, columnIndex) : null;
    }
}
