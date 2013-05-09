package co.admaster.aql;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.FromItem;

import java.util.List;

/**
 * select查询封装bean
 * <p/>
 * User: chenxiaojian
 * Date: 13-4-27
 * Time: 下午4:31
 */
public class AqlSelectParserBean {

    private FromItem fromItem = null;
    private Expression where = null;
    private List selectItems = null;
    private long limit;
    private String exception = null;


    public FromItem getFromItem() {
        return fromItem;
    }

    public void setFromItem(FromItem fromItem) {
        this.fromItem = fromItem;
    }

    public Expression getWhere() {
        return where;
    }

    public void setWhere(Expression where) {
        this.where = where;
    }

    public List getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List selectItems) {
        this.selectItems = selectItems;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }


    public String toString() {
        return new StringBuilder().append("\n").append("fromItem: ").append(getFromItem())
                .append("\n")
                .append("where: ").append(getWhere())
                .append("\n")
                .append("selectItems: ").append(getSelectItems())
                .append("\n")
                .append("limit: ").append(getLimit())
                .append("\n")
                .append("exception: ").append(getException()).toString();
    }

}
