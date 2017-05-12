package com.grailsbrains.actions;

import com.grailsbrains.manage.Output;
import com.grailsbrains.manage.POManage;
import com.grailsbrains.persistence.PurchaseOrder;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ajeet on 5/9/2017.
 */
public class RetrieveAction extends Action {
    public static int count=0;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        POManage poManage = new POManage();
        List<Output> orderList = poManage.viewOrders();
        for(Output o: orderList){
            System.out.println(o.getPoNumber());
            System.out.println(o.getDueDate());
            System.out.println(o.getStatus());
        }

        request.setAttribute("finalList", orderList);
        return mapping.findForward("success");
    }
}
