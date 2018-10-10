/**
 * 
 */
package stitis.m2liuwei;

/**
 * @author weiliu
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose {
    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
