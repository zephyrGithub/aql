package co.admaster.aql;

import co.admaster.aql.exception.AqlException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.FromItem;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 类SQL语句转换成AqlQuery Bean
 * <p/>
 * User: chenxiaojian
 * Date: 13-4-27
 * Time: 下午4:25
 */
public class AqlQueryHandler {

    private String AQLStr;

    public AqlQueryHandler(String AQLStr) {
        this.AQLStr = AQLStr;
    }

    public AqlQuery getAqlQuery() throws AqlException {
        AqlSelectParser aqlSelectParser = new AqlSelectParser(AQLStr);
        if (aqlSelectParser.getAqlSelectParserBean().getException() != null) {
            throw new AqlException("AQL表达式不正确!" + aqlSelectParser.getAqlSelectParserBean().getException());
        }

        FromItem fromItem = aqlSelectParser.getAqlSelectParserBean().getFromItem();
        Expression where = aqlSelectParser.getAqlSelectParserBean().getWhere();
        List selectItems = aqlSelectParser.getAqlSelectParserBean().getSelectItems();

        if (fromItem == null)
            throw new AqlException("缺少table");

        //匹配table


        if (where == null || StringUtils.isBlank(where.toString()))
            throw new AqlException("缺少查询条件");

        String conditions = where.toString();

        //查询条件
        TreeMap<String, String> whereMap = new TreeMap<String, String>();
        conditions = conditions.toLowerCase();
        String[] condAnds = conditions.split("and");
        for (String conStr : condAnds) {
            String[] conds = conStr.split("=");
            String condsKey = conds[0].trim().toLowerCase();
            String condsValue = conds[1].trim();
            whereMap.put(condsKey, condsValue);
        }

        if (selectItems == null || "[*]".equals(selectItems)) {
            throw new AqlException("缺少查询条件");
        }

        System.out.println("打印...");
        System.out.println("fromItem: " + fromItem.toString());
        System.out.println("selectItems: " + selectItems);

        System.out.println("查询条件....");
        for (Map.Entry<String, String> conds : whereMap.entrySet()) {
            System.out.println("param: " + conds.getKey());
            System.out.println("value: " + conds.getValue());
        }

        AqlQuery aqlQuery = new AqlQuery();
        aqlQuery.setFromItem(fromItem);
        aqlQuery.setSelectItems(selectItems);
        aqlQuery.setWhere(where);

        return aqlQuery;
    }


    public static void main(String[] args) {

        String aql =
                "SELECT field1,field2,field3,field4 FROM MY_TABLE1 where field1 = value1 and field4 = value4  limit 3";
        AqlQueryHandler aqlQuery = new AqlQueryHandler(aql);

        AqlQuery aqlGet = null;
        try {
            aqlGet = aqlQuery.getAqlQuery();
        } catch (AqlException e) {

        }
        System.out.println("print aqlGet: \n" + aqlGet.toString());

    }


}
