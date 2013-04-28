package co.admaster.aql;

import co.admaster.aql.exception.AqlException;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * 类SQL语句转换成AqlQuery Bean
 *
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

        String tableStr = aqlSelectParser.getAqlSelectParserBean().getTabName();
        String conditions = aqlSelectParser.getAqlSelectParserBean().getWhere();
        String fields = aqlSelectParser.getAqlSelectParserBean().getFromItem();

        if (StringUtils.isBlank(tableStr))
            throw new AqlException("缺少table");

        //匹配table


        if (StringUtils.isBlank(conditions))
            throw new AqlException("缺少查询条件");

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

        if (StringUtils.isBlank(fields) || "[*]".equals(fields)) {
            throw new AqlException("缺少查询条件");
        }

        System.out.println("打印...");
        System.out.println("tableStr: " + tableStr);
        System.out.println("fields: " + fields);

        System.out.println("查询条件....");
        for (Map.Entry<String, String> conds : whereMap.entrySet()) {
            System.out.println("param: " + conds.getKey());
            System.out.println("value: " + conds.getValue());
        }

        AqlQuery aqlQuery = new AqlQuery();
        aqlQuery.setTableName(tableStr);
        aqlQuery.setWhereMap(whereMap);
        aqlQuery.setFields(fields);

        return aqlQuery;
    }


    public static void main(String[] args) {

        String aql =
                "SELECT field1,field2,field3,field4 FROM MY_TABLE1 where field1 = value1 and field4 = value4  and order_by=price limit 3";
        AqlQueryHandler aqlQuery = new AqlQueryHandler(aql);

        AqlQuery aqlGet = null;
        try {
            aqlGet = aqlQuery.getAqlQuery();
        } catch (AqlException e) {

        }
        System.out.println("print aqlGet: \n" + aqlGet.toString());


    }


}
