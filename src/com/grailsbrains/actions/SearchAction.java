package com.grailsbrains.actions;

import com.grailsbrains.forms.SearchForm;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ajeet on 5/9/2017.
 */
public class SearchAction  extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        SearchForm searchForm = (SearchForm) form;
        String query = request.getQueryString();
        String [] param = query.split("&");
        for(int i=0; i<param.length; i++){
            String[] queryAttribute = param[i].split("=");
        }

        return mapping.findForward("success");
    }
}
