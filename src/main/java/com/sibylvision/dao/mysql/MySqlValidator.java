package com.sibylvision.dao.mysql;

import org.apache.tomcat.jdbc.pool.PooledConnection;
import org.apache.tomcat.jdbc.pool.Validator;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlValidator implements Validator {

    public MySqlValidator() {
    }

    @Override
    public boolean validate(Connection connection, int validateAction) {
        try {
            return connection.isValid(0);
        } catch (SQLException e) {
            return false;
        }
    }

    private String getDescriptiveValidateAction(int validateAction) {
        switch (validateAction) {
            case PooledConnection.VALIDATE_BORROW: return "borrow";
            case PooledConnection.VALIDATE_IDLE: return "idle";
            case PooledConnection.VALIDATE_INIT: return "init";
            case PooledConnection.VALIDATE_RETURN: return "return";
        }
        return "unknown";
    }
}
