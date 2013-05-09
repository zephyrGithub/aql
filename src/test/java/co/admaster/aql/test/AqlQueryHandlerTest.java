package co.admaster.aql.test;

import co.admaster.aql.AqlQuery;
import co.admaster.aql.AqlQueryHandler;
import co.admaster.aql.exception.AqlException;

/**
 * Created with IntelliJ IDEA.
 * User: chenxiaojian
 * Date: 13-4-28
 * Time: 下午3:24
 * To change this template use File | Settings | File Templates.
 */
public class AqlQueryHandlerTest {


    public static void main(String[] args) {
        String aql =
                "SELECT field1,field2,field3,field4 FROM MY_TABLE1 where field1 = value1 and field4 = value4  and order_by=price limit 3";
        AqlQueryHandler aqlQueryHandler = new AqlQueryHandler(aql);

        AqlQuery aqlQuery = null;
        try {
            aqlQuery = aqlQueryHandler.getAqlQuery();
            System.out.println("---- " + aqlQuery.toString());
        } catch (AqlException e) {
            e.printStackTrace();
        }


    }


}
