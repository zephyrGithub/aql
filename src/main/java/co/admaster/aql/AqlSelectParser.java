package co.admaster.aql;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Select 语句处理
 * <p/>
 * User: chenxiaojian
 * Date: 13-4-27
 * Time: 下午4:27
 */
public class AqlSelectParser {

    //select查询封装bean
    private AqlSelectParserBean aqlSelectParserBean;


    public AqlSelectParser(String sql) {
        aqlSelectParserBean = new AqlSelectParserBean();
        init(sql);
    }

    private void init(String sql) {

        CCJSqlParserManager pm = new CCJSqlParserManager();
        Statement statement = null;
        try {
            statement = pm.parse(new StringReader(sql));
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }

        if (statement instanceof Select) {
            Select selectStatement = (Select) statement;
            PlainSelect plainSel = (PlainSelect) selectStatement.getSelectBody();
//            System.out.println("where查询条件:");
//            System.out.println(plainSel.getWhere());
//            System.out.println("fields:");
//            System.out.println(plainSel.getSelectItems());

            if (plainSel.getFromItem() != null)
                aqlSelectParserBean.setTabName(String.valueOf(plainSel.getFromItem()));
            if (plainSel.getWhere() != null)
                aqlSelectParserBean.setWhere(String.valueOf(plainSel.getWhere()));
            if (plainSel.getSelectItems() != null)
                aqlSelectParserBean.setFromItem(String.valueOf(plainSel.getSelectItems()));
            if (plainSel.getLimit() != null)
                aqlSelectParserBean.setLimit(Long.valueOf(plainSel.getLimit().getRowCount()));
            System.out.println("aqlSelectParserBean: " + aqlSelectParserBean.toString());
        }
    }


    public AqlSelectParserBean getAqlSelectParserBean() {
        return aqlSelectParserBean;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
//        String sql = "SELECT field1,field2,field3,field4 FROM MY_TABLE1 where field1 = value1 and field4 = value4";
        String zhongwen = "中文";
        String sql =
                "select num,price,type,stuff_status,title,desca,location.state,location.city,cid,props from item  where field1 = " + zhongwen + " and field4 = value4 limit 5";
        AqlSelectParser aqlSelectParser = new AqlSelectParser(sql);
        System.out.println("test it: " + aqlSelectParser.getAqlSelectParserBean());
    }


}
