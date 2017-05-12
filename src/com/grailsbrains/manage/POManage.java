package com.grailsbrains.manage;


import com.grailsbrains.persistence.PurchaseOrder;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

/**
 * Created by Ajeet on 5/5/2017.
 */
public class POManage {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    final Session session = getSession();
    Transaction tx = session.beginTransaction();

    //method to insert purchase order
    public int createPurchaseOrder(PurchaseOrder purchaseOrder){
        try {
            session.save(purchaseOrder);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return 0 ;
        }
        return 0;
    }

    //method to retrieve purchase order
    public List<Output> viewOrders(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();
        List<Output> outputList = new ArrayList<>();

       try {
            session.beginTransaction();

            String sqlQuery = "select po.id , po.poNumber, po.seller_vendor, po.dueDate, po.status, po.priority, org.shipFrom, des.shipTo, po.transResp \n" +
                    "from PurchaseOrder po \n" +
                    "join purchaseorder_origin_address porg on po.id=porg.PurchaseOrder_id\n" +
                    "join origin_address org on org.ID=porg.originAddresses_ID\n" +
                    "join purchaseorder_destination_address pd on po.id=pd.PurchaseOrder_id\n" +
                    "join destination_address des on des.ID=pd.destinationAddresses_ID ";

            SQLQuery query = session.createSQLQuery(sqlQuery);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            /*query.setFirstResult(RetrieveAction.count*5);
            RetrieveAction.count++;
            query.setMaxResults(5);*/
            poList = query.list();
            tx.commit();
            session.close();
            for(Object po : poList){
                Map m = (Map) po;
                Output output = new Output();
                output.setPoNumber((int)m.get("poNumber"));
                output.setSupplier(m.get("seller_vendor").toString());
                output.setDueDate((Date) m.get("dueDate"));
                output.setStatus(m.get("status").toString());
                output.setPriority(m.get("priority").toString());
                output.setShipfrom(m.get("shipFrom").toString());
                output.setShipto(m.get("shipTo").toString());
                output.setTransresp(m.get("transResp").toString());
                outputList.add(output);
            }

            return outputList;

        } catch (Exception e) {
            System.err.println("Error getting Users :" + e.getMessage());
            session.getTransaction().rollback();
        }
        return outputList;
    }
}
