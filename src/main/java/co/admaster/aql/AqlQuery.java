package co.admaster.aql;

import java.util.TreeMap;

/**
 * 查询参数封装bean
 * <p/>
 * User: chenxiaojian
 * Date: 13-4-27
 * Time: 下午6:35
 */
public class AqlQuery {

    private TreeMap<String, String> whereMap;
    private String tableName;
    private String fields;
    private String strApprequest;
    private long limit;


    public TreeMap<String, String> getWhereMap() {
        return whereMap;
    }

    public void setWhereMap(TreeMap<String, String> whereMap) {
        this.whereMap = whereMap;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getStrApprequest() {
        return strApprequest;
    }

    public void setStrApprequest(String strApprequest) {
        this.strApprequest = strApprequest;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {

        return "tableName: " + tableName + "\r\n"
                + "fields: " + fields + "\r\n"
                + "whereMap: " + whereMap.toString();
    }


}
