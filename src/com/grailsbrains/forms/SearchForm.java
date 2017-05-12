package com.grailsbrains.forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ajeet on 5/9/2017.
 */
public class SearchForm extends ActionForm {

   private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public SearchForm(String search) {
        this.search = search;
    }
    public SearchForm() { }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        return super.validate(mapping, request);
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "search='" + search + '\'' +
                '}';
    }
}
