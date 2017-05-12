<jsp:include page="header.jsp"/>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.grailsbrains.persistence.PurchaseOrder" %>
<%@ page import="com.grailsbrains.manage.Output" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="container-fluid">
	<div class="row bg-grey">
		<div class="para">
			<p>PURCHASE ORDER LIST</p>
		</div>
	</div>
	<div >
		<form action="sort.do">
		<table id="indextable" class="nav nav-pills nav-justified table-condensed table-striped sortable" >
			<thead>
			<tr class="textcolour" style="background-color:#0080ff;">
				<th><input type="checkbox" name="selectall" id="selectall" ></th>
				<th><button name="act" value="ponumber" style="background-color:#0080ff; border:0px">P.O. Number</button></th>
				<th><button name="act" value="seller" style="background-color:#0080ff; border:0px">Supplier</button></th>
				<th><button name="act" value="duedate" style="background-color:#0080ff; border:0px">Due Date</button></th>
				<th><button name="act" value="status" style="background-color:#0080ff; border:0px">P.O. Status</button></th>
				<th><button name="act" value="priority" style="background-color:#0080ff; border:0px">Priority</button></th>
				<th><button name="act" value="shipfrom" style="background-color:#0080ff; border:0px">Ship From</button></th>
				<th><button name="act" value="shipto" style="background-color:#0080ff; border:0px">Ship To</button></th>
				<th><button name="act" value="transresp" style="background-color:#0080ff; border:0px">Trans. Resp.</button></th>
			</tr>
			</thead>
			<%
				ArrayList<Output> arrList = (ArrayList) request.getAttribute("finalList");

				for(Output o : arrList){

			%>
			<tbody>
			<tr>
				<td><input type="checkbox" class="checkbox" name="check[]" ></td>
				<td><%= o.getPoNumber() %></td>
				<td><%= o.getSupplier() %></td>
				<td><%= o.getDueDate() %></td>
				<td><%= o.getStatus() %></td>
				<td><%= o.getPriority() %></td>
				<td><%= o.getShipfrom() %></td>
				<td><%= o.getShipto() %></td>
				<td><%= o.getTransresp() %></td>
			</tr>
			</tbody>
			<% }%>
		</table>
		</form>
	</div>
	<br><br>
	<div class="row" style="text-align: left;">
		<div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-10 col-xs-offset-7 col-lg-1 col-md-1 col-sm-2 col-xs-3">
			<form action="POData.do">
				<input type="submit" value="NEXT">
			</form>
		</div>
	</div>
	<br><br>
	<div class="row" style="text-align: left;">
		<div class="col-lg-offset-5 col-md-offset-5 col-sm-offset-5 col-xs-offset-3 col-lg-1 col-md-1 col-sm-2 col-xs-3">
			<button class="btn btn-primary btn-block" name="edit" id="edit">Edit</button>
		</div>
		<div class="col-lg-1 col-md-1 col-sm-2 col-xs-3">
			<button class="btn btn-primary btn-block" name="delete" id="delete">Delete</button>
		</div>
	</div>
</div>

	<script  type="text/javascript">
	var select_all = document.getElementById("select_all"); //select all checkbox
	var checkboxes = document.getElementsByClassName("checkbox"); //checkbox items

	//select all checkboxes
	select_all.addEventListener("change", function(e){
	    for (i = 0; i < checkboxes.length; i++) { 
	        checkboxes[i].checked = select_all.checked;
	    }
	});


	for (var i = 0; i < checkboxes.length; i++) {
	    checkboxes[i].addEventListener('change', function(e){ //".checkbox" change 
	        //uncheck "select all", if one of the listed checkbox item is unchecked
	        if(this.checked == false){
	            select_all.checked = false;
	        }
	        //check "select all" if all checkbox items are checked
	        if(document.querySelectorAll('.checkbox:checked').length == checkboxes.length){
	            select_all.checked = true;
	        }
	    });
	}


</script>
</body>
</html>