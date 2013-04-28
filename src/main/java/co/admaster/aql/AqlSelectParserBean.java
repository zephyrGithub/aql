package co.admaster.aql;

import java.util.List;

/**
 * select查询封装bean
 * <p/>
 * User: chenxiaojian
 * Date: 13-4-27
 * Time: 下午4:31
 */
public class AqlSelectParserBean {

    private String tabName = null;
    private String where = null;
    private String fromItem = null;
    private String exception = null;
    private long limit;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getFromItem() {
        return fromItem;
    }

    public void setFromItem(String fromItem) {
        this.fromItem = fromItem;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public String toString() {
        return new StringBuilder().append("tabName: ").append(getTabName())
                .append("\n")
                .append("where: ").append(getWhere())
                .append("\n")
                .append("formItem: ").append(getFromItem())
                .append("\n")
                .append("limit: ").append(getLimit())
                .append("\n")
                .append("exception: ").append(getException()).toString();
    }

}
