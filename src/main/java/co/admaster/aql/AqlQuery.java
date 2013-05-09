package co.admaster.aql;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.FromItem;

import java.util.List;
import java.util.TreeMap;

/**
 * 查询参数封装bean
 * <p/>
 * User: chenxiaojian
 * Date: 13-4-27
 * Time: 下午6:35
 */
public class AqlQuery {

    private String strApprequest;
    private FromItem fromItem = null;
    private Expression where = null;
    private List selectItems = null;
    private long limit;


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

    public List getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List selectItems) {
        this.selectItems = selectItems;
    }

    public Expression getWhere() {
        return where;
    }

    public void setWhere(Expression where) {
        this.where = where;
    }

    public FromItem getFromItem() {
        return fromItem;
    }

    public void setFromItem(FromItem fromItem) {
        this.fromItem = fromItem;
    }
}
