package com.example.music.typeHandler;

import org.apache.ibatis.type.DateOnlyTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 数据库时间转换
 *
 * @ClassPath com.example.music.typeHandler
 * @ClassName SyDateOnlyTypeHandler
 * @Author whd
 * @Date 2021/7/29 16:59
 * @Version 1.0
 */
@MappedJdbcTypes({JdbcType.DATE})
@MappedTypes(value = Date.class)
public class SyDateOnlyTypeHandler extends DateOnlyTypeHandler {

    private static final long zeroTime = -28800000L;

    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        java.sql.Date sqlDate = rs.getDate(columnName);
        return sqlDate != null && sqlDate.getTime() > -28800000L ? super.getNullableResult(rs, columnName) : null;
    }

    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        java.sql.Date sqlDate = rs.getDate(columnIndex);
        return sqlDate != null && sqlDate.getTime() > -28800000L ? super.getNullableResult(rs, columnIndex) : null;
    }

    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        java.sql.Date sqlDate = cs.getDate(columnIndex);
        return sqlDate != null && sqlDate.getTime() > -28800000L ? super.getNullableResult(cs, columnIndex) : null;
    }
}