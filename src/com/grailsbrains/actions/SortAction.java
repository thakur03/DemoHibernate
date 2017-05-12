package com.grailsbrains.actions;

import com.grailsbrains.compare.*;
import com.grailsbrains.manage.Output;
import com.grailsbrains.manage.POManage;
import com.grailsbrains.persistence.PurchaseOrder;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Ajeet on 5/10/2017.
 */
public class SortAction extends Action  {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        POManage poManage = new POManage();
        List<Output> poList = poManage.viewOrders();

        if(request.getParameter("act").equalsIgnoreCase("ponumber"))
            Collections.sort(poList,new NumberComparator());
        if(request.getParameter("act").equalsIgnoreCase("seller"))
            Collections.sort(poList,new SupplierComparator());
        if(request.getParameter("act").equalsIgnoreCase("duedate"))
            Collections.sort(poList,new DueDateComparator());
        if(request.getParameter("act").equalsIgnoreCase("status"))
            Collections.sort(poList,new StatusComparator());
        if(request.getParameter("act").equalsIgnoreCase("priority"))
            Collections.sort(poList,new PriorityComparator());
        if(request.getParameter("act").equalsIgnoreCase("shipfrom"))
            Collections.sort(poList,new ShipFromComparator());
        if(request.getParameter("act").equalsIgnoreCase("shipto"))
            Collections.sort(poList, new ShipToComparator());
        if(request.getParameter("act").equalsIgnoreCase("transresp"))
            Collections.sort(poList,new TransComparator());

        request.setAttribute("finalList", poList);
        return mapping.findForward("success");
    }

}
